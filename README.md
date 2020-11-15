# Docker Template for RMI Courseworks 🐳

> `Coursework 3` Branch | For Coursework 3 | (check the branch list for available templates)

This repo is a good template if you want to run your RMI work using Docker. This would mean that you do not need to install Java on computer to build/run your code and the RMI registry.

In here is just the calculator example that can be found on Moodle.

> Tested on Docker for Mac and Linux and Windows 10

This template **does not** use docker swarm! It also assumes you are **not** using JGroups. If you are using JGroups, you can remove Redis and Redis helper code.

---

## Requires

  - Docker Engine
  - Docker CLI
  - Docker Compose

## How
1. Run: `docker network create rmicw` to create a network for containers to communicate over.
2. Clone me from this git repo: `git clone https://github.com/scc311/rmi-docker-template -b cw3 rmi-cw`
3. Change to the cloned root directory: `cd rmi-cw` (this should put you in the same directory as this README)
4. Make sure your client code is in the `client-code` directory.
5. Update the `client-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
   - (without the .java extension)
6. Any reference to `localhost` in your client (specifically your rmi lookup), needs to be replaced with `DockerUtility.getRegistryHost()`.
7. Make sure your rmi server code is in the `middleware-code` directory.
8. Update the `middleware-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
   - (without the .java extension)
9. Make sure your interface code is in the `interface-code` directory.
10. Make sure your replica server code is in the `server-code` directory.
11. Update the `server-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
    - (without the .java extension)
12. From the root directory of those folders (the one with this README in)
    1. To build your code (or re-build after you make changes), run: `docker-compose build`
    2. To run the registry, middlware-server, and rmi client, run: `docker-compose up`
    3. Use `Ctrl-C` to get out of the container's tty.

You should now have 1 instance of each of the services active in docker (`docker ps` to check). A redis instance will also be active.

> ⚠️ The container images will contain your coursework! **DO NOT** push the built images to a public container registry!

---

## Adding Replicas

Once the prior steps are complete, adding a server replica can be done like so:
```bash
docker run --rm --name <replica-name> -it -e REDIS_HOST=redis -e PORT=<port number> --network rmicw rmicw-server
```
Give your replica a name and a port number (if you're not using jgroups). Remove `-it` to run it in the background.

To stop your replica, run:
```bash
docker stop <replica-name>
```

---

## Adding Clients

Once the prior steps are complete, adding another client can be done like so, provided you are in the same directory as the docker compose file:
```bash
docker run --rm --name <client-name> -it -v $(pwd)/shared:/shared -e REGISTRY_HOST=middleware-server --network rmicw rmicw-client
```
Give your client a container name to help with stopping it.

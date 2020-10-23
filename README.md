# Docker Template for RMI Courseworks 🐳

> `Coursework 1` Branch (check the branch list for available templates)

This repo is a good template if you want to run your RMI work using Docker. This would mean that you do not need to install Java on computer to build/run your code and the RMI registry.

In here is just the calculator example that can be found on Moodle.

> Tested on Docker for Mac and Linux

---

## Requires

  - Docker Engine
  - Docker CLI
  - Docker Compose

## How

  1. Clone me from this git repo: `git clone https://github.com/scc311/rmi-docker-template -b cw1 rmi-cw`
  2. Change to the cloned root directory: `cd rmi-cw` (this should put you in the same directory as this README)
  3. Make sure your client code is in the `client-code` directory.
  4. Update the `client-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
     - (without the .java extension)
  5. Any reference to `localhost` in your client (specifically your rmi lookup), needs to be replaced with `DockerUtility.getRegistryHost()`.
  6. Make sure your server code is in the `server-code` directory.
  7. Update the `server-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
     - (without the .java extension)
  8. Make sure your interface code is in the `interface-code` directory.
  9.  From the root directory of those 3 folders (the one with this README in)
     1. To build your code (or re-build after you make changes), run: `docker-compose build`
     2. To run the registry, server, and client, run: `docker-compose up`
     3. Use `Ctrl-C` to get out of the container's tty.

> ⚠️ The container images will contain your coursework! **DO NOT** push the built images to a public container registry!

---

## How [without docker-compose]

> 🚨 Life is easier with compose, so you don't really *need* this...

 - Much like in the steps above, make sure you code is divided up and in the correct directories. These steps just replace step 9. 
 - All command below should be run from the root directory. 
 - If you can, use `tmux` or different terminal windows for the client and server.

### Build & Run the Server

  1. From the root directory (with the README in), run the following to build the container image (and your server code):
       ```bash
       docker build --rm -f server-code/Dockerfile -t rmi-server .
       ```
  2. Next, to run your server (and simultaneously start the registry), run:
       ```bash
       docker run --rm -it --network host --privileged rmi-server
       ```

### Build & Run the Client

  1. From the root directory (with the README in), run the following to build the container image (and your client code):
       ```bash
       docker build --rm -f client-code/Dockerfile -t rmi-client .
       ```
  2. Next, to run your client, run:
       ```bash
       docker run --rm -it --network host --privileged rmi-client
       ```

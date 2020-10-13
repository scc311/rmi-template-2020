# Docker Template for RMI Courseworks 🐳

This repo is a good template if you want to run your RMI work using Docker. This would mean that you do no need to install Java on computer to build/run your code and the RMI registry.

In here is just the calculator example that can be found on Moodle.

> Tested on Docker for Mac and Linux

## Requires

  - Docker Engine
  - Docker CLI
  - Docker Compose

## How

  1. Clone me from this git repo: `git clone https://github.com/scc311/rmi-docker-template`
  2. Make sure your client code is in the `client-code` directory.
  3. Update the `client-code/Dockerfile`'s entrypoint to the file with the name of the file with your `main` in it.
     - (without the .java extension)
  4. Make sure your server code is in the `server-code` directory.
  5. Update the `server-code/entrypoint.sh`'s java command to the file with the name of the file with your `main` in it.
     - (without the .java extension)
  6. Make sure your interface code is in the `interface-code` directory.
  7. From the root directory of those 3 folders (the one with this README in)
     1. To build your code (or re-build after you make changes), run: `docker-compose build`)
     2. To run the registry, server, and client, run: `docker-compose up`
     3. Use `Ctrl-C` to get out of the container's tty.

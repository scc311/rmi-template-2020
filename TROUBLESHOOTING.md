# TroubleShooting ⚠️

 - If you are getting errors such as these (often on Windows hosts):
    ```
    rmi-server | Running JAVA RMI Registry...
    rmi-server | Running Your Server...
    : not found| entrypoint.sh: 2: entrypoint.sh: 
    : not found| entrypoint.sh: 4: entrypoint.sh: 
    rmi-server | sleep: invalid time interval ‘1\r’
    rmi-server | Try 'sleep --help' for more information.
    : not found| entrypoint.sh: 6: entrypoint.sh: 
    : not found| entrypoint.sh: 8: entrypoint.sh: 
    rmi-server | Error: Could not find or load main class calculatorserver
    rmi-server exited with code 1
    ```
    You should make sure your line endings are fixed to `LF` not `CRLF`. This can be done in a VS code window (see the `CRLF` near the bottom right of the window).
    It can also be fixed by setting git to not set the line endings: `git config --global core.autocrlf false`. (Thanks [@RyanWarren](https://github.com/rrryyaaannnnn))

    ![crlf issue](./screenshots/crlf-issue-vscode.gif)

 - If your client is not able to connect to the `localhost` rmi registry, this is because the client container and rmi registry do not share the same localhost. The `DockerUtility` class in the `interface-code` directory contains a static method `getRegistryHost` that can be used in place, returning `localhost` when not running in Docker, or returning the env var `REGISTRY_HOST` when in Docker.

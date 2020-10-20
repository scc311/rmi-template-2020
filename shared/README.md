# Shared Directory

You can use this space in both the server container and the client container. This is useful when using files to store data that both need access to. For example, you can store a key file here when using AES encryption. 

**You will find the contents of this directory at `/shared/...` in the container!**

E.g. If you create a key in the server code and write it to the file `/shared/key.txt`, the file will be found in `/shared/key.txt` in the client container. This will also survive restarts as it uses volume mounting.

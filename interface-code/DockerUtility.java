import java.util.stream.*;
import java.nio.file.*;
import java.io.*;

public class DockerUtility {

  public static String getRegistryHost() {

    boolean isDocker = false;

    try (Stream < String > stream =
      Files.lines(Paths.get("/proc/1/cgroup"))) {
      isDocker = stream.anyMatch(line -> line.contains("/docker"));
    } catch (IOException e) {
      System.out.println("Not running in Docker 😢");
    }
    if (isDocker) {
      System.out.println("Running in Docker! 🐳");
      if (System.getenv("REGISTRY_HOST") != null)
        return System.getenv("REGISTRY_HOST");
      System.out.println("🐳⚠️  Please set the REGISTRY_HOST environment variable!");
    }
    return "localhost";
  }

}
import redis.clients.jedis.*;

import java.lang.Math;
import java.net.*;
import java.io.*;
import java.util.*;

// Helper when using redis (and not JGroups)
// THIS IS JUST A TEMPLATE
// You will need to modify - add - remove

public class redisUtilities {

  public static String getHostnameFromEnv() {
    if (System.getenv("REDIS_HOST") != null)
      return System.getenv("REDIS_HOST");
    return "localhost";
  }

  public static boolean testRedis() {
    String hostname = getHostnameFromEnv();
    String testValue = String.valueOf(Math.random());
    System.out.println("Connecting to REDIS instance at: " + hostname);
    try (Jedis jedis = new Jedis(hostname)) {
      jedis.set("test-value", testValue);
      if (!testValue.equals(jedis.get("test-value"))) {
        System.out.println("Something is a little off here...");
        System.out.println("The returned value from redis did not match the value added....");
        return false;
      }
      System.out.println("REDIS working as expected!");
      return true;
    } catch(Exception e) {
      System.out.println("An exception occurred when testing REDIS");
      e.printStackTrace();
      return false;
    }
  }

  public static boolean registerSelf() {
    InetAddress localhost;
    try {
      localhost = InetAddress.getLocalHost(); 
    } catch(UnknownHostException e) {
      System.out.println("Failed to determine local IP");
      return false;
    }
    String myIP = localhost.getHostAddress().trim();

    String hostname = getHostnameFromEnv();

    try (Jedis jedis = new Jedis(hostname)) {
      jedis.lpush("servers", myIP+":"+System.getenv("PORT"));
      return true;
    } catch (Exception e) {
      System.out.println("REDIS: Failed To Register");
      return false;
    }
  }

  public static List<String> getNServers(int n) {
    String hostname = getHostnameFromEnv();
    try (Jedis jedis = new Jedis(hostname)) {
      return jedis.lrange("servers", 0 ,n); 
    } catch (Exception e) {
      System.out.println("REDIS: Failed To Get Server List");
      // Could maybe retry here???
      return null;
    }
  }

}

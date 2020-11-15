public class server {

  public static void main(String[] args) {
    if (!redisUtilities.testRedis()) {
      System.exit(1);
    }

    if (redisUtilities.registerSelf())
      System.exit(0);
    else
      System.exit(1);

  } 

}
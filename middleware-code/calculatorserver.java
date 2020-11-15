/*
	Code: calculator server		CalculatorServer.java
	Date: 10th October 2017

	Server code for hosting the CalculatorImpl object
*/

import java.util.*;
import java.lang.Thread;
import java.rmi.Naming;	//Import naming classes to bind to rmiregistry

public class calculatorserver {

  //calculatorserver constructor
  public calculatorserver() {

    // Test connectivity to REDIS instance
    if (!redisUtilities.testRedis()) {
      System.exit(1);
    }

    // Create service implementation
    try {
      calculator c = new calculatorimpl();
      Naming.rebind("rmi://localhost/CalculatorService", c);
    } 
    catch (Exception e) {
      System.out.println("Server Error: " + e);
    }

    // Wait to see if other servers register on redis...
    try {
      Thread.sleep(5000);
      List<String> servers = redisUtilities.getNServers(3);
      for(int i = 0; i<servers.size(); i++) { 
        System.out.println("Sever " +(i+1)+" IP: "+servers.get(i)); 
      } 
    } catch (InterruptedException e) {
      System.out.println("Wait Failed");
      System.exit(1);
    }
    
    
  }

  public static void main(String args[]) {
    //Create the new Calculator server
	  new calculatorserver();
  }

}

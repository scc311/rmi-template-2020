/*
	Code: Calculator client		calculatorClient.java
	Date: 10th October 2017

	Simple client program that remotely calls a set of arithmetic
	methods available on the remote calculatorimpl object

*/

import java.rmi.Naming;			//Import the rmi naming - so you can lookup remote object
import java.rmi.RemoteException;	//Import the RemoteException class so you can catch it
import java.net.MalformedURLException;	//Import the MalformedURLException class so you can catch it
import java.rmi.NotBoundException;	//Import the NotBoundException class so you can catch it

public class calculatorclient {

    public static void main(String[] args) {
        
	try {

	    // Create the reference to the remote object through the remiregistry			
            calculator c = (calculator)
                           Naming.lookup("rmi://localhost/CalculatorService");
            
	    // Now use the reference c to call remote methods
	    System.out.println("3+21="+ c.add(3, 21) );		
            System.out.println("18-9="+ c.sub(18, 9) );
            System.out.println("4*17="+ c.mul(4, 17) );
            System.out.println("70/10="+ c.div(70, 10) );
	    System.out.println("2^5="+ c.pow(2, 5) );
        }
        // Catch the exceptions that may occur - rubbish URL, Remote exception
	// Not bound exception or the arithmetic exception that may occur in 
	// one of the methods creates an arithmetic error (e.g. divide by zero)
	catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}

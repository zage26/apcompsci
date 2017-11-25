import java.util.Scanner;
import java.io.*;

public class flowchart_demo {
	
	public static void main(String args[]) {
	      int input1, input2;
	      Scanner scanner = new Scanner(System.in);
	      try {
	    	 System.out.print("Please enter the number you wish to divide: ");
	    	 input1 = scanner.nextInt();
	    	 //Please enter zero for this one
	    	 System.out.print("Please enter the number you wish to divide by: ");
	    	 input2 = scanner.nextInt();
	         int result = input1/input2;
	         System.out.println("Result: " + input1 + "/" + input2);
	      }
	      catch (ArithmeticException e) { 
	    	  //The error
	    	  System.out.println("Warning: ArithmeticException");
	      }
	      /*This little program demonstrates how my flowchart works.
	  	 * When the program is run, an exception, or more specifically,
	  	 * a run time error is found. Then the exception uses the try-
	  	 * catch block to return an error to the user. 
	  	 */
	   }
	
}

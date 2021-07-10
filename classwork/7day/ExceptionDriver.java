import java.io.*;
import java.util.*;

public class ExceptionDriver {

  /*public String getMessage()
Returns a detailed message about the exception that has occurred. This message is initialized in the Throwable constructor.

public Throwable getCause()
Returns the cause of the exception as represented by a Throwable object.

public String toString()
Returns the name of the class concatenated with the result of getMessage().


public void printStackTrace()
Prints the result of toString() along with the stack trace to System.err, the error output stream.


public StackTraceElement [] getStackTrace()
Returns an array containing each element on the stack trace. The element at index 0 represents the top of the call stack, and the last element in the array represents the method at the bottom of the call stack.


public Throwable fillInStackTrace()
Fills the stack trace of this Throwable object with the current stack trace, adding to any previous information in the stack trace.
*/
  public static void main(String[] args) {
    int[] a = new int[5];
    //a[10] = 100; ////exception out of bounds
    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
    //Index 10 out of bounds for length 5
    //	at ExceptionDriver.main(ExceptionDriver.java:8)

    //System.out.println( 4/0 );  //divide by zero error
    //System.out.println( 4%0 );  //divide by zero error

    Node n;
    n.setNext('hello');
    //no instantiated new node
    //Node n - defines it as a variable but hasn't set it to point or given data

    try {  //try to do this thing code which is prone to exceptions is placed in the try block
   // Protected code
 } catch (ExceptionName e1) { //
    // Catch block if it doesn't work do this thing, declare the type of exception you are trying to catch
    }

//throw keyword is used to 

  }//end main
}// end method

import java.util.*;
import java.lang.*;

public class tester {


public static int[] someBS (int[] abc){
  for (int i = 0; i < 10; i++){
    abc[i] = i;
    System.out.println(Arrays.toString(abc[i]));
  }
  return abc[i];
}

/*public static void zoop() {
    baffle();
    System.out.print("You wugga ");
    baffle();
}

//public static void main(String[] args) {
    System.out.print("No, I ");
    zoop();
    System.out.print("I ");
    baffle();
}

public static void baffle() {
    System.out.print("wug");
    ping();
}

public static void ping() {
    System.out.println(".");
    baffle();
}

}*/



/*public static int factorial (int y) {
    int factCalc = y;
    //iterates through once less than y, i increases by 1 each iteration
    for (int i = 1; i <= y-1; i +=1) {
      factCalc =  factCalc * i; // calcs upwards, starting with 1 up to one less y,
      //since multiplication is commutative, the output is the same
      //System.out.println(factCalc); for testing functionality
    }
    //System.out.println("Factorial " + y + " is equal to " + factCalc);
    return factCalc;
  }

public static int power (int x, int n) {
  int powerCalc = x; holds calc
  int powerTo = x; //sets variable to calcuate with
  //while loop remains above 1 to allow the correct number of powers since the
  //first iteration multiplies the number twice, the total number of iterations is minus one
  while (n > 1) {
    powerCalc = powerCalc * powerTo;
    //System.out.println(powerCalc); to test functionality
    n -= 1; //iterates through
  }
  return powerCalc;
}

public static double myexp (int x, int n) {
  int expCalc = (1 + x);
  for (int i = 2; i <= n; i += 1){
    int power = Math.pow()
    expCalc += Math.pow(x,i)/factorial(i);
    System.out.println(expCalc);
  }
  return expCalc;
}
public static void main(String[] args) {
  myexp(3,3);
}
}


public class dayZero {

  public static void helloWorld(){
    System.out.println("Hello World!");
    System.out.println("Look what I made:");
  }

  public static int recursiveFactorial (int n) {
    if (n >= 1) {
      return n * recursiveFactorial(n -1);
    } else {
      return 1;
    }
  }


//recursive Fibonacci sequence
//
  public static int recursiveFib (int f) {
    if (f <= 1) {
        return f;
      }
    return recursiveFib(f-1) + recursiveFib (f-2);
  } //ends method

  //keeping this mistake to show kids and ask them to figure it out
  public static int recursiveFibMistake (int f) {
    if (f >= 1) {
        return recursiveFib(f-1) + recursiveFib (f-2);
      } else {
    return f;
  } //ends method
}

  public static int ack (int ackOne, int ackTwo) {
    int answer;
    if (ackOne == 0) {
      //System.out.println(ackTwo + 1);
      return ackTwo + 1;
    }
   if (ackOne > 0 && ackTwo == 0) {
     //System.out.println(ack(ackOne - 1, 1));
     return (ack (ackOne - 1, 1));
    }
    //System.out.println(ack(ackOne - 1, ack (ackOne,ackTwo-1)));
    return ack(ackOne - 1, ack (ackOne,ackTwo-1));
  }
*/
}
  public static void main(String[] args) {

    someBS();

    /*System.out.println(recursiveFactorial(6));

    for (int i = 1; i <= 10; i++){
      System.out.print("The Fib # of " + i + " is ");
      System.out.println(recursiveFibMistake(i));
    }
  }*/



}

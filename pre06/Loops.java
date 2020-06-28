import java.util.*;
import java.lang.Math;

public class Loops {

  public static int power (int x, int n) {
    int powerCalc = x; //vaiable to hold calculations
    int powerTo = x; //variable to calcuate with
    //while loop remains above 1 to allow the correct number of powers since the
    //first iteration multiplies the number twice, the total number of iterations is minus one
    while (n > 1) {
      powerCalc = powerCalc * x;
      //System.out.println(powerCalc); //to test functionality
      n -= 1; //iterates through
    }
    //System.out.println(x + " to the " + powerTo + " power equals " + powerCalc);
    return powerCalc;
  }



  public static int factorial (int y) {
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
/*I know NOTHING about e and so despite looking at your video after to check import junit.framework.TestCase;
- I'm unclear if this is the right answer. test cases and expected values would have helped enormously
for non-math majors. At this point myexp had identical info fo 1,10 and didnt seem to for 3,10
but at this point it's my understanding of math being penalized not my understanding of
java  */
  public static double myexp (int x, int n) {
    int power = 0;
    int factorial = 0;
    double expCalcDiff = 0.0;
    double finalCalc = 0.0;
    for (int i = 0; i < n; i += 1){
      power = power(x,i);
        //System.out.println(power);
      factorial = factorial (i);
        //System.out.println(factorial);
      expCalcDiff = (double)power/(double)factorial;
      finalCalc = expCalcDiff + finalCalc;
    }
  //  double finalCalc = (double) expCalc;
    System.out.println(expCalcDiff);
    return finalCalc;
  }

  public static double myBetterExp (int x, int n) {
    int numerator = 1;
    int denominator = 1;
    double calcAns = 0.0;
    double returnAns = 1.0;
    if (n == 0) {
      return returnAns;
    }
    for (int i = 1; i < n; i++){
      numerator = numerator * x;
        //System.out.println(numerator); checks numerator
      denominator = denominator *i ;
        //System.out.println(factorial); checks denom]
        //double converts to double while dividing num by denom
      calcAns = (double)numerator/(double)denominator;
      //System.out.println(calcAns);
      returnAns = returnAns + calcAns;
      //System.out.println(returnAns);
    }
      //print out final answer
    System.out.print(returnAns);
    return returnAns;
  }
//EXERCISE 5, #3
  public static void check (int x, int y) {
    double doubleX = (double) x;
    double doubleY = (double) y;
    System.out.print(x + "        ");
    System.out.print(myBetterExp(x, y)+ "        ");
    System.out.println(Math.exp(doubleX) + "        ");

  }
// ex 5 with double intake becauce we suddenly need that
  public static double checkWithDouble (double x, int y) {
    int intX = (int) x;
    double doubleY = (double) y;
    System.out.print(intX + "        ");
    System.out.print(myBetterExp(intX, y)+ "        ");
    System.out.println(Math.exp(x) + "        ");
    return x;
  }
  public static void main(String[] args) {
    ///power(0, 0);
    //factorial(9);
    //myexp (101,10);
    //myBetterExp(1,10);
    //System.out.println("I'm using check below to test my method above: ");
    //EXERCISE # 5, #4
    //check (1,10);
    //System.out.println("I'm using the double check below to test my method above: ");
    //checkWithDouble(1,10);

//for 0.1 and 1.0 it has the same digits for 10.0 and 100.00 none.
//further from zero on the negative line, the less acurate. .1 is similar for ~6 digits.
    for (double i = 0.1; i <=1000; i *=10) {
        System.out.println(checkWithDouble(i, 10));
        System.out.println(checkWithDouble(i*-1, 10));
  }
  }
}

import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Random;

public class dayZero {

  public static void helloWorld(){       //method to print a hello
    System.out.println("Hello World!");   //print statement
    System.out.println("Look what I made:");  //print statement
  }

  public static int recursiveFactorial (int n) {  //a recusive method to calculate factorials
    if (n >= 1) {                               //checks to see if n is greater than or equal to 1
      return n * recursiveFactorial(n -1);      //if so the function runs the number it was called on times the method run on itself minus one
    } else {                              //if not we've reached the base case
      return 1;                                 //so we return one
    }
  }


  public static int recursiveFib (int f) {  //recursive Fibonacci sequence
    if (f <= 1) {                           //if statement checks if the number is less than equal to 1
        return f;                           //and returns that #, since 0 is 0 and 1 is 1
      }
    return recursiveFib(f-1) + recursiveFib (f-2);    //otherwise it returns the method itself
  } //ends method


//recursive Fibonacci sequence mistake.
//keeping to show kids ask them to figure out why it's the same absolute number
//but negative
/*  public static int recursiveFibMistake (int f) {
    if (f >= 1) {
      return recursiveFib(f-1) + recursiveFib (f-2);
    } else {
      return f;
    } //ends else

  } //ends method
*/



//recusive Ackermann method
  public static int ack (int ackOne, int ackTwo) { //ackerman method takes two ints as input
    if (ackOne == 0) {                            //checks if First val is equal to zero,
      //System.out.println(ackTwo + 1);
      return ackTwo + 1;                            //return second val plus one
    }
   if (ackOne > 0 && ackTwo == 0) {                 //checks if the first # is greate than 0 and the other is equal to 0
                                                      //if statements with ands must have both conditions of the if statement true. if the first is true, it checks second
     //System.out.println(ack(ackOne - 1, 1));      //if not it stops and moves on
     return (ack (ackOne - 1, 1));                  //recusive method returns itself with the input value minus one, and one
    }
    //System.out.println(ack(ackOne - 1, ack (ackOne,ackTwo-1)));
    return ack(ackOne - 1, ack (ackOne,ackTwo-1));    //if it is not true, it runs it has not yet met the base case
  }                                                   //itself run with itself the original value minus one as one conditioon and the method run again with the first val and the second minus one as the second value


//sums the total of an Array
  public static int sum (int [] a){       //input is an Array
    int sumTotal = 0;                             //defines a variable to 0 to hold the sum
    for (int i = 0; i < a.length; i++) {          //uses a for loop to iterate thru the Array
      sumTotal = sumTotal + a[i];               //sum total is set to itself plus the
    }
    //System.out.println(sumTotal);
    return sumTotal;                              //returns sum
  }

  public static int recursiveSum (int [] a){  //recusive sum total helper method
    int length = (int)a.length-1;         //defines length as an int using val of list minus one to avoid OOB error given 0 start
    return recursiveSumHelper(a, length);  //uses sum method to avoid user needing to account for 0 start
  }                                         //takes only the array does wok inside.

  public static int recursiveSumHelper (int [] a, int n){   //inside the recursiveSum method takes both the array and uses length of list - must be minus one
    if (n == 0) {     //checks for empty list
      return a[0];      //returns empty list
    } else {        //otherwise
    //System.out.println(recursiveSum(a, n-1) + a [n]);
    return a[n] + recursiveSumHelper(a, n-1);  //adds current list item - starting at end of list and working downward
  }                                           //adding that item to itself called with the same list but iterating to a lower item each time.
  }
// sums the total of an Array btwn two specified elements

  /*public static int recursiveSumBtwn (int [] arr, int b, int c) {   //recusive
    int sumTotal = 0;
    if (b == c){
      return arr[b];
    }
      sumTotal = sumTotal + arr[i];
    }
    //System.out.println(sumTotal);
    return sumTotal;

  }*/



  public static void main(String[] args) {


System.out.print("the factorial of " + 5 + " is ");
    System.out.println(recursiveFactorial(5));

//System.out.print("fib test series below ");
  //  for (int i = 1; i <= 10; i++){
  //    System.out.print("The Fib # of " + i + " is ");
  //    System.out.println(recursiveFib(i));
  //  }
// creates a list of 10 random numbers
    int[] listSum = new int[10];
    for (int i = 0; i < listSum.length; i++){
      listSum[i]= (int)(Math.random()*100 + 1);
    }
    //tests recursive sum
    System.out.println(Arrays.toString(listSum));

    //recursiveSum(listSum, 9);
    System.out.println(recursiveSum(listSum));

    //System.out.println(recursiveSumBtwn(listSum, 1, 3));
  }

}

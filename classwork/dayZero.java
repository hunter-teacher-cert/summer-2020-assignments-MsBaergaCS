import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Random;

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


  public static int recursiveFib (int f) {
    if (f <= 1) {
        return f;
      }
    return recursiveFib(f-1) + recursiveFib (f-2);
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


//sums the total of an Array
  public static int recursiveSum(int [] a){
    int sumTotal = 1;
    for (int i = 0; i < a.length; i++) {
      sumTotal = sumTotal + a[i];
    }
    //System.out.println(sumTotal);
    return sumTotal;

  }
// sums the total of an Array btwn two specified elements

  public static int recursiveSumBtwn (int [] arr, int b, int c) {
    int sumTotal = 0;
    if (b == c){
      return arr[b];
    }
    for (int i = b; i <= c; i++) {
      sumTotal = sumTotal + arr[i];
    }
    //System.out.println(sumTotal);
    return sumTotal;

  }



  public static void main(String[] args) {

    System.out.println(recursiveFactorial(6));

    for (int i = 1; i <= 10; i++){
      System.out.print("The Fib # of " + i + " is ");
      System.out.println(recursiveFib(i));
    }
// creates a list of 10 random numbers
    int[] listSum = new int[10];
    for (int i = 0; i < listSum.length; i++){
      listSum[i]= (int)(Math.random()*100 + 1);
    }
    //tests recursive sum
    System.out.println(Arrays.toString(listSum));
    System.out.println(recursiveSum(listSum));

    System.out.println(recursiveSumBtwn(listSum, 1, 3));
  }

}

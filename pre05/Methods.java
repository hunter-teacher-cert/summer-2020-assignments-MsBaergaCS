import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Methods {

  public static boolean isDivis (int n, int m) {
    if (n % m == 0) {
      System.out.println("Those numbers are divisible!");
      return true;
    } else {
      System.out.println("Those numbers are NOT divisible!");
      return false;
    }
 }

 public static boolean isTriangle (int a, int b, int c) {
   if (a + b < c || b + c < a || a + c < b) {
     System.out.println("Sorry - it's NOT a triangle!");
     return false;
   } else {
     System.out.println("Congratulations - it's a triangle!");
     return true;
   }

 }
  public static void main(String[] args) {
    int numberDivFirst;
    int numberDivSecond;
    Scanner numberInput = new Scanner(System.in);
    Scanner numberInput2 = new Scanner(System.in);
    System.out.println("Let's check if a two numbers are divisible.");
    System.out.print("Enter the first number:");
    numberDivFirst = numberInput.nextInt();
    System.out.print("Enter the second number:");
    numberDivSecond = numberInput2.nextInt();

    isDivis (numberDivFirst, numberDivSecond);

    int triNumOne;
    int triNumTwo;
    int triNumThree;
    Scanner triInput = new Scanner(System.in);
    Scanner triInput2 = new Scanner(System.in);
    Scanner triInput3 = new Scanner(System.in);
    System.out.println("Let's check if three numbers can make a triangle!");
    System.out.print("Enter the first number:");
    triNumOne = triInput.nextInt();
    System.out.print("Enter the second number:");
    triNumTwo = triInput2.nextInt();
    System.out.print("Enter the third number:");
    triNumThree = triInput3.nextInt();

    isTriangle (triNumOne, triNumTwo, triNumThree);
    }


}

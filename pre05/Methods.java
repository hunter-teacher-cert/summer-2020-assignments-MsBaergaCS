import java.util.*;
import java.lang.*;

public class Methods {

  public static boolean isDivis (int n, int m) {
    if (n % m == 0) {
      System.out.println("Those numbers are divisible!");
      return true;
    } else {
      System.out.println("Those numbers are divisible!");
      return false;
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

    }
}

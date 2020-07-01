import java.io.*;
import java.util.*;

public class dayOne {

  public static void main(String[] args) {

    // defines array this array has 10 spaces
    int[][] arr = new int [10][5];
    System.out.println(arr);
    popArray(arr);
    printArray(arr);

    int a = 'a';  //instantiate var a, store ascii code for 'a' in it
    System.out.println(a);
    a = 'b';      //overwrite content of a's mem location with ascii code for 'b
    System.out.println(a);
  } //end main
//goal is to print an array

  /*public static void sumArray {
    sum int = 0;
    for (int r = 0; r < a[r].length; r++) {
      sum += a[r][c];
    }

  }*/

  public static void printArray(int[][] a)  {
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c++){
      System.out.printf("%d", a[r][c]);
      } //end inner for statement
    System.out.println();
    }//end outer for

  }//end printArray

  public static void popArray(int[][] a)  {

    int value = 0;

    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c++){
        a[r][c] = value;
        value++;
      } //end c inner for statement
   }//end  r outer for
 }//end popArray
} //end dayOne class

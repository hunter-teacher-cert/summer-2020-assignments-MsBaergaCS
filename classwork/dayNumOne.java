import java.io.*;
import java.util.*;

public class dayNumOne {

  public static void main(String[] args) {

// creates 20 rows
//creates 20 columns
    int rows = 20;
    int cols = 20;

//creates a new 2d arrray called grids, which is made up of 20r 20c
    int[][] arr = new int[rows][cols];

//calls method to print 2d array
    //print2d(arr);
//calls rowPop method

    //rowPop(arr, 2, 10);

//calls colPop method
    colPop(arr, 3, 255);
    print2d(arr);
//calls invert method to invert 0s and 250s

    invert(arr);
    print2d(arr);
    System.out.println();

    diagonal(arr, 1, 3, 3, 1);

    print2d(arr);
  } //end main


//prints 2d array
  public static void print2d(int[][] a) {

//iterates through row
    for (int r=0; r < a.length; r++) {
//finishing each column across before moving to next row
      for (int c=0; c < a[r].length; c++) {

      System.out.printf("%03d ", a[r][c]);
      }//end column for loop
//prints line after each row of columns
      System.out.println();
    }//end row for loop

  }//end print2d

  public static void rowPop(int[][] a, int r, int value) {
    for (int c = 0; c < a[r].length; c++) {
      a[c][r] = value;
    }

  }//end rowPop

  public static void colPop(int[][] a, int c, int value) {
    for (int r = 0; r < a.length; r++){
      a[r][c] = value;
    }
  }//end rowPop

  public static void invert(int[][] a) {
    for (int r=0; r < a.length; r++) {
      for (int c=0; c < a[r].length; c++) {
        if(a[r][c] == 0){
          a[r][c]= 255 ;
        } else {
          a[r][c]= 0;
        } //end else
      } //end inner for
    } //end outer for
  }//end invert

  /*
    0: up + left
    1: up + right
    2: down + left
    3: down + right
   */

  // not woking
  public static void diagonal(int[][] a, int r, int c, int direction, int value) {
    while ((c >= 0) && (r >=0) && (r < a.length) && (c < a[r].length)){
      a[r][c] = value;
      if (direction == 0) { //dirr up/left
        r = r - 1;
        c = c - 1;
      }
      if (direction == 1){ //dir up/right
        r = r + 1;
        c = c + 1;
      }
      if (direction == 2){ //dir down/left
        r = r - 1;
        c = c - 1;
      }
      if (direction == 3){ //dir down/right
        r = r - 1;
        c = c + 1;
      }
    } //end while loop
  }//end diagonal

} //end class

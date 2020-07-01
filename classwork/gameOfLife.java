import java.io.*;
import java.util.*;

public class gameOfLife {


/*
i'll need 2d arrays
change values
apply GOL rules

*/

//this will create a new board of a 2d arrays chars w space rep'ing
//the entire board is empty

//**FUNCTIONAL**
public static char [][] createNewBoard (int rows, int cols) {
  char[][] board = new char [rows][cols];
  for (int r = 0; r < rows; r++){
    for (int c = 0; c < cols; c++){
      int sq = (int)(Math.random()*2 + 1);
      if (sq == 2){
        board[r][c] = ' ';
      } else{
        board[r][c] = 'X';
      } //end else condition
    } //end for Loops
  } //end outer for loop
  return board;
}//end method

//**FUNCTIONAL**
public static char [][] createBlankBoard (int rows, int cols) {
  char[][] board = new char [rows][cols];
  for (int r = 0; r < rows; r++){
    for (int c = 0; c < cols; c++){
        board[r][c] = ' ';
    } //end for Loops
  } //end outer for loop
  return board;
}//end method


//**FUNCTIONAL**
  public static void printBoard (char[][] board){
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c <board[r].length; c++){
        System.out.printf("%c", board[r][c]);
      }
      System.out.println();
    }
    System.out.println("\n\n------------------\n\n");
  }

  //**FUNCTIONAL**
  public static void setCell(char[][] board, int r, int c, char value){
    if (r>=0 && r < board.length && c >= 0 && c<board[r].length){
      board[r][c] = value;
    }
  }
  //count neighbors living around printBoard
  //lots of if statements
  //loop over grid using for loops [r-1][c-1] to [r+1][c+1]
  public static int countNeighbors(char[][] board, int r, int c){
    int count = 0;
    int rowNum = board.length;
    int colNum = board[0].length;

      for (int i = r-1; i <= r + 1; i++){
        for (int j = c-1; j <= c + 1; j++){
          if (i >= 0 && i < rowNum && j >= 0 && j < colNum) {
            if (i != r || j != c) {
              if (board[i][j] == 'X') {
              count++;
          }
        }
      }
    }
    }
    return count;
  }
  //given a board and a cell, look at neighbors and determine status
  //based on Conways GOL rules
  //determine if alive ('X') or dead ('')

  public static char getNextGenCell (char[][] board, int r, int c){
    char currentSq = board[r][c];
    int count = countNeighbors(board, r, c);
    if ((currentSq =='X') && (count > 3) || (count < 2)) {
      return ' ';
    }
    else if ((currentSq=='X')&&((count == 3) || (count == 2))){
      return 'X';
    }
    else if ((currentSq==' ')&&(count== 3)){
      return 'X';
    } else {
      return ' ';
    }
  }

//
  public static char[][] generateNextBoard(char[][] board){
    char newBoard[][] = new char[25][25];
    for (int r = 0; r < 25; r++){
      for (int c = 0; c < 25; c++){
          newBoard[r][c] = getNextGenCell(board, r, c);
      } //end for Loops
    } //end outer for loop
    // fill the new board
    return newBoard;
   }
//not able to call
  public static void animateBoard(char[][] board){

    //send ANSI control char to clear terminal and put cursor top left
      System.out.print("[0;0H\n");
      for (int row = 0; row < board.length ; row++) {
  	    for (int col = 0; col < board[row].length; col++) {
          System.out.print(board[row][col]);
  	    }
  	    System.out.println();
      }
      delay(1000);
    }
    //helper method to slow down animation
      public static void delay(int n)
      {
        try {
            Thread.sleep(n);
        }
        catch(InterruptedException e) {}
      }
// not able to call
  public static void main(String[] args) {
    System.out.println("Welcome to Game of Life");
    char[][] newboard;
    //creates blank board
    newboard = createBlankBoard(25,25);


    //below generates board with random pattern
    //newboard = createNewBoard(25,25);


    //System.out.println(newboard[5][6]);

    //setCell(newboard, 3, 5, 'X');


    //sets cells to 3 x's for blinking pattern test
  /*  setCell(newboard, 3, 3, 'X');
    setCell(newboard, 3, 4, 'X');
    setCell(newboard, 3, 5, 'X');

    //prints a new series of boards to test blinker
    printBoard(newboard);
    printBoard(generateNextBoard(newboard));
    printBoard(generateNextBoard(generateNextBoard(newboard)));
*/
    //test neighbor count when it is on a living square
  //  System.out.println(countNeighbors(newboard, 3,5));

    //test neighbor count when it is not on a living square
    //System.out.println(countNeighbors(newboard, 3,9));

    //System.out.println(getNextGenCell(newboard, 3,5));


    //init config to lead settle into stable oscillation of blinkers
        setCell(newboard,10,10,'X');
        setCell(newboard,10,9,'X');
        setCell(newboard,10,11,'X');
        setCell(newboard,9,10,'X');
        setCell(newboard,11,10,'X');

        //place glider at upper left
        /*
        setCell(board,0,1,'X');
        setCell(board,1,2,'X');
        setCell(board,2,0,'X');
        setCell(board,2,1,'X');
        setCell(board,2,2,'X');
        */

        //run for 100 "frames"
        for( int i=0; i<100; i++ ) {
          newboard = generateNextBoard(newboard);
          animateBoard(newboard);
        }
    //setCell(board, 3, 4, 'A');
    //printBoard(board);
    //setCell(board, 3, 3, 'Y');
    //printBoard(board);


  }
}

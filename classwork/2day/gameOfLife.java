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
  char[][] board = new char [rows][cols];   //gens new board
  for (int r = 0; r < rows; r++){         //follows rows
    for (int c = 0; c < cols; c++){         //follows columns
      int sq = (int)(Math.random()*10 + 1);   //for each sq generates a random value
      if (sq < 2){                          //if it is less than 2, i.e. about 1/10 chance
        board[r][c] = ' ';                //it prints a blank position
      } else{
        board[r][c] = 'X';                //otherwise it prints an x
      } //end else condition
    } //end for Loops
  } //end outer for loop
  return board;                       //returns entire double array
}//end method

//**FUNCTIONAL**
public static char [][] createBlankBoard (int rows, int cols) {
  char[][] board = new char [rows][cols]; //gens blank board
  for (int r = 0; r < rows; r++){     //follows rows
    for (int c = 0; c < cols; c++){     //follows columns
        board[r][c] = ' ';          //adds a space to that position
    } //end for Loops
  } //end outer for loop
  return board;             //returns double array holding blank board data
}//end method


//**FUNCTIONAL**
  public static void printBoard (char[][] board){
    for (int r = 0; r < board.length; r++){  //iterates thru board follows rows
      for (int c = 0; c <board[r].length; c++){  //follows columns
        System.out.printf("%c", board[r][c]); //prints the coordinates
      }
      System.out.println();
    }
    System.out.println("\n\n------------------\n\n");
  }

  //**FUNCTIONAL**
  public static void setCell(char[][] board, int r, int c, char value){
    if (r>=0 && r < board.length && c >= 0 && c<board[r].length){ //checks OOB
      board[r][c] = value;  //adds input value to the position given
    }
  }
  //count neighbors living around printBoard
  //lots of if statements
  //loop over grid using for loops [r-1][c-1] to [r+1][c+1]
  public static int countNeighbors(char[][] board, int r, int c){
    int count = 0;
    int rowNum = board.length;
    int colNum = board[0].length;

      for (int i = r-1; i <= r + 1; i++){  //outside loops checks rows
        for (int j = c-1; j <= c + 1; j++){   //inside loop checks columns
          if (i >= 0 && i < rowNum && j >= 0 && j < colNum) { //checks to see if it is in bounds
            if (i != r || j != c) {  //makes sure we dont count the square itself
              if (board[i][j] == 'X') {  //checks if it is present
              count++;                //adds to living count
          }
        }
      }
    }
    }
    return count;  //gives total living neighbor count
  }
  //given a board and a cell, look at neighbors and determine status
  //based on Conways GOL rules
  //determine if alive ('X') or dead ('')

  public static char getNextGenCell (char[][] board, int r, int c){
    char currentSq = board[r][c];       //sets individual square based on count neighbo method below, uses that to determine actions w series of if statements
    int count = countNeighbors(board, r, c);
    if ((currentSq =='X') && (count > 3) || (count < 2)) { //checks to see which conditions of
      return ' ';                                           //GOL rules are met, must have an x and either a count of more than 3 o less than 2
    }                                                       //kills or generates
    else if ((currentSq=='X')&&((count == 3) || (count == 2))){ //or maintains based on that data
      return 'X';                                           //checks to see if it is x and either equal to 2 o 3.
    }
    else if ((currentSq==' ')&&(count== 3)){    // if neither above condition is true it checks to see if
      return 'X';                               //it is blank (dead) and the neighbors count is 3
    } else {                                    //if so it generates a birth
      return ' ';                                 //otherwise no conditions met -- square is blank.
    }
  }

//
  public static char[][] generateNextBoard(char[][] board){
    char newBoard[][] = new char[25][25];     //using getNextGenCell, which builds off countNeighbors
    for (int r = 0; r < 25; r++){               //iterates thru a board and determines the value of each cell
      for (int c = 0; c < 25; c++){
          newBoard[r][c] = getNextGenCell(board, r, c); //saving each square as the value returned based off of the state of play on the previous game board
      } //end for Loops
    } //end outer for loop
    // fill the new board
    return newBoard;      //returns entire double array
   }
//not able to call
  public static void animateBoard(char[][] board){  //animates series of boards to allow visual of the game over a seies of turns

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
/*
        for( int i=0; i<100; i++ ) {
          newboard = generateNextBoard(newboard);
          printBoard(newboard);
        } */


    //setCell(board, 3, 4, 'A');
    //printBoard(board);
    //setCell(board, 3, 3, 'Y');
    //printBoard(board);


  }
}

import java.io.*;
import java.util.*;
/*
The Rules of Life:
Survivals: Every cell with 2 or 3 living neighbours survives for the next generation.
Death:
  * Each cell with >3 neighbours dies from overpopulation.
  * Every cell with <2 neighbours dies from isolation.
Birth:
  * Each dead cell adjacent to exactly 3 living neighbours is a birth cell.
  It will come alive next generation.
NOTA BENE:  All births and deaths occur simultaneously.
Together, they constitute a single generation
 */

class Life{

    /*
      create a new 2D array, fill it with ' '
      representing that the entire board is empty.
     */
    public static char[][] createNewBoard(int rows, int cols){

        char[][] board = new char[rows][cols];
	         for (int r = 0; r < rows; r++) {
	             for (int c = 0; c < cols; c++) {
		                  board[r][c] = ' ';
               } // end nested for
           } // end parent for statement
              return board;
         }// end char method


    public static void printBoard(char[][] board){
	       for (int r = 0; r < board.length; r++) {
	           for (int c = 0; c < board[r].length; c++) {
		             System.out.printf("%c",board[r][c]);
	           } //end nested for statement
	               System.out.println();
	       } // end parent for statement
	               System.out.println("\n\n------------------\n\n");
    } // end printBoard method

    /*
      set the cell (r,c) to value
    */
    public static void setCell(char[][] board, int r, int c, char val){
	         if (r>=0 && r<board.length && c>=0 && c<board[r].length){
	               board[r][c] = val;

                 //this is a rubber stamp like method--so this is good.
	         } // end if statement
    } // end setCell


    /*
       Count and return the number of living neighbors around board[r][c]
       approach 1 - lots of if statements
       approach 2 - you can loop over the grid from board[r-1][c-1]
                    to board[r+1][c+1]
    */
    public static int countNeighbors(char[][] board, int r, int c){

          int count=0;
          for (int i = r - 1; i <= r + 1; i++) {
              for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
                  if (i != r || j != c) {
                    if(board[i][j]=='X'){
                      count++;
                    } //end first if
                    } //end if statement looking for X
                  } //end count neighbors if condition
              } // end nested for loop
          } // end parent for loop
               //System.out.println(count);
               return count;

    } // end countNeighbors

    /*
      given a board and a cell, determine, based on the rules for
      Conway's GOL if the cell is alive ('X') or dead (' ') in the
      next generation.
     */
    public static char getNextGenCell(char[][] board,int r, int c){
	// calculate the number of living neighbors around board[r][c]
            char currentSquare= board[r][c];
            int count= countNeighbors(board,r,c);

            if (currentSquare=='X' && count > 3 || count < 2) {
              return' ';
            }

            if (currentSquare==' ' && count == 3)  {
              return'X';
            }

            if (currentSquare=='X' && count==3 || count==2) {
              return'X';
            }

	// determine if board[r][c] is living or dead
	//    if living and 2 3 neighbors then remain alive
	//    if dead and 3 neighbors then become alive

	return ' ';
    }
    /*
      scan the board to generate a NEW board with the
      next generation
    */

    public static char[][] generateNextBoard(char[][] board){

         char newBoard[][] = new char[25][25];

            for (int newR = 0; newR < newBoard.length; newR++) {
              for (int newC = 0; newC < newBoard.length; newC++) {

                    newBoard[newR][newC]= getNextGenCell(board,newR,newC);

             } // end nested for
         } // end parent for statement
	         return newBoard;
    } //end generateNextBoard method





    public static void main(String[] args) {
	       char[][] board;
	       board = createNewBoard(25,25);
         setCell(board,3,5,'X');
         setCell(board,3,6,'X');
         setCell(board,3,7,'X');
	       printBoard(board);
         countNeighbors(board,3,6);
         printBoard(board);
         printBoard(generateNextBoard(board));
         //printBoard(generateNextBoard(board));

    } // end main
} // end class

/* Learned: I CANNOT use the same variable names for rows and columns
within the nested for loops in different methods. I thought these were only
visible within the method...so that's definitely a clarification. */

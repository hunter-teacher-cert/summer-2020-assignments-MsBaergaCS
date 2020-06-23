//import java.util.Random; //import needed packages
//import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class Guess {
  public static void main(String[] args) {
    int numberGuess; //init var to hold guess
    //generate random #
    Random random = new Random();
    int number = random.nextInt(100) + 1;
    //provide game parameters
    //request & detect user's guess & assign to numberGuess
    Scanner numberInput = new Scanner(System.in);
    System.out.println("I'm thinking of a number btwn 1 and 100, inclusive. Can you guess it?");
    System.out.print("Enter a number:");
    numberGuess = numberInput.nextInt();
    //output # guessed
    System.out.println("You guessed " + numberGuess);
    //output correct #
    System.out.println("The number was " + number);
    //output difference btwn using absolute value to remove negative from #
    System.out.println("You were off by " + Math.abs(numberGuess-number));
  }
}

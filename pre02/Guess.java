import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class Guess {
  public static void main(String[] args) {
    int numberGuess;
    Random random = new Random();
    int number = random.nextInt(100) + 1;
    Scanner numberInput = new Scanner(System.in);
    System.out.println("I'm thinking of a number btwn 1 and 100, inclusive. Can you guess it?");
    System.out.print("Enter a number:");
    numberGuess = numberInput.nextInt();
    System.out.println("You guessed " + numberGuess);
    System.out.println("The number was " + number);
    System.out.println("You were off by " + Math.abs(numberGuess-number));
  }
}

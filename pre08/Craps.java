import java.util.Random;
import java.util.Scanner;

public class Craps {

//generates a random # using Random nextint and bound by parameter
  public static int roll (int n) {
    Random random = new Random();
    int number = random.nextInt(n) + 1;
    //System.out.println(number);// for testing
    return number;
  }

//takes in # of dice, used to determine iterations and value of dice to determine
//numbers to generate btwn
  public static int shoot (int dice, int value){
    int shootOutcome = 0;
    for (int i = 1; i <= dice; i++) {
    shootOutcome += roll(value);
    //System.out.println(shootOutcome);
    }
    //System.out.println(shootOutcome);
    return shootOutcome;
  }


  public static void round () {
    int thepoint = 0;
    int oneRoll = shoot(2,6);
    //conditional and or statements check for 2,3 oe 12 values indicating loss
    //and exiting
    if (oneRoll==2 || oneRoll==3|| oneRoll==12) {
        System.out.println("The shooter rolled a " + oneRoll);
        System.out.println("Craps! You lose.");
    } else if (oneRoll==7 ||oneRoll==11){            //checks for wins
       System.out.println("The shooter rolled a " + oneRoll);
       System.out.println("Natural! You win.");
    } else {
      thepoint = oneRoll;    //if neither above are met, roll is saved and
      System.out.println("The shooter rolled a " + oneRoll);
      System.out.println("The point is " + thepoint);
      int newRoll = shoot(2,6);
      // a new turn is initiated using a while condition to repeat play
      //until either loss or win is garnered
      while (newRoll != 12 && newRoll != thepoint){
        System.out.println("The shooter rolled a " + newRoll);
        System.out.println("That isn't a 7 or " + thepoint);
        newRoll = shoot(2,6);
      }
      if (newRoll == 7) { //under a 7, a loss
        System.out.println("That's a 7, you lose!");
      }
      if (newRoll == thepoint) {  //last roll is checked against new roll
        //a repeat of the saved value means a win
        System.out.println("The shooter rolled " + oneRoll);
        System.out.println("You win!");
      }
    }
  }
  public static void main(String[] args) {
    //input determines number of rolls
    Scanner in = new Scanner(System.in);
    System.out.println("How many rounds of Craps do you want to play?");
    int numRounds = in.nextInt();
    //a for loops is used to iterate up to number input by player
    for (int i = 1; i <= numRounds; i++) {
      round();
    }
    System.out.println("Game over!");
    //a repeat option could be be made using a while loop that checks against
    //a boolean value variable. the value would be true until game over was reached
    //upon which the player would be asked whether they desired to play again,
    //if so, the variable would return to true and play resumes
}
}

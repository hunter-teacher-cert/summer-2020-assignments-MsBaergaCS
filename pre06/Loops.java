public class Loops {

  public static int power (double x, int n) {
    int powerCalc = (int) x; //casts double into int to hold calculations
    int powerTo = (int) x; //casts double into int to calcuate with
    //while loop remains above 1 to allow the correct number of powers since the
    //first iteration multiplies the number twice, the total number of iterations is minus one
    while (n > 1) {
      powerCalc = powerCalc * powerTo;
      //System.out.println(powerCalc); to test functionality
      n -= 1; //iterates through
    }
    return powerCalc;
  }

  public static int factorial (int y) {
    int factCalc = y;
    //iterates through once less than y, i increases by 1 each iteration
    for (int i = 1; i <= y-1; i +=1) {
      factCalc =  factCalc * i; // calcs upwards, starting with 1 up to one less y,
      //since multiplication is commutative, the output is the same
      //System.out.println(factCalc); for testing functionality
    }
    System.out.println("Factorial " + y + " is equal to " + factCalc);
    return factCalc;
  }
  public static void main(String[] args) {
    power(5.0, 3);
    factorial(7);
  }

}

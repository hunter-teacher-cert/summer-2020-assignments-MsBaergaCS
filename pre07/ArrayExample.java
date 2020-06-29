import java.util.*;

public class ArrayExample {




// EXERCISE # 1, #1
  public static double[] powArray (double[] numberList, int x) {
    double[] powerArray = new double[numberList.length];
    for (int i = 0; i < numberList.length; i++) {
      powerArray[i] = Math.pow(numberList[i], x);
    }
   return powerArray;
  }

//EXERCISE #1, #2


public static int[] histogram(int[] scores, int counters) {
		int[] hist = new int[100];
		for (int i = 0; i < counters; i++) {
			hist[scores[i]]++;
		}
		return hist;
	}
// EXERCISE #4  this isnt a great one to use the enhanced for Loops
// because a regular for loop allows you to use the index to iterate through
// the list and also holds the value you want to return you'd need to track it anyway
//you could do it by replacing the for with the enhanced loop and creatinng a
//third int variable to hold i and use that to iterate through, changing it manually
//in the for loop each iteration after the close bracket on line 39, before the close bracket
//on line 40
 public static int indexOfMax(int[] a) {
		int maxIndex = 0;
    int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)  {
        max = a[i];
        maxIndex = i;
      }
    }
  return maxIndex;
 }
 
//whoops we don't have to do #8

/*public static int[] maxInRange (int[] arr, int lowIndex, int highIndex){
  if (indexOne == indexTwo) {
    return arr[lowIndex];
  }
  for (int i = lowIndex; i <= highIndex; i++){
    if
  }

}*/

public static boolean isPrime (int num) {
  if (num%2==0 && num>=Math.pow(2,2)) {
    return false;
  } else {
    for (int i = 3; i<=Math.sqrt(num); i+=2){
      if(num%i==0){
        return false;
      }
    }
    return true;
  }
}

public static boolean [] sieveofEratosthenes (int n){
  boolean[] sieve = new boolean [n];
  if (n == 0) {
    sieve[0] = false;
    return sieve;
  }
    else if (n == 1) {
      sieve[0] = false;
      sieve[1] = false;
      return sieve;
    }
      else {
        for (int i = 2; i < n; i++) {
          if (isPrime(i)){
          sieve [i] = true;
        } else {
          sieve [i]= false;
        }
      }
   return sieve;
 }
}
public static void main(String[] args) {
    double [] test = {4.0,2.0,5.0,8.0};
    // test power arrary using Array to string method & double Array
    //System.out.println(Arrays.toString(powArray(test, 2)));
    int[] a = {7, 45, 64, 22, 6};
    //test indexofmax method using print statement and an int array
    //System.out.println(indexOfMax(a));

    //System.out.println(Arrays.toString(histogram(a, 5)));

    //below check sieve of sieveofEratosthenes
    //System.out.println(Arrays.toString(sieveofEratosthenes(10)));
  }
}

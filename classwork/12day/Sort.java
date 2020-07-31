import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Sort {

//line 25 - linSearch - index search using linear search linSearch
//line 34 - findSmallest - finds index of smallest using double for loop linear search comparison
//line 48 - findSmallestVal - finds and returns smallest value in a list using double for loop linear
//line 61 - slice - splits a given list into a *new* smaller list based on indexes given
//line 71 - subgoals for mergeSort
//line 84 - mergo - method to combine two lists into numerical order
//line 116 - mergeSort - helper method overloaded
//line 119 - mergeSort - oveloaded with helper method, merge sort algorithm, uses slice and mergo to recursively
                  //split into smaller lists, merging them back together in order
//line 137 - quickSortWork -  sorts arraylist, using pivot in the middle version
//line 181 - quickSortTest - sorts Arrays using pivot in the middle version
//line 229 - swapHelperArrarys - helper method swaps two values on an array using a temp variables
//line 237 - quikSort - doesn't work all the time - keeping to explore
//line 279 - sortAlgorithm sort algoithm using linear search and the same array is returned
//line 295 - swapHelper - helper method swaps two values on an arraylist using temp variable
//line 304 - selectionSort - selection sort using nonabstracted temp variable to hold value before swapping no helper method
//line 322 - selectionSortAlg - selection sort using swapHelper method
//line 332 - prestoSortedArrayListo - given methods to create a random assorted list
//line 348 - prestoArrayListo - given method to create random unsorted list

  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) { //comments are better done for this method in Boogle
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }

  public static int findSmallest(ArrayList al, int lo, int hi){
    int index = 0; //start index at 0 by default but overwritten
    int smallestVal = (int)al.get(lo); //initialize smallestval as the lowest index val
    for (int i = lo; i < hi; i++){ //start at lowest and incrementing by one to highest index
      if ((int)al.get(i)<=smallestVal) { //if the new number is less than or equal to lowest numbers to account for dupes
        index = i; //then set index to new lowest number's index
        smallestVal = (int)al.get(i); //then set smallest value to new smallest value
      } //end if
    } //end inner for
    return index; //return smallest index
  } //end method


  //tester method - used with swap to practice
  public static int findSmallestVal(ArrayList al, int lo, int hi){
    int index = 0;   //start index at 0 by default but overwritten
    int smallestVal = (int)al.get(lo);//initialize smallestval as the lowest index val
    for (int i = lo; i < hi; i++){ //start at lowest and incrementing by one to highest index
      if ((int)al.get(i)< smallestVal) {//if the new number is less than or equal to lowest numbers to account for dupe
        index = i;
        smallestVal = (int)al.get(i);
      } //end if
    } //end inner for
    return smallestVal; //return smallest val
  } //end method


  public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {

    ArrayList<Integer> sub = new ArrayList<Integer>(); //creates new array to returrn
    for (;lo < hi; lo++) { //doesnt include hi because it allows the full list to be copied using
      sub.add( al.get(lo) ); //the same variable recursively without duping elements
    }// end loop to copy
    return sub; //return new list
  }//end slice

  //subgoals for mergeSort
  //setup variables
  //   make a new ArrayList
  //   indices for each input
  //while both indices are less than their respective lengths
  //compare current index elements of each input list
  //add the smaller value to the new list
  //update index we took the value from
  //loop ends: one index is past the end of the list
  //copy the values from the reamining list over
  //return the new list


  public static ArrayList<Integer> mergo (ArrayList <Integer> al, ArrayList<Integer>al2){
    ArrayList<Integer> outPut = new ArrayList<Integer>();
    int ind1 = 0; //increment for list al
    int ind2 = 0; //incremet fo list al2

    while(ind1<al.size() && ind2<al2.size()){ //while the lists have not been fully incremented
      if(al.get(ind1)<al2.get(ind2)){ //if item on al is less than al2
        outPut.add(al.get(ind1)); //then add it to sorted list (outPut)
        ind1++;                         //and increment that list only
      }
      else {                          //if that is not true (i.e. if it is less than or equal to)
        outPut.add(al2.get(ind2)); //add the item from al2
        ind2++;                         //and increment that list, only
      }
    }                                    //end outer while loop checking both lists are not incremented
    if (ind1 == al.size()){            //checks to see if al list is fully incremented
                                      //this isnt actually necessary because if we exited the above loop, one of them must be fully incremented
                                      //we therefore don't need the if statement to check that one is true - it does however
                                      //visually articulate what the change that took place was, which might be useful for students.
        while (ind2 < al2.size()){            //while it is and if the other is not
          outPut.add(al2.get(ind2));  //it adds the remainder of the list, since they must be larger
          ind2++;                           //it increments one by one
        }                                   //if no longer less than, both lists are fully incremented
      } else {                                  //ends, the if statement is true but the inner condition no longer is
        while (ind1 < al.size()){              //if al list is not fully incremented
          outPut.add(al.get(ind1));  //it adds the remaining items on the list
          ind1++;                         //by incrementing one by one
        }                               //if the al index is no longer less than the size
      }                             //the else condition ends
    return outPut; //return fully sorted list.
  } //end method

  public static ArrayList<Integer> mergeSort(ArrayList<Integer> al){
    return mergeSort(al, 0, al.size());
  }
  public static ArrayList<Integer> mergeSort(ArrayList<Integer> al, int lo, int hi){
    if (al.size()<=1){  //if we're at list size of 1, return
      return al;
    }

      ArrayList<Integer> merg1 = new ArrayList<Integer>(); //creates two lists
      ArrayList<Integer> merg2 = new ArrayList<Integer>();
      int half = al.size()/2;  //divides in half to create two lists of approx same size
      int length = al.size();  //uses original length of list to determine stop point for upperbound list creation
      merg1 = slice(al,0,half);  //uses slice to create list using bottom/left half
      merg2 = slice(al,half,al.size()); //uses slice to create list using top/right half,
      // slice inside does not include equals for top so there is no overlap btwn two lists despite using same variable (half) to define both


     return mergo(mergeSort(merg1), mergeSort(merg2));
   }

//works all the time
          public static void quickSortWork(ArrayList <Integer> al, int low, int high) {
            //check if the values work
          if (al.size() == 0){ //is list empty?
      			return;
          }
          if(al == null){ //is list nonexistant?
            return;
          }
            //if we've gone out of bounds return
      		if (low >= high){
            return;
          }

      		// pick the pivot starting at the middle,
      		int middle = low + (high - low) / 2; //increase by adding low to the difference of low and high /2 to increment upward from bottom by half
      		int pivot = (int)al.get(middle);
      		// make left < pivot and right > pivot
      		int lowIndex = low;
          int hiIndex = high;
      		while (lowIndex <= hiIndex) { //are we within bounds?
      			while (al.get(lowIndex) < pivot) { //is lower index less than pivot? it should be
      				lowIndex++;                         //keep incrementing
      			}

      			while (al.get(hiIndex) > pivot) { //if the value of the highindex is still above the pivot,
      				hiIndex--; //we're good, nothing to switch, so decrement
      			}

      			if (lowIndex <= hiIndex) { //still within bounds but lower is above and higher is below?
              swapHelper(al, lowIndex, hiIndex); //swap values
      				lowIndex++; //increment
      				hiIndex--; //decrement
      			}
      		} //exit if we no longer within bounds

      		// recursively sort two sub parts
      		if (low < hiIndex){
      			quickSortWork(al, low, hiIndex); //use lowest and highest to sort sub recursively
            }
      		if (high > lowIndex){
      			quickSortWork(al, lowIndex, high); //use lowest and highest of other side to sort recursively
      	}
        }
//same but works with Arrays
      public static void quickSortTest(int[] al, int low, int high) {
        if (al.length == 0){
          return;
        }
        if(al == null){
          return;
        }
        if (low >= high){
            return;
        }


  // pick the pivot
  int middleNum = low + (high - low) / 2;
  int pivot = al[middleNum];

  // make left < pivot and right > pivot
  int lowIndex = low;
  int hiIndex = high;
  while (lowIndex <= hiIndex) {
    while (al[lowIndex] < pivot) {
      lowIndex++;
    }

    while (al[hiIndex] > pivot) {
      hiIndex--;
    }

    if (lowIndex <= hiIndex) {
      swapHelperArrays(al, lowIndex, hiIndex);
      hiIndex--;
      lowIndex++;
    }
  }

  // recursively sort two sub parts
  if (low < hiIndex){
    quickSortTest(al, low, hiIndex);
  }


  if (high > lowIndex){
    quickSortTest(al, lowIndex, high);
  }

}

//swap helper for the quick sort above for arrays (vs arraylist version above) after this push to the github and work on trees
public static void swapHelperArrays (int[] al, int indexA, int indexB){
  int temp = al[indexA]; //hold value to switch in temp position
  al[indexA]=al[indexB]; //rewite the oiginal position with swap value
  al[indexB]=temp; //take original value from temp and overwrite swap values oiginal position
}//close method

//mostly works with
//occassional errors i kept because it annoyed me but didnt have time to figure it out
public static ArrayList<Integer> quikSort(ArrayList<Integer> al, int bot, int top){
  if (top-bot<=1){
    return al;
  }
  int rInd = top;
  System.out.println(" this is the r index " + rInd);
  int lInd = bot;
  System.out.println(" this is the L index " + lInd);
  int middle = bot + ((top - bot) / 2);
  System.out.println(" this is the middle " + middle);
  int pivot = (int)al.get(middle); //get pivot
  System.out.println(" this is the pivot " + pivot);
  while (lInd <= rInd){
    System.out.println(" left Ind " + lInd + " is less than right Ind " + rInd + " so we continue ");
    while (al.get(lInd)<pivot){
      System.out.println(" the item at left Ind " + lInd + " is " + al.get(lInd) + " it is less than pivot " + pivot +" so we increment rInd by one ");
      lInd++;
      System.out.println(" r index increases to " + rInd + " and we continue ");
    }
    while (al.get(rInd)>pivot){
      System.out.println(" the item at right Ind " + rInd + " is " + al.get(rInd) + " it is greater than pivot " + pivot +" so we increment rInd by one ");
      rInd--;
      System.out.println(" l index increases to " + lInd + " and we continue ");
  }
  if(lInd<=rInd){
    System.out.println(" left Ind " + lInd + " is less than or equal to " + rInd + "  so we swap the two and increment rInd by neg one and l plus one ");
    swapHelper(al, rInd, lInd);
    rInd--;
    lInd++;
  }
  }
  if(bot<rInd){

    quikSort(al,bot, rInd);
  }
  if(top>lInd){
    quikSort(al, lInd, top);
  }
  return al;
}

//sort algoithm using linear search and the same array is returned
public static ArrayList sortAlgorithm(ArrayList al){
  //ArrayList<Integer> tester = new ArrayList<Integer>();
  for (int i = 0; i < al.size()-1; i++){
    for (int j = i + 1; j < al.size(); j++){
      if ((int)al.get(i)>(int)al.get(j)){
        int holder = (int)al.get(j);
        al.set(j,(int)al.get(i));
        al.set(i, holder);
      } //end if
    } //end inner for
  } //end outer for
  return al; //return sorted array
} //end method
//selection sort

//swaper helper algorithm commented better elsewhere i think in Boogle?
public static void swapHelper (ArrayList al, int indexA, int indexB){
  int temp = (int)al.get(indexA);
  al.set(indexA, (int)al.get(indexB));
  al.set(indexB, temp);
  //
}

//selection sort using temp variable to hold value before swapping no helper method
public static ArrayList selectionSort(ArrayList al){
  //int smallestVal; //hold smallest val , not needed, used in testing.
  int swapInd; //index to swap
  int end = al.size();  //size of list
  int iHolder; //temp var to hold swap val
  for (int start = 0 ; start < end; start++){
    swapInd = findSmallest(al, start, end); //find smallest index
  //  System.out.println("findSmallest index is "+ swapInd); //checker
    iHolder = (int)al.get(start);
    al.set(start, (int)al.get(swapInd));
    al.set(swapInd, iHolder);
  }
  return al;
}


//selection sort
//cleaner version, using swapHelper
public static void selectionSortAlg (ArrayList al){
  //store size of list
  int end = al.size();
  //start at beginning, go to end,
  for (int start = 0; start < end; start++){
    int swapIndex = findSmallest(al, start, end);
    swapHelper(al, start, swapIndex);
  }
}
//self explanitory random list generator
public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
{
  ArrayList retArr = new ArrayList();

  for(int i=0; i<numItems; i++) {
    //System.out.println(i);  //diagnostic under-the-hood view
    //retArr.add( Math.random() ); // [0,1)
    //retArr.add( (int)Math.random() ); // 0
    //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
    retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
  }
  return retArr;
}//end prestoArrayListo()


//return ArrayList of random ints, sorted in ascending order
public static ArrayList prestoSortedArrayListo(int numItems,int lo, int hi) {
  //create list
  ArrayList retArr = new ArrayList();

  //if requested, return empty ArrayList
  if ( numItems<1 )
  return retArr;

  //populate index 0
  retArr.add( (int)(lo * Math.random()) );

  //populate rest of indices, each one greater than last
  for(int i=1; i<numItems; i++) {
    //System.out.println(i);  //diagnostic under-the-hood view
    //retArr.add( Math.random() ); // [0,1)
    //retArr.add( (int)Math.random() ); // 0
    //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
    //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    //System.out.println(retArr.get(i-1));
    retArr.add( (int)retArr.get(i-1)
    + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi)
  }

  return retArr;
  //end prestoSortedArrayListo()

}

public static void main(String[] args) {

  //create list to test w
  ArrayList<Integer> test1 = new ArrayList<Integer>();
  //create second list to test w
  ArrayList<Integer> test2 = new ArrayList<Integer>();
  ArrayList<Integer> test3 = new ArrayList<Integer>();
  ArrayList<Integer> test4 = new ArrayList<Integer>();
  test1 = prestoArrayListo(10,0,20);
  test2 = prestoArrayListo(10,2,24);

  System.out.println("test print of test1");
  System.out.println(test1);

  System.out.println("test print of test2");
  System.out.println(test2);

  //test slice
  test3 = slice(test2, 0,3);
  test4 = slice(test2, 3,7);
  System.out.println("test print of slice top");
  System.out.println(test3);
  System.out.println("test print of slice bottom");
  System.out.println(test4);

  //call mergo
  test3 = mergeSort(test2);
  System.out.println("test print of mergeSort");
  System.out.println(test3);
  //define new list and create new random int list
  ArrayList<Integer> testQuik = new ArrayList<Integer>();
  testQuik = prestoArrayListo(10,5,25);
  //print out random list fr comparison
  System.out.println(testQuik);
  //test whether int is needed fo boolean comparison
  System.out.println("is item 1 greater than item 4 " );

  if (testQuik.get(1)>testQuik.get(4)){
    System.out.println("true");
  } else {
    System.out.println("false");
  }
  //attempt to call quicksort
  //quickSort(testQuik);
  //System.out.println("test print of quickSort algo");
  //System.out.println(testQuik);
//test quiksort algo
  ArrayList<Integer> testQuikOther = new ArrayList<Integer>();
  testQuikOther = prestoArrayListo(10000,5,25);
  System.out.println(testQuikOther);
  System.out.println("above is original list below is new quiksort algo ");
  //quickSortAlg(testQuikOther, 0, 9);
  //quickSortHelper(testQuikOther);
  //quickSort(testQuikOther, 0, 9);
  //quikSort(testQuikOther, 0, 9);
  //System.out.println(quikSort(testQuikOther, 0, 9));

  //for(int i=0; i < testQuikOther.size(); i++){
  //           System.out.println( testQuikOther.get(i) );
  //         }
//adding time testing
  long start = System.currentTimeMillis();
  quickSortWork(testQuikOther, 0, 9999);
  long elapsed = System.currentTimeMillis() - start;
  System.out.println("Elapsed Time: " + elapsed);

//end test apparatus

  int[] newArray = new int [] {3,2,6,1,39,2,25,3,53,2};
  quickSortTest(newArray, 0, 9);
  System.out.println(Arrays.toString(newArray));

}
}

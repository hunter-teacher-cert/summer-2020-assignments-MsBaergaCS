/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: Boogle
   A tester class for code analysis and search exploration.
   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.
   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class BoogleS
{

  //return index of first occurence of target, or -1 if not found
  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end linSearch()

  public static int binSearch( ArrayList al, int target, int low, int high )
  {
    //set i to half of the length of arraylist (note that it floors decimals)

    int mid = (low + high)/2;  //initial arraylist length using int div returns ~1/2 as int
    //int high = al.size()-1; //initial high point uses length of list
    //int low = 0; //initial low point is 0
    //is target equal to midpoint element? then return
    if ((int)al.get(mid)==target){
      return mid;
    //if target is greater than element at item, mid + 1 becomes low, else it - 1 becomes high
    } else {
      while (low <= high){
        mid = (low + high)/2; //update usingnew high/low vals
        if (target == (int)al.get(mid)){  //check for matching val
          return mid;
        } else
        if (target > (int)al.get(mid)){  //if higher, reset low
          low = mid + 1; //move lower upward of middle
        } else
        if (target < (int)al.get(mid)){  //if lower, reset high
          high = mid - 1; //move higher below middle
        }
      }//end while
      return -1;  //if not found, return neg 1
    }//end else
  }//end method


  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?  //for recursion to not have the user input bounds of list
  // Q: What would the parameters be for such a method?
  //add in stop/start sort location


  //return ArrayList of random ints on range [lo,lo+hi)
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
  public static ArrayList prestoSortedArrayListo(int numItems,
                                                 int lo, int hi)
  {
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
  }//end prestoSortedArrayListo()

  //##################################################
  //##################################################

    // find and return the index of the smallest value in the
    // ArrayList al from index lo to index hi inclusive
  //  public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
	// assume the first item is the smallest - call it our smallest so far


	// loop over all the items
	//   if the current item is smaller than the smalleest so far,
	//      then the current item becomes the new smallest so far


	// change this to return the correct answer
	//return -1;
  //  }
    public static ArrayList sortAlgorithm(ArrayList al){
      ArrayList<Integer> tester = new ArrayList<Integer>();
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


    public static int getSmallestSort(ArrayList al, int lo, int hi){
      ArrayList<Integer> tester = new ArrayList<Integer>();
      for (int i = 0; i < al.size()-1; i++){
        for (int j = i + 1; j < al.size(); j++){
          if ((int)al.get(i)>(int)al.get(j)){
            int holder = (int)al.get(j);
            al.set(j,(int)al.get(i));
            al.set(i, holder);
        } //end if
      } //end inner for
    } //end outer for
    return (int)al.get(0); //smallest int
    } //end method

    public static int getSmallestNumb(ArrayList al, int lo, int hi){
      ArrayList<Integer> tester = new ArrayList<Integer>();
      for (int i = 0; i < al.size()-1; i++){
        for (int j = i + 1; j < al.size(); j++){
          if ((int)al.get(i)>(int)al.get(j)){
            int holder = (int)al.get(j);
            al.set(j,(int)al.get(i));
            al.set(i, holder);
        } //end if
      } //end inner for
    } //end outer for
    return (int)al.get(0); //return sorted array
    } //end method

    //modified findsmallest for expanded functionality
    //intake array start checkpoint and end checkpoint
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


  //##################################################
  //##################################################


  public static void main( String[] args )
  {


  //*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~

      int smallIndex;
      System.out.println("Testing findSmallest");
      ArrayList<Integer>  slist = prestoArrayListo(20,0,200);
    smallIndex = findSmallest(slist,0,slist.size());
      System.out.println(slist);
      System.out.printf("Smallest is at slist[%d] and is %d\n",smallIndex,slist.get(smallIndex));

      //~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

}//end main

}//end class

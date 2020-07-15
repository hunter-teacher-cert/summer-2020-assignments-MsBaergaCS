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
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Boogle
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


public static int binSearchHelp (ArrayList al, int target){
//iterative
  return binSearch (al, target, 0, al.size()-1);
//recursive
  //return binSearchRecurs (al, target, 0, al.size()-1);
}
  //return index of target, or -1 if not found
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

/*public String toString(ArrayList al){
    String s = "*"; //opening of list
    int i = 0;
    while (i < al.size()-1){
      s = s + al.get(i)+"-->"; //adds s and arrow between to previous s variable
      // how can we now move tmp to the next node
      // this is the magic linked list idiom!!!!
      // this moves a pointer to the next node!!!
      // It's analagous to i=i+1 for an array (for loop)
      i++;
    }
    s = s + "*"; //closing list
    return s;
  }
*/

//binary search using recursion, which uses two addit'l parameters to allow for the
//recursive use of the method without needing to create a new list
  public static int binSearchRec ( ArrayList al, int target, int begin, int end){
    int mid = (begin + end)/2; //set mid point
    if (begin > end){ //if begin is higher then it hasn't been found
      return - 1;
    }
    if (al.get(mid).equals(target)){  //if it is equal, return index
      return mid;
    }
    if ((int)al.get(mid)<target){ //if target is greater than, set to mid + 1
      begin = mid + 1;
      //System.out.println(al.get(bin)+ " is less than " + target);
      return binSearchRec(al, target, begin, end); //call again
    } else if ((int)al.get(mid)>target){ //if target is less than, set to mid - 1
      end = mid - 1;
      return binSearchRec(al, target, begin,end); // call again
      //System.out.println(al.get(bin)+ " is greater than " + target);
    }
    return -1;
    }

/*public static int binarySearchRec (ArrayList al, int target, int begin, int end){
  int mid = (begin + end/2);
  if ((int)al.get(mid) == target){
    return mid;
  } else if ((int)al.get(mid)<target){
    return binarySearchRec(al, target, mid+1, end);
  } else if ((int)al.get(mid)<target){
    return binarySearchRec(al, target, begin, mid-1);
  }
 return -1;
} */



  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?
  // Q: What would the parameters be for such a method?



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
  //end prestoSortedArrayListo()

}
  public static void main(String[] args) {



    ArrayList<Integer> tester = new ArrayList<Integer>();
    tester.add(1);
    tester.add(3);
    tester.add(6);
    tester.add(9);
    tester.add(15);
    tester.add(18);
    tester.add(19);
    tester.add(25);
    tester.add(28);
    tester.add(29);

    int size = tester.size();
    System.out.println("tester size is " + size);
    System.out.print("test binary search loc of 25 is 7 shld say: ");
    System.out.println(binSearchRec(tester,25,0,8));
//mess up the tester sort
    tester.set(3,45);

//print messed up tester
    System.out.println("print tester \n ");
      for (int i = 0; i < tester.size();i++)
      {
          System.out.println(tester.get(i));
      }
//test manual sort
    sortAlgorithm(tester);

//println
System.out.println("print tester \n ");
  for (int i = 0; i < tester.size();i++)
  {
      System.out.println(tester.get(i));
  }

//use bin search recursive on new sort
    System.out.println(binSearch(tester, 23,0,8));
    System.out.println(binSearch(tester, 28,0,8));
//
    sortAlgorithm(prestoArrayListo(10, 5, 20));



  //  binarySearchRec(tester, 18, 0, 6);
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = prestoArrayListo(0,0,0);
    System.out.println(al000);
    System.out.println(linSearch(al000,3));
    System.out.println("\n"+"al01"+":");
    ArrayList al01 = prestoArrayListo(5,0,100);
    System.out.println(al01);
    System.out.println(linSearch(al01,3));
    System.out.println("\n"+"al02"+":");
    ArrayList al02 = prestoArrayListo(5,3,10);
    System.out.println(al02);
    System.out.println(linSearch(al02,3));
    System.out.println("\n"+"al05"+":");
    ArrayList al05 = prestoArrayListo(20,1,5);
    System.out.println(al05);
    System.out.println(linSearch(al05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


    // test battery using sorted ArrayLists as search space
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = prestoSortedArrayListo(0,0,0);
    System.out.println(sal000);
    System.out.println(linSearch(sal000,3));
    System.out.println(binSearch(sal000,3));
    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal00);
    System.out.println(linSearch(sal00,3));
    System.out.println(binSearch(sal00,3));
    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal01);
    System.out.println(linSearch(sal01,3));
    System.out.println(binSearch(sal01,3));
    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = prestoSortedArrayListo(5,3,100);
    System.out.println(sal02);
    System.out.println(linSearch(sal02,3));
    System.out.println(binSearch(sal02,3));
    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal03);
    System.out.println(linSearch(sal03,3));
    System.out.println(binSearch(sal03,3));
    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = prestoSortedArrayListo(20,0,3);
    System.out.println(sal04);
    System.out.println(linSearch(sal04,3));
    System.out.println(binSearch(sal04,3));
    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = prestoSortedArrayListo(20,1,5);
    System.out.println(sal05);
    System.out.println(linSearch(sal05,3));
    System.out.println(binSearch(sal05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    //batch of commands for easier test case generation:
    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = prestoArrayListo(,,);
    System.out.println(al);
    System.out.println(linSearch(al, ));
    System.out.println(binSearch(al, ));
    */
  }//end main

}//end class

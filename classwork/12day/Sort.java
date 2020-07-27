import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Sort {

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

/*public static ArrayList<Integer> addQuick(ArrayList al) {
  int pivot = 0;
  for (int i = 0; i < al.size()-1; i++){
    if (pivot<al.get(i)){
      aboveP.add(al.get(i));
    }
}
} */

public static ArrayList<Integer> quikSort(ArrayList<Integer> al){
  if (al.size()<=1){
    return al;
  }
  int pivot = (int)al.get(al.size()-1);
  System.out.println(pivot);
  ArrayList<Integer> belowP = new ArrayList<Integer>(); //creates two lists
  ArrayList<Integer> aboveP = new ArrayList<Integer>();
  for (int i = 0; i < al.size()-1; i++){
    if (pivot<al.get(i)){
      aboveP.add(al.get(i));
    } else if (pivot>al.get(i)){
      belowP.add(al.get(i));
    }
    return mergo(quikSort(belowP),quikSort(aboveP));
}
return mergo(quikSort(belowP),quikSort(aboveP));
}

//pick a pivot, last elemenet
//compare each element to the pivot
//if the left index is > pivot and right < pivot, swap
//if the left index is > pivot and right > pivot, increment right
//if the left index is < pivot and right < pivot, increment left
//if the left index is < pivot and right > pivot, increment both
public static ArrayList<Integer> quickSort(ArrayList<Integer> al){

  int pivot = (int)al.get(al.size()-1);
  System.out.println("pivot is " + pivot);
  int leftInd = 0;
  System.out.println("leftInd is " + leftInd);
  int rightInd = (int)al.size()-2;
  System.out.println("right index is " + rightInd);
while (leftInd < rightInd){
  if (al.get(leftInd) > pivot && al.get(rightInd)<pivot){
    System.out.println("swap " + al.get(leftInd) + " and "+ al.get(rightInd));
    swapHelper(al, leftInd, rightInd);
    leftInd++;
    rightInd--;
    System.out.println("swap and increment left up and right down");
  }
  if (al.get(leftInd)>pivot && al.get(rightInd)>pivot){
    System.out.println(al.get(leftInd)+ " is greater than " + pivot " and " + al.get(rightInd) + " is greater than "+ pivot + "");
    rightInd--;
    System.out.println("no swap, decrement right down");
  }
  if (al.get(leftInd)<pivot && al.get(rightInd)<pivot){
    System.out.println(al.get(leftInd)+ " is less than " + pivot " and " + al.get(rightInd) + " is less than "+pivot);
    System.out.println("no swap, increment left up");
    leftInd++;
  }
  if (al.get(leftInd)<pivot && al.get(rightInd)>pivot){
    System.out.println(al.get(leftInd)+ " is less than " + pivot " and " + al.get(rightInd) + " is greater than "+  pivot);
    System.out.println("no swap, increment left up and right down");
    leftInd++;
    rightInd--;
  }
}
System.out.println("no swap, increment left up");
swapHelper(al, leftInd, pivot)
return quickSort;
}
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

//swaper helper algorithm
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
    System.out.println("findSmallest index is "+ swapInd); //checker
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
  //attempt to call quicksort
  quickSort(testQuik);
  System.out.println("test print of quickSort algo");
  System.out.println(testQuik);
}
}

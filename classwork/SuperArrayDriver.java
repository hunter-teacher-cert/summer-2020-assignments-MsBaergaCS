import java.io.*;
import java.util.*;

public class SuperArrayDriver
{
  public static void main( String[] args )
  {

    System.out.println("Testing default constructor.");
    superArray sa = new superArray();

    System.out.println("Testing empty print:");
    System.out.println(sa);
    System.out.println("Testing isEmpty (should be true)");
    System.out.println(sa.isEmpty());


    //use add to fill list
    for (int i = 0; i < 9; i++){
      sa.add(i);
    }
    //testing empty shld be false
    System.out.println(sa.isEmpty());

    //printing current list
    System.out.println(sa.toString());
    //testing overwrite ability
    sa.overWriteIndex(5,9);

    //printing overwrite results
    System.out.println(sa.toString());

    //testing add solo
    sa.add(11);

    System.out.println(sa.toString());
    //testing addBetter - which should increase array size if need be
    sa.addBetter(12);

    System.out.println(sa.toString());

    //TESTING remove
    sa.remove(5);

    System.out.println(sa.toString());


    //testing find & replace
    sa.findReplace(2, 11);

    System.out.println("test findreplace print: ");
    System.out.println(sa.toString());

    System.out.println(sa.get(5));

  //  System.out.println("Testing overfill (calling grow() in add)");
    //for (int i=0; i<15; i++) {
  //    sa.addBetter(i);
//}//for i
  //  System.out.println(sa);
  //  System.out.println(sa.isEmpty());

  /*  System.out.println("\nTesting add at index 5, 0 and 17(end)");
    sa.insert(5, 100);
    System.out.println(sa);
    sa.insert(0, 100);
    System.out.println(sa);
    sa.insert(17, 100);
    System.out.println(sa);

    System.out.println("\nTesting remove at 0, 5, and 15 (end)");
    sa.remove(0);
    System.out.println(sa);

    sa.remove(5);
    System.out.println(sa);

    sa.remove(15);
    System.out.println(sa); */
  }//main

}//class SuperArrayDriver

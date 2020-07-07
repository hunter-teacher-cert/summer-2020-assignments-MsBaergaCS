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

    for (int i = 0; i < 9; i++){
      sa.add(i);
    }

    System.out.println(sa.isEmpty());

    System.out.println(sa.toString());

    sa.overWriteIndex(5,9);

    System.out.println(sa.toString());

    sa.add(11);

    System.out.println(sa.toString());

    sa.addBetter(12);

    System.out.println(sa.toString());

    sa.remove(5);

    System.out.println(sa.toString());

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

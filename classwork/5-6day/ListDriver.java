import java.io.*;
import java.util.*;

public class ListDriver {
  public static void main(String[] args) {

    LList g = new LList();

    System.out.println("Test Empty list print & isEmpty:");
    System.out.println(g);
    System.out.println(g.isEmpty());


    System.out.println("\nTest addFront 3x & isEmpty():");
    g.addFront("good");
    g.addFront("news");
    g.addFront("everyone!");
    System.out.println(g);
    System.out.println(g.isEmpty());

   System.out.println("\nTest get 0, 1, 5:");
   System.out.println(g.get(0));
   System.out.println(g.get(1));
   System.out.println(g.get(5));


   System.out.println("\nTest set 0, 1, 5:");
   System.out.println("Actually only adding to 1, me");
   g.set(1, "me!");
   System.out.println("just set to me, did it work?");
   System.out.println(g);
   System.out.println("set 2 to job");
   g.set(2, "job");
   System.out.println("just 2 set to job, did it work?");
   System.out.println(g);
   /*
   System.out.println("set 0 to wow?");
   g.set(5, "wow");
   System.out.println(g); */

   System.out.println("\nTest insert 0, 2, 5, 10:");
   g.insert(0, "woo!");
   g.insert(2, "go");
   g.insert(5, "cool");
   g.insert(10, "too far");
   System.out.println(g);

   System.out.println("\nTest search \"woo!\", \"cool\", \"too far\"");
   System.out.println(g.search("woo!"));
   System.out.println(g.search("cool"));
   System.out.println(g.search("too far"));

   System.out.println("\nCurrent Linked List");
   System.out.println(g);
   System.out.println("\nTest remove 0");
   g.remove(0);
   System.out.println(g);
   System.out.println("\nTest remove 2");
   g.remove(2);
   System.out.println(g);
  }//main
 }//LListDriver

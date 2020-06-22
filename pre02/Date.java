import java.io.*;
import java.util.*;

public class Date {
    public static void main(String[] args) {
      String day = "Monday";
      int date = 22;
      String month = "June";
      int year = 2020;
      //System.out.println(day); output test
      //System.out.println(date); output test
      //System.out.println(month); output test
      //System.out.println(year); output test
      System.out.println("American format:");
      System.out.println("Today is "+ day + ", " + month + " " + date +", "+year);
      System.out.println("European format:");
      System.out.println("Today is "+ day + ", " + date + " " + month +", "+year);

    }
}

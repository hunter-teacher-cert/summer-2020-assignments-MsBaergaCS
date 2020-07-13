import java.util.ArrayList;

public class MyOtherStack {

//arraylist StackTraceElement
  private ArrayList<String> stack;
  private int myHead = 0;
  private int length = 0;

//trying using arraylists
//init arraylist for stack
  public MyOtherStack(){
    stack = new ArrayList<String>();
  }
//uses arraylist to add data, always to 0, thereby pushing from front to back of List
//using length to count
  public void push(String data){
    stack.add(0, data); //use arraylist built-in add
    length++;
    //System.out.println(data); tester not in use
  }

  //removes and returns data at head
  public String pop() {
    if (length == 0){ //if empty - cannot pop, note - shld mod to throw exception
      return null;
    } //end if statement
    String popData = stack.get(0); //use get to set String to pop data, always at zero
    stack.remove(myHead);  //remove from stack at index myHead (zero)
    length--; //remove one from length count
    return popData; //return string var holding data from get
  } //end method

//retuns  data from head, does not remove
  public String peek(){
    return stack.get(0); //uses get in same way as before, use on return as we don't need to remove first
  }

  public boolean isEmpty(){  //checks if stack is empty, could use this in string pop to throw exception in lieu of length
    if (length == 0) { //if length is zero
      return true; //return true
  } else {
    return false; //else false
  }  //end else
} //end method

  public int stackSize() {
    return length; //returns length - must update any new methods that remove/add to keep consistent
  }
//will return the character at index i in String s (0-based).

/*public static String reverse(String s){
  MyOtherStack rev =  new MyOtherStack(); //create new stack
  String printRev = ""; //initialize string var
  for (int i = 0; i< s.length(); i++){ //checks in a for loop that iterates thru whole string
    rev.push("" + s.charAt(i));  //adds letters one by one, using push to stack, "" allows conversion to string of char at index
  } //end for loop
  for (int i = 0; i < s.length(); i++){ //new for loop reverses thru new stack using pop
    printRev = printRev + "" + rev.pop();  //adds to new string var, adding a char at a time, already strings, removed space was causing not to read as palindrome
  }    // end for loops                 // test removing "" since space is gone
    return printRev;
} //end method

public static boolean isPalendrome(String s){
  return s.equals(reverse(s)); //tests if string s is equal to reverse of s using reverse method
}*/


} //end method

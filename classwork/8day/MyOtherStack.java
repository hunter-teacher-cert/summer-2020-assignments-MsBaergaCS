import java.util.ArrayList;

public class MyOtherStack {

//arraylist StackTraceElement
  private ArrayList<String> stack;
  private int myHead = 0;
  private int length = 0;

  public MyOtherStack(){
    stack = new ArrayList<String>();
  }

  public void push(String data){
    stack.add(0, data);
    length++;
    //System.out.println(data);

  }
  public String pop() {
    if (length == 0){
      return null;
    }
    String popData = stack.get(0);
    stack.remove(myHead);
    length--;
    return popData;
  }

  public String peek(){
    return stack.get(0);
  }

  public boolean isEmpty(){
    if (length == 0) {
      return true;
  } else {
    return false;
  }
}

  public int stackSize() {
    return length;
  }
//will return the character at index i in String s (0-based).

/*public static String reverse(String s){
  MyOtherStack rev =  new MyOtherStack();
  String printRev = "";
  for (int i = 0; i< s.length(); i++){
    rev.push("" + s.charAt(i));
  }
  for (int i = 0; i < s.length(); i++){
    printRev = printRev + "" + rev.pop();
  }
    return printRev;
}

public static boolean isPalendrome(String s){
  return s.equals(reverse(s));
}*/


  }

public class StackDriver{

  public static String reverse(String s){   //comments in MyOtherStack.java
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

  public static boolean isPalendrome(String s){  //comments in MyOtherStack.java
    return s.equals(reverse(s));
    }

  public static void main(String[] args) {
    MyOtherStack thisStack =  new MyOtherStack();
    System.out.println(thisStack);

    if(thisStack.isEmpty()) {
      System.out.println("is empty");
    } else {
      System.out.println("is not empty");
    }
//push a known palindrome
    thisStack.push("a");
    thisStack.push("n");
    thisStack.push("n");
    thisStack.push("a");
//check size
    System.out.print(thisStack.stackSize());

    //System.out.println(thisStack.stackSize());
    //System.out.println(stack.MyOtherStack());
    //System.out.println(stack.peek());
    //String test = new String ("anna");
    //thisStack.reverse();
    //System.out.println(reverse(test));

    //System.out.println(isPalendrome(test));

//set string to anna, the known palindrome
    String anna = new String ("anna");

  //check if palindrome
    System.out.println(isPalendrome(anna));
    // c heck if palindrome
    if(isPalendrome(anna)==true){
      System.out.println(anna + " it is a Palendrome");
    } else {
      System.out.println(anna + " is not a Palendrome");
    }
/*
  MyStack thisStack =  new MyStack();
  System.out.println(thisStack);

  if(thisStack.isEmpty()) {
    System.out.println("is empty");
  } else {
    System.out.println("is not empty");
  }

  thisStack.push("i");
  thisStack.push("am");
  thisStack.push("so");
  System.out.print(thisStack);

  System.out.println(thisStack.pop());

  System.out.println(thisStack.stackSize());
  //System.out.println(stack.MyOtherStack());
  //System.out.println(stack.peek()); */
  }


}

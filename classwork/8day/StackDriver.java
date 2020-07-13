public class StackDriver{


  public static void main(String[] args) {
    MyOtherStack thisStack =  new MyOtherStack();
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
    //System.out.println(stack.peek());

  }


}

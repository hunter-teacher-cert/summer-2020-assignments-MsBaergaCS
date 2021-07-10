public class MyStack {

  private LList3 stack;
  //instance variable
  private Node bottom = null;
  private Node head;
  private String alwaysHead = "";
  private String data = "";
  private Node previous = null;
  private Node next = null;
  private int length = 0; //tracks additions & removals
  //constructor
  //adds new value to FRONT of list, pushes back
  /*public void addFront(String data){
    //create a new node, using node class, with data input as string
    Node newnode = new Node(data);

    // first point the new node to the beginning
    newnode.setNext(head);

    // point head to the new node (back to itself)
    head = newnode;

    //increase length
    length ++;

  }*/

      public MyStack(){
          // add constructor code
          Node newStack = new Node();
          this.head = null;
          this.bottom = null;
          this.previous = null;
          this.next =  null;
      }

      public void push(String data){
          // add code to push data on to the stack
          Node head = new Node(data, head);
          if (length == 0) {
            alwaysHead = data.toString();
          }
          if (length>0){
            head.setNext(next);
            length++;
          } else {
            this.stack.addFront(data);
          }
      }

      public String pop(){
          // add code to remove and return the
          // item on the top of the stack
          if (isEmpty()==true){
            return "This is empty";
          }
          String temp = head.getData();
          head = head.getNext();
          length--;
          return temp;
      }

      public String top(){
          // add code to return but not remove the
          // item on the top of the stack
          return head.getData(); //head variable holds top data, always
      }

      public boolean isEmpty(){
          // return true if the stack has no data, false otherwise
          if (length == 0){
            return true;
          } else {
            return false;
          }
      }

      public int size(){
          // add code to return the number of items currently on the stack
          return length;
      }


}

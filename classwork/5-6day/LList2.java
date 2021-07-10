public class LList2 {

  //instance variable
  private Node head;
  private int length = 0; //tracks additions & removals
  //constructor
  public LList2(){
    this.head = null;
  }
  //adds new value to FRONT of list, pushes back
  public void addFront(String data){
    //create a new node, using node class, with data input as string
    Node newnode = new Node(data);

    // first point the new node to the beginning
    newnode.setNext(head);

    // point head to the new node (back to itself)
    head = newnode;

    //increase length
    length ++;

  }


  //adds data to end of linked list
  public void addEnd (String data){
    if(data == null) {
      throw new IllegalArgumentException("Cannot create Node with Null String");
    }
    insert(new Node(data), length);
    length++;
  }

  //checks if llist is empty
  public boolean isEmpty(){
    return head == null;
  }

  public int returnLength(){
    return length;
  }
  public String toString(){
    String s = "*"; //opening of list
    Node currentNode;
    currentNode = head;
    while (currentNode != null){
      s = s + currentNode.getData()+"-->"; //adds s and arrow between to previous s variable
      // how can we now move tmp to the next node
      // this is the magic linked list idiom!!!!
      // this moves a pointer to the next node!!!
      // It's analagous to i=i+1 for an array (for loop)
      currentNode = currentNode.getNext();
    }

    s = s + "*"; //closing list
    return s;
  }

  //returns data value at index
  //index out of bounds, return null
  public String get (int index){
    Node currentNode = head;
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException("The index is OOB");
    }
    if (index < length) {
      for (int i = 0; i < index; i++){
        currentNode = currentNode.getNext();
      } //end for loop
      return currentNode.getData();
    } else {
      return null;
    } //end else
  } //end method


  //sets value of node at index to value and overwrites other value
  public void set(int index, String value) {
    Node currentNode = this.head; //starts at head
    for (int i = 0; i <= index; i++){ //crawls list until it hits specified index
      if (i == index){
        currentNode.setData(value);
      } else {
        currentNode = currentNode.getNext();  //traverses list using getNext to crawl
      } //upon reaching index, uses setData to
    }                        //change data to value specifie
  }//end method

  public void insert(int index, String value){
    if(data == null) {
      throw new IllegalArgumentException("Cannot create Node with Null String");
    }
    Node newNode = new Node(value); //creates new node
    Node currentNode = head; //starts at head
    if (index <= length){ //checks that our index is greaterr
      if (index == 0){ //checks if index is zero,
        addFront(value); //if it is, uses addFront
      } else { //if not
        for (int i = 1; i <= index; i++){ //increments to index position
          if (index == i){ //checks for index to be equal
            newNode.setNext(currentNode.getNext()); //if so sets new node to current next node
            currentNode.setNext(newNode); //sets current node next node to new node
          } else { //if not equal, increments
            currentNode = currentNode.getNext(); //sets current node to next
          } //end else
        } //end for loop
      } //end else for if == 0 check
    } //end if OOB check
  } //end method
  public void insert(Node node, int index){
    if(index == 0){ //checks if index is 0
      addFront(node.getData()); //if so uses fist
    } else {
      Node currentNode = head;
      for (int i = 0; i < index - 1; i++){ //stops before index to insert
        currentNode = currentNode.getNext(); //moves to next node.
      }
      if (currentNode.getNext() == null) { //checks that index is not at end of list
        currentNode.setNext(node); //if it is at end of list, just adds it to end using setnext
        length++; //adds length
        return;  //returns
      } //ends if statement preventing unknown end of list errors
      node.setNext(currentNode.getNext()); // attaches new node to current node's next node
      currentNode.setNext(node); // attaches currentNode to new node as using setNext
    } //ends else
    length++; // adds to length of list
  } //end method

  public int search (String find){
    if(data == null) {
      throw new IllegalArgumentException("Cannot search for Node with Null String");
    }
    Node currentNode = head;
    for (int i = 0; ; i++){ //iterates thru until reaches return statement
      //okay to do because when it reaches end of list, it will pull null and return
      if (currentNode.getData().equals(find)){ //checks using .equals to see if data matches value
        return i; //returns index, if found
      }
      if (currentNode.getNext()==null){
        //return -1; //returns -1 if reached end of list but not found
        throw new NoSuchElementException(find + " was not found");
      }
      currentNode = currentNode.getNext(); //moves to nex
    }
    throw new NoSuchElementException(find + " was not found");
  }

  public void remove (int index){
    Node currentNode = head; //begins at head
    if ( currentNode == null){
      throw NoSuchElementException("Index " + index + " is invalid, cannot remove.");
    }
    if (index == 0){ //if equal to zero
      head = head.getNext(); //simply sets het to next node, ends.
    } else { //if not ...
      for (int i = 0; i < index-1; i++){ //loops thru to 1 before index, to point to one after
        currentNode = currentNode.getNext(); //current node is now at the index
      } //end of for loop
      Node nextNode = currentNode.getNext(); //sets nextNode to node after index
      currentNode.setNext(nextNode.getNext()); //sets current node to
    } //end else
  } //end method

  public int nodeCount(){
    Node currentNode = head;
    while (currentNode != null){
      length += 1;
      currentNode = currentNode.getNext();
    } //end while
    return length;
  } //end method

} //end class

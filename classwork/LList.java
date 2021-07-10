public class LList {

//instance variable
  private Node head;
  private int length = 0; //tracks additions & removals
//constructor
  public LList(){
    this.head = null;
  }
//adds new value to FRONT of list
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
  if (index < length) {
    for (int i = 0; i < index; i++){
      currentNode = currentNode.getNext();
    } //end for loop
    return currentNode.getData();
  } else {
    return null;
  } //end else
} //end method


//sets value of node at index to value
public void set(int index, String value) {

  Node currentNode = this.head; //starts at head
  if (index == 0){
    addFront(value);
  } else if (index != 0 && index < length){
    for (int i = 0; i < index; i++){ //crawls list until it hits specified index
      currentNode = currentNode.getNext();  //traverses list using getNext to crawl
    } //end for loop
    currentNode.setData(value); //upon reaching index, uses setData to
  } //end if                        //change data to value specified
  else {
    addEnd(value);
  }
} //end method

public void insert(int index, String value){
  Node currentNode = head; //starts at head
  if (index <= length){
  for (int i = 0; i < index-1; i++){ //stops before index to insert
    currentNode = currentNode.getNext();
  }
  Node newNode = new Node(value, currentNode.getNext()); //creates new node, using string value
 currentNode.setNext(newNode);    //and placing the current value's next node as next node of new node
}                                   //sets currentNode's (the one before new index) next node to new node
}

public void insert(Node node, int index){
  if(index == 0){
    addFront(node.getData());
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
  Node currentNode = head;
  for (int i = 0; ; i++){ //iterates thru until reaches return statement
                        //okay to do because when it reaches end of list, it will pull null and return
    if (currentNode.getData().equals(find)){ //checks using .equals to see if data matches value
      return i; //returns index, if found
  }
    if (currentNode.getNext()==null){
      return -1; //returns -1 if reached end of list but not found
    }
    currentNode = currentNode.getNext(); //moves to nex
}
}

public void remove (int index){
  Node currentNode = head;
  if (index == 0){
    head = head.getNext();
  } else {
  for (int i = 0; i < index-1; i++){ //loops thru to 1 before index, to point to one after
    currentNode = currentNode.getNext();
  } //end of for loop
  Node nextNode = currentNode.getNext();
  currentNode.setNext(nextNode.getNext());
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

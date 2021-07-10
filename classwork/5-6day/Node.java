import java.io.*;
import java.util.*;

public class Node {
  private String data;
  private Node next;

//constructors
  public Node (String data, Node next){ //creates an instance of a node
    this.next =next;      //points to next node
    this.data = data;     //takes in data
  }

  public Node (String data){    //instance but takes in data only
    this.next = null;     //no next node
    this.data = data;     //sets data
  }

  //this is why the final 'item' on a linked list returns 0
  public Node(){
    this.next = null;     //creates empty node
    this.data = "";
  }

  //getters
  public String getData (){
    return data;
  }

  public Node getNext (){
    return next;
  }

  //return as string
  public String toString(){
    return this.data;
  }

//setters
  public void setNext(Node next){
    this.next = next;

  }

  public void setData (String data){
    this.data = data;
  }
//test above
  public static void main(String[] args) {
		Node n1 = new Node("Al");
		Node n2 = new Node("Bob");
		n1.setNext(n2);
		System.out.println(n1);
		System.out.println(n2);
		Node n3 = new Node("Carl",n2);
		n1.setNext(n3);
		Node currentNode = n1;
		System.out.println(currentNode);
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			System.out.println(currentNode.getClass().getName()+"@"+Integer.toHexString(System.identityHashCode(currentNode))+currentNode);
		}
		String s = "";
		System.out.println(s.getClass().getName()+"@"+Integer.toHexString(System.identityHashCode(s)));
		s = "a";
		System.out.println(System.identityHashCode(s));
		System.out.println(s.getClass().getName()+"@"+Integer.toHexString(System.identityHashCode(s)));
		System.out.println(s.hashCode());
		s = null;
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
	}//end of main
}//end of class

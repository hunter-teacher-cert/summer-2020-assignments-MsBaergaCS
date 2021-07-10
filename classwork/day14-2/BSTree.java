import java.io.*;
import java.util.*;


//attempt two


//search method - line
//traverse method 1 -  line
//traverse method 1 help - line
//insert method - line


public class BSTree {

  //TreeNode as root
    private TreeNode root;

//defines BSTree as null
    public BSTree(){
	     root = null;
    }
//just a note to myself that this makes use of the case i was thinking about
//earlier on (during linked lists) where I thought we might need to track ahead and behind
//at some point
//node search

  public int search(int key){
      //set first node to root to begin search
	TreeNode current = root;
//if that is not null, continue
//  if (root == null){
//    return -1;
//  }
	while (current != null){
     //if root is not empty and we have not yet reached end of list
	    int currentValue = current.getData(); //curr val is our pointer and is set to the data at current node

      if (currentValue == key){ //if that equals target alreadyin tree.

          return currentValue;        //give that value back

      } else if (currentValue > key){  //else if it is less, look to left

          current = current.getLeft();

      } else {

          current = current.getRight();  //else it must be higher, look to right
		}
	}
	// throw exception there
  throw new NullPointerException();
  	//return -1;
    }

  /*  public TreeNode searchRecursive (TreeNode root, int key) {
      // Base Cases: root is null or key is present at root
      if (root==null || root.getData()==key) {
        return root;
      }
      // val is greater than root's key
      if (root.getData() > key) {
        return search(root.getLeft(), key);
      }
      // val is less than root's key
      return search(root.getRight(), key);
    } */



//uses search guts to develop insert method
    public void insert (int key){
    //set new node to key data
    TreeNode newNode = new TreeNode (key);
  //if
   if (root == null){
      root = newNode;
      return;
    }
    //pointer to front
    TreeNode front = root;
    TreeNode trailer = root;

  while (front != null){ //if root is not empty and we have not yet reached end of list
      int frontValue = front.getData(); //curr val is our pointer and is set to the data at current node
      if (frontValue == key){ //if that equals target

          return; //we dont need to add it. leave.

    } else if (frontValue < key){  //else if it is less, look to left
          trailer = front;
          front = front.getRight();
      } else {
          trailer = front;
          front = front.getLeft();  //else it must be higher, look to right
    }
  } //end while loop
    if (key > trailer.getData()){
      trailer.setRight(newNode);
    } else {
      trailer.setLeft(newNode);
    } //end condition determining whether to set left o right
  } //end method

    public void seed(){
	  TreeNode t;

	t = new TreeNode(10);
	root = t;
	t = new TreeNode(5);
	root.setLeft(t);
	t = new TreeNode(20);
	root.setRight(t);

	root.getLeft().setRight( new TreeNode(8));

	t = new TreeNode(15);
	root.getRight().setLeft(t);

	t = new TreeNode(22);
	root.getRight().setRight(t);

	}
  private void traverse (TreeNode current){
    if (current == null){ //empty then nothing to traverse
      return;

    }

    //print out recursively the left subtree
  traverse(current.getLeft());
  //print data
  System.out.print(current.getData()+", ");
    //print out recursively the right subtree
  traverse(current.getRight());
  }


  public void traverse(){
    traverse(root);
    System.out.println("");
  }

  public void postTraverse(TreeNode current){
    if (current == null){ //empty then nothing to traverse
      return;
    }
  //left side traverse
  postTraverse(current.getLeft());
  //right side traverse
  postTraverse(current.getRight());
  //prints data
  System.out.print(current.getData()+", ");
} //end method

public void postTraverse(){
  postTraverse(root);
  System.out.println("");
}

public void preTraverse(TreeNode current){
  if (current == null){ //empty then nothing to traverse
    return;
  }
  //prints data first, then traverse
  System.out.print(current.getData()+", ");
  //left side traverse
  postTraverse(current.getLeft());
  //right side traverse
  postTraverse(current.getRight());

} //end method

public void preTraverse(){
preTraverse(root);
System.out.println("");
}

public void delete(int key){

	// if the tree is empty, nothing to delete
	if (root==null){
	    return;
	}


	// find the node that we want to delete
	// and the node above it using piggybacking
	TreeNode front = root;
	TreeNode trailer = root;

	// do the piggyback loop
	// until we either find the node or null
	// if the key isn't present
	while (front != null && front.getData() != key ){
	    if (front.getData() < key){
		trailer = front;
		front = front.getRight();
	    } else {
		trailer = front;
		front = front.getLeft();
	    }
	}

	// if the key wasn't in the tree
	if (front == null){
	    return;
	}

	// if we get here
	// front points to the node we want to delete
	// and trailer points to the one above it

	// case 1 -- the node we want to delete is a leaf
	if (front.getLeft() == null &&
	    front.getRight() == null) {

	    // repoint front's parent to null
	} else if (true /* check to see if front has one child */){
	    // repoint front's parent to front's child
	} else {
	    // front has two children
	    //
	    // find the node with the largest value
	    // on fronts left subtree
	    // and replace front with it.
	    }

	}
    

//gets root of current tree
  public TreeNode getRoot()
    {
      return root;
    }

}

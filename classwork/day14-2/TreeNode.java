import java.io.*;
import java.util.*;

public class TreeNode{
    private int data;
    private TreeNode left,right;
  //  private int count; could track # of items that are a given value

    public TreeNode(){
	     this(0);
    }
//defining left and right of root as Null
//taking in data for root
    public TreeNode(int data){
	     this.data = data;
	     left = null;
	     right = null;
    }

//setters
    public void setData(int data){
	this.data = data;
    }

    public void setLeft(TreeNode left){
	this.left = left;
    }

    public void setRight(TreeNode right){
	this.right = right;
    }


//getters
    public int getData(){
	return data;
    }

    public TreeNode getLeft(){
	return left;
    }

    public TreeNode getRight(){
	return right;
    }

    public TreeNode getRoot()
      {
        return root;
      }
}

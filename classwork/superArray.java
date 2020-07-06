import java.util.*;
import java.io.*;

/*constructs array of 10
  public int [] constrSuperArray(){
    int[] superArrayList = new int[10];
    for (int i = 0; i < superArrayList.length; i++){
      superArrayList[i]=0;
    }
    System.out.println(Arrays.toString(superArrayList));
    return superArrayList;
  }
*/
/*public static void main(String[] args) {

    superArray sa = new superArray(10);

    for (int i = 0; i < 5; i++){
      add(i,5);
    }

    System.out.println("Number of elements is "+ size());
}
*/

public class superArray{

  private int[] data;
  private int numberElements;

//PART 1

//creates a new array of specified size
//A constructor with a single parameter representing the size of the internal array
  public superArray(int size){
    data = new int[size];
    numberElements = 0;
  }
//A constructor that accepts no parameters.
//It should set the data array so that it can hold 10 elements and numberElements to 0.
//nothing stored yet inside
  public superArray(){
    data = new int [10];
    numberElements = 0;
  }

  //public SuperArray(){
  //  this(10);
  //}

//determine number of items/elements in array
public int size (){
  return numberElements;
}

//checks to see if numberElements is empty to determine array empty
public boolean isEmpty(){
  if (numberElements==0){
    return true;
  } else {
    return false;
  }
}
//cleaner way to do is isEmpty

 public boolean isEmptyClean(){
    return numberElements == 0;
  }


  public void add(int value){
    // test to see if we need to grow, then grow
    if(numberElements == data.length){
      System.out.println("There's no room!");
    } else {
    numberElements = numberElements + 1;
    data[numberElements] = value;
    }
    // add item
  }

  public void addBetter(int value){
    // test to see if we need to grow, then grow
    if(numberElements == data.length){
      this.grow();
    }
    //add one more element to element count
    //use that to set next value on array
    numberElements = numberElements + 1;
    data[numberElements] = value;
    }
//replaces a specific item on list based on index
    public void overWriteIndex (int index, int value){
      data[index] = value;
    }

//find and replaces items on list matching value
    public void findReplace (int find, int replace){
      //searches length of list
      for (int i = 0; i<data.length;i++){
        //checks if item matches int on list
        if(data[i]==find){
          //replaces if true
          data[i]=replace;
        } //end if statement
      } //end for loop
    } //method end

//inserts (aka adds at index, but since it is pushing items down also,
// i'm calling it insert)
  public void insert (int index, int value){
    // see if there's enough room
    if (numberElements==data.length){
      grow();
    }
    // shift the items down
    for (int i = numberElements; i>index; i--){
      data[i] = data[i-1];
    }
    // insert the item
    data[index] = value;
    // increment numElements
    numberElements = numberElements + 1;
  }

//removes value at given index. return -1 if oob
  public void remove(int index){
    if (index<0||index>numberElements){
      System.out.println("Not within bounds");
    }
    //creates new temp array one less in size
    int [] newData = new int[data.length-1];
    //shift items down to overwrite the item, beginning at index of original array
    for (int i = index; i < newData.length; i++){
      data[i] = data[i+1];
    }
    // subtract one fom numberElements;
    numberElements = numberElements - 1;
    //iterate thru new array copying from old array
    for (int i = 0; i < numberElements; i++) {
      newData[i]=data[i];
    }
    data = newData;  //does this overwrite correctly removing the extra item space @ end?
                    //if not, no need for this extra loop, could remove 97-100
                    //and could just jump from 95 to return data on 103.
  }


  public int get(int index){
    return data[index];
  }

//grows size of the array
  private void grow(){
    //doubles list, in case size is zero adds 1
      int [] newData = new int[2*data.length+1];
    // copy over all the elements from the old array to the new one
    for (int i = 0; i < data.length; i++){
      newData[i] = data[i];
    }
    // point data to the new array
    data = newData;
  }

//prints arrray
  public String toString(){
    String s = "";
    for (int i = 0; i < numberElements - 1; i++) {
	    if (i<numberElements - 1) {
        s = s + data[i] + ", ";
      }
      if (i==numberElements - 1){
        s = s + data[i] + ".";
      }
    }
    return s;
  }

  //
  public String debug(){
    String s = "[";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
	    s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }



}

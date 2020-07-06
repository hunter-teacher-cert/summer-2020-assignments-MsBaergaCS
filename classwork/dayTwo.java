import java.awt.Point;
import java.util.*;
import java.awt.Rectangle;

public class dayTwo {

//methods can return objects
public static Point findCenter(Rectangle box) {
      int x = box.x + box.width / 2;
      int y = box.y + box.height / 2;
      return new Point(x, y);  //create a new Point & return atst
  }

//methods can take objects as parameters
public static double distance(Point p1, Point p2) {
      int dx = p2.x - p1.x;
      int dy = p2.y - p1.y;
      return Math.sqrt(dx * dx + dy * dy);
  }


public static void main(String[] args){

  //creates a rectangle object
  Rectangle box = new Rectangle (0,0,100,200);
  System.out.println(findCenter(box));

  //modifies rectangle position but not size
  box.x = box.x + 50;
  box.y = box.y + 100;
  System.out.println(findCenter(box)); //see new center

  
  //create a point object, called blank
  //define it as having given coordinates
  Point blank = new Point(3,4);
  Point point2 = new Point(5,6);

  //attributes / x is defined as the value of the x attribute of blank
  int x = blank.x;
  int y = blank.y;


  //System.out.println(findCenter(box));
  System.out.println("the coordinates are " + blank.x + ", " + blank.y);

//points can be passed as parameters
  System.out.println(distance(blank, point2));
  //System.out.println(findCenter(box));
}


}

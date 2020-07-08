
public class Time {

    private int hour;
    private int minute;
    private double second;


//creates constructor
//no return value
//no parameters
    public Time() {
      this.hour = 0;
      this.minute = 0;
      this.second = 0.0;
    }

//allows setting of time using parameter values to define values of instance variables
      public Time(int hour, int minute, double second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
      }

      //getters
      //which let the time class 'give' information that is not otherwise public
      //no parameter, returns the type of the instance variable
      public int getHour() {
          return this.hour;
      }

      public int getMinute() {
          return this.minute;
      }

      public double getSecond() {
          return this.second;
      }

      //setters
      //which allow the otherwise inaccessible/private instance variables
      //to be defined using methods
      //parameter of the variable type to be set
public void setHour(int hour) {
    this.hour = hour;
}

public void setMinute(int minute) {
    this.minute = minute;
}

public void setSecond(double second) {
    this.second = second;
}

//method to turn time into a string for printing
public String toString() {
    return String.format("%02d:%02d:%04.1f\n",
        this.hour, this.minute, this.second);
}

//public static void printTime(){
//  System.out.println("It is "+ getHour() +":"+getMinute()+":"+getSecond());
//}



//add time method 1
//literally adds two times together, both taken as parameters
public static Time add(Time t1, Time t2){
  Time sumTime = new Time();
  sumTime.hour = t1.hour+t2.hour;
  sumTime.minute = t1.minute+t2.minute;
  sumTime.second = t1.second+t2.second;
  if (sumTime.second >= 60.0) {
        sumTime.second -= 60.0;
        sumTime.minute += 1;
    }
    if (sumTime.minute >= 60) {
        sumTime.minute -= 60;
        sumTime.hour += 1;
    }
  return sumTime;
}

//checks to see whether two values are the same
//because they are within the same object, the instance variables can be checked using
// == outside they would not refer to the same object and would not be equal even if in value they are
public boolean equals(Time that) {
    return this.hour == that.hour
        && this.minute == that.minute
        && this.second == that.second;
}

public static void printTime(Time t) {
  System.out.print("It is ");
  System.out.printf("%02d:%02d:%02.0f\n",
        t.hour, t.minute, t.second);
}

public Time otherAdd (Time t2){
  Time sum = new Time();
  sum.hour = this.hour + t2.hour;
  sum.minute = this.minute + t2.minute;
  sum.second = this.second + t2.second;
  if (sum.second >= 60.0) {
        sum.second -= 60.0;
        sum.minute += 1;
    }
    if (sum.minute >= 60) {
        sum.minute -= 60;
        sum.hour += 1;
    }
  return sum;
}

public static void main(String[] args) {

  //displays the name of the type and the address of the object in hex
    Time time = new Time(11, 59, 57.9);
    System.out.println(time);

//prints time using method
printTime(time);

//uses string method to set time to a String
String s = time.toString();
System.out.println(s);
//calls this method indirectly
System.out.println(time);
//printTime();
  //use second constructor
//Time newTime = new Time(4, 5, 1.9);

//create new instance of time object
  //  Time time = new Time();


  Time time1 = new Time(9, 30, 0.0);
  Time time2 = time1;
  Time time3 = new Time(9, 30, 0.0);

//time1 and time2 are both pointing to the same object so they are equal
//but time3 points to a different instnce, so even tho values are equal, they are not
//for this reason, the equals method (line 70) must be used

  time1.equals(time3);

  Time startTime = new Time(18, 50, 0.0);
  Time runningTime = new Time(2, 16, 0.0);
  Time endTime = Time.add(startTime, runningTime);

System.out.println(endTime);

Time endTime2 = startTime.otherAdd(runningTime);

System.out.println(endTime2);

printTime(endTime);


  } //end main
} //end class

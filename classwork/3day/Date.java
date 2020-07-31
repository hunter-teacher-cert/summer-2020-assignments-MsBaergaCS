public class Date {   //class that generates and sets date obj

  private int day;      //uses day, month and year ints
  private int month;
  private int year;

  public Date() {     //date obj containing each private int
    this.day = 0;       //this refers to the object itself
    this.month = 0;
    this.year = 0;
  }

  public Date(int day, int month, int year){    //set date using input
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDate(int day){     //set day
    this.day = day;

  }
  public void setMonth(int month){      //set month
    this.month = month;

  }
  public void setYear(int year){      //set year
    this.year = year;

  }


  public Date setBirthDay(Date bd){     //sets setBirthDay
    Date bday = new Date();
    this.day = bd.day;
    this.month = bd.month;
    this.year = bd.year;
    return bday;
  }

  public int getDay() {     //return day
      return this.day;
  }

  public int getMonth() {  //return Month
      return this.month;
  }

  public int getYear() {      //return year
      return this.year;
  }

  public static void printToDay(Date d){    //method to print date
    System.out.print("Today is ");
    System.out.printf("%02d:%02d:%02d\n",d.day, d.month, d.year);
  }

  public static void printBDay(Date d){     //method to print bday
    System.out.print("Their birthday is ");
    System.out.printf("%02d:%02d:%02d\n",d.day, d.month, d.year);
  }

  public static void main(String[] args) {  //tests



    Date today = new Date(07, 07, 20);

    printToDay(today);

    Date birth = new Date(10,12,1984);

    Date d = new Date();
    d.setBirthDay(today);

    printBDay(birth);

  }
}

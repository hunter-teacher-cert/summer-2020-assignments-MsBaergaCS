public class Date {

  private int day;
  private int month;
  private int year;

  public Date() {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }

  public Date(int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDate(int day){
    this.day = day;

  }
  public void setMonth(int month){
    this.month = month;

  }
  public void setYear(int year){
    this.year = year;

  }


  public Date setBirthDay(Date bd){
    Date bday = new Date();
    this.day = bd.day;
    this.month = bd.month;
    this.year = bd.year;
    return bday;
  }

  public int getDay() {
      return this.day;
  }

  public int getMonth() {
      return this.month;
  }

  public int getYear() {
      return this.year;
  }

  public static void printToDay(Date d){
    System.out.print("Today is ");
    System.out.printf("%02d:%02d:%02d\n",d.day, d.month, d.year);
  }

  public static void printBDay(Date d){
    System.out.print("Their birthday is ");
    System.out.printf("%02d:%02d:%02d\n",d.day, d.month, d.year);
  }

  public static void main(String[] args) {



    Date today = new Date(07, 07, 20);

    printToDay(today);

    Date birth = new Date(10,12,1984);

    Date d = new Date();
    d.setBirthDay(today);

    printBDay(birth);

  }
}

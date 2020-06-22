public class Time {
  public static void main(String[] args) {
    int hour = 6;
    int minute = 06;
    int second = 00;
    int secondCountMin = minute * 60;
    int secondCountHour = hour * 60 * 60;
    int secondInDay = 86400;
    int timeSinceMid = secondCountMin + secondCountHour;
    int timeToMid = secondInDay - timeSinceMid;
    int newHour = 6;
    int newMinute = 25;
    int newSecond = 00;
    System.out.println("Seconds since midnight:");
    System.out.println(timeSinceMid);
    System.out.println("Seconds to midnight:");
    System.out.println(timeToMid);
    System.out.print("Time elapsed working is ");
    System.out.print(newHour - hour);
    System.out.print(" hours, ");
    System.out.print(newMinute-minute);
    System.out.print(" minutes, and ");
    System.out.print(newSecond-second);
    System.out.print(" seconds, ");
    System.out.println("all well spent!");
  }
}

/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 10
*/

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) throws InvalidTimeException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first time");
        String time1 = scan.nextLine();
        System.out.println("Enter second time");
        String time2 = scan.nextLine();
        int convertedTime = calculateTime(time1, time2);
        //86400 is over the maximum seconds possible if this is returned then an error must have occurred
        if(convertedTime == 86400){
            throw new InvalidTimeException("Invalid time");
        } else {
            System.out.println("Seconds between " + time1 + " and " + time2 + " are " + convertedTime);
        }
    }

    public static int timeConverter(String time) throws InvalidTimeException {
        int hour;
        int minute;
        int second;
        try{
            String[] hms = time.split(":");
            if(hms.length != 3){
                throw new InvalidTimeException("Invalid time format");
            }
             hour = Integer.parseInt(hms[0]);
             minute = Integer.parseInt(hms[1]);
             second = Integer.parseInt(hms[2]);
        } catch (Exception e){
            System.out.println("Invalid time format");
            return 86400;
        }
        try{
            if(hour >= 24 ){
                throw new InvalidTimeException("Invalid Time");
            }
        } catch (Exception e){
            System.out.println("Hour must be below 24");
            return 86400;
        }
        try{
            if(minute >= 60){
                throw new InvalidTimeException("Invalid Time");
            }
        } catch (Exception e){
            System.out.println("Minute must be below 60");
            return 86400;
        }
        try{
            if(second >= 60){
                throw new InvalidTimeException("Invalid Time");
            }
        } catch (Exception e){
            System.out.println("second must be below 60");
            return 86400;
        }
        return (hour * 60 * 60) + (minute * 60) + second;
    }

    public static int calculateTime(String a, String b) throws InvalidTimeException {
        int time1 = timeConverter(a);
        int time2 = timeConverter(b);
        if(time1 == 86400 || time2 == 86400){
            return 86400;
        } else {
            return time1 - time2;
        }
    }
}

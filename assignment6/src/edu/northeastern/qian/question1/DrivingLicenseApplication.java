package edu.northeastern.qian.question1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DrivingLicenseApplication {

    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

    private static int getAge(Date date) {
        Date now = new Date();
        Calendar nowCalendarDate = Calendar.getInstance();
        nowCalendarDate.setTime(now);
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        int yearDiff = nowCalendarDate.get(Calendar.YEAR) - calendarDate.get(Calendar.YEAR);
        calendarDate.add(Calendar.YEAR, yearDiff);
        return calendarDate.getTime().after(now)? yearDiff - 1: yearDiff;
    }

    /**
     * The input date should be in the format of "MM/dd/yyyy", e.g. "12/7/2021"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date of birth in format MM/DD/YYYY: ");
        String input = sc.nextLine();

        Date date = null;
        Date now = new Date();

        try {
            date = formatter.parse(input);
            System.out.println(date);
        } catch (ParseException e) {
            throw new Exception("Date format error!");
        }

        int age = getAge(date);
        if (age < 16) {
            throw new Exception(String.format(
                    "The age of the applicant is %d which is too early to apply for a driving license",
                    age));
        }
    }
}

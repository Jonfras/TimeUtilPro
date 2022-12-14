package net.htlgrieskirchen.pos3.timeutil;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class TimeUtilPro {
    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########

    public static LocalDate intToLocalDate(int date) {
        LocalDate localDate;
        String stringDate = String.valueOf(date);
        if (stringDate.length() == 8) {
            try {
                localDate = LocalDate.of(
                        Integer.parseInt(stringDate.substring(0, 4)),
                        Integer.parseInt(stringDate.substring(4, 6)),
                        Integer.parseInt(stringDate.substring(6)));
            } catch (DateTimeException e) {
                log("intToLocalDate", "invalid digit");
                return null;
            }
        }
        else {
            log("intToLocalDate", "invalid Integer length");
            return null;
        }
        return localDate;
//        if (stringDate.length() != 8){
//            return null;
//        }
//        try {
//            if (Integer.parseInt(stringDate.substring(4, 6)) > 12){
//                return null;
//            }
//            if (Integer.parseInt(stringDate.substring(6)) > 31)
//        } catch (NumberFormatException e) {
//
//        }

    }

    public static LocalDate longToLocalDate(long dateTime) {
        LocalDate localDate;
        String stringDate = String.valueOf(dateTime);
        if (stringDate.length() == 12) {
            try {
                localDate = LocalDate.of(
                        Integer.parseInt(stringDate.substring(0, 4)),
                        Integer.parseInt(stringDate.substring(4, 6)),
                        Integer.parseInt(stringDate.substring(6,8)));
            } catch (DateTimeException e) {
                log("longToLocalDate", "invalid digit");
                return null;
            }
        }
        else {
            log("longToLocalDate", "invalid Long length");
            return null;
        }
        return localDate;
    }

    public static LocalDate dateToLocalDate(Date dateTime) {
        LocalDate localDate;

        try {
            localDate = LocalDate.of(
                    dateTime.getYear(),
                    dateTime.getMonth()+1,
                    dateTime.getDate());

        }
        catch (NullPointerException e){
            log("dateToLocalDate", "the given Date object was null");
            return null;
        }
        return localDate;
    }

    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        LocalDate localDate;
        try {
            localDate = LocalDate.of(
                    dateTime.get(Calendar.YEAR),
                    dateTime.get(Calendar.MONTH)+1,
                    dateTime.get(Calendar.DAY_OF_MONTH));
            
        }
        catch (NullPointerException e){
            log("calendarToLocalDate", "the given Calendar object was null");
            return null;
        }

        return localDate;
    }

    // ########## LOCALDATETIME METHODS ##########

    public static LocalDateTime intToLocalDateTime(int date) {
        return null;
    }

    public static LocalDateTime longToLocalDateTime(long dateTime) {
        return null;
    }

    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return null;
    }

    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        return null;
    }

    // ########## INT METHODS ##########

    public static int localDateToInt(LocalDate date) {
        return -1;
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        return -1;
    }

    // ########## LONG METHODS ##########

    public static long localDateToLong(LocalDate date) {
        return -1L;
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        return -1L;
    }

    // ########## DATE METHODS ##########

    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        return null;
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return null;
    }

    // ########## CALENDAR METHODS ##########

    public static Calendar localDateToCalendar(LocalDate date) {
        return null;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        return null;
    }

    public static void log(String methodName, String message) {
        System.err.println("!ERROR AT: " + methodName + ": " + message);
    }

}

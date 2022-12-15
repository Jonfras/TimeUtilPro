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

    /**
     * Länge vom jahr is zurzeit 4 stellig kunnt ma theoretisch oba a fünfstellig mocha war oba aufwand
     * und is ned in da angabe gstondn
     */

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
        } else {
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
                        Integer.parseInt(stringDate.substring(6, 8)));
            } catch (DateTimeException e) {
                log("longToLocalDate", "invalid digit");
                return null;
            }
        } else {
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
                    dateTime.getMonth(),
                    dateTime.getDate()
            );
        } catch (NullPointerException e) {
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
                    dateTime.get(Calendar.MONTH),
                    dateTime.get(Calendar.DAY_OF_MONTH));

        } catch (NullPointerException e) {
            log("calendarToLocalDate", "the given Calendar object was null");
            return null;
        }

        return localDate;
    }

    // ########## LOCALDATETIME METHODS ##########

    public static LocalDateTime intToLocalDateTime(int date) {
        LocalDateTime localDateTime;
        String stringDate = String.valueOf(date);
        if (stringDate.length() == 8) {
            try {
                localDateTime = LocalDateTime.of(
                        Integer.parseInt(stringDate.substring(0, 4)),
                        Integer.parseInt(stringDate.substring(4, 6)),
                        Integer.parseInt(stringDate.substring(6)),
                        0,
                        0
                );
            } catch (DateTimeException e) {
                log("intToLocalDateTime", "invalid digit");
                return null;
            }
        } else {
            log("intToLocalDateTime", "invalid Integer length");
            return null;
        }
        return localDateTime;
    }

    public static LocalDateTime longToLocalDateTime(long dateTime) {
        LocalDateTime localDateTime;
        String stringDate = String.valueOf(dateTime);
        if (stringDate.length() == 12) {
            try {
                localDateTime = LocalDateTime.of(
                        Integer.parseInt(stringDate.substring(0, 4)),
                        Integer.parseInt(stringDate.substring(4, 6)),
                        Integer.parseInt(stringDate.substring(6, 8)),
                        Integer.parseInt(stringDate.substring(8, 10)),
                        Integer.parseInt(stringDate.substring(10))
                );
            } catch (DateTimeException e) {
                log("longToLocalDateTime", "invalid digit");
                return null;
            }
        } else {
            log("longToLocalDateTime", "invalid Long length");
            return null;
        }
        return localDateTime;
    }

    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        LocalDateTime localDateTime;

        try {
            localDateTime = LocalDateTime.of(
                    dateTime.getYear(),
                    dateTime.getMonth(),
                    dateTime.getDate(),
                    dateTime.getHours(),
                    dateTime.getMinutes()
            );
        } catch (NullPointerException e) {
            log("dateToLocalDateTime", "the given Date object was null");
            return null;
        }
        return localDateTime;
    }

    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        LocalDateTime localDateTime;
        System.out.println();
        try {
            localDateTime = LocalDateTime.of(
                    dateTime.get(Calendar.YEAR),
                    dateTime.get(Calendar.MONTH),
                    dateTime.get(Calendar.DAY_OF_MONTH),
                    dateTime.get(Calendar.HOUR_OF_DAY),
                    dateTime.get(Calendar.MINUTE)
            );
        } catch (NullPointerException e) {
            log("calendarToLocalDateTime", "the given Calendar object was null");
            return null;
        }

        return localDateTime;
    }

    // ########## INT METHODS ##########

    public static int localDateToInt(LocalDate date) {
        return (int) convertToNumber(date, 4);
    }


    public static int localDateTimeToInt(LocalDateTime dateTime) {
        return (int) convertToNumber(dateTime.toLocalDate(), 4);
    }

    // ########## LONG METHODS ##########

    public static long localDateToLong(LocalDate date) {

        return convertToNumber(date, 9);
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        long date = convertToNumber(dateTime.toLocalDate(), 9) * 10000;
        long time = dateTime.getHour() * 100 + dateTime.getMinute();
        return date + time;

    }

    // ########## DATE METHODS ##########

    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        return new Date(date.getYear(), date.getMonthValue()-1, date.getDayOfMonth());
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        Date date = localDateToDate(dateTime.toLocalDate());
        date.setHours(dateTime.getHour());
        date.setMinutes(dateTime.getMinute());
        return date;
    }

    // ########## CALENDAR METHODS ##########

    public static Calendar localDateToCalendar(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonthValue()-1, date.getDayOfMonth());
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        Calendar calendar = localDateToCalendar(dateTime.toLocalDate());
        calendar.set(Calendar.HOUR_OF_DAY, dateTime.getHour());
        calendar.set(Calendar.MINUTE, dateTime.getMinute());
        return calendar;
    }

    private static long convertToNumber(LocalDate date, int maxYearLength) {

        StringBuilder year = new StringBuilder(String.valueOf(date.getYear()));

        if (year.toString().length() > maxYearLength) { // change this to five if you want 5 digits for the year
            log("localDateToInt", "year is to long");
            return -1;
        }

        StringBuilder month = new StringBuilder(String.valueOf(date.getMonthValue()));
        if (month.toString().length() < 2) {
            month.insert(0, 0);
        }

        StringBuilder day = new StringBuilder(String.valueOf(date.getDayOfMonth()));
        if (day.toString().length() < 2) {
            day.insert(0, 0);
        }

        String longValue = year.toString() + month + day;

        return Long.parseLong(longValue);
    }


    public static void log(String methodName, String message) {
        System.err.println("!ERROR AT: " + methodName + ": " + message);
    }
}

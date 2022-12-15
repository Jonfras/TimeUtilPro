package net.htlgrieskirchen.pos3.timeutil;

import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TimeUtilProTest {

    @Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void intToLocalDate() {
        LocalDate expected = LocalDate.of(2003, 2, 1);

        LocalDate actual = TimeUtilPro.intToLocalDate(20030201);

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void longToLocalDate() {
        LocalDate expected = LocalDate.of(2003, 2, 1);

        LocalDate actual = TimeUtilPro.longToLocalDate(200302011234L);

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void dateToLocalDate() {
        LocalDate expected = LocalDate.of(2003, 2, 1);

        //wenns mid an int bei month ned bast don muast in TimeUtilPro
        // bei Month einfoch wieder des +1 dazua doa
        // des söbe bei de mid calendar

        Date date = new Date(2003, 2, 1);
        LocalDate actual = TimeUtilPro.dateToLocalDate(date);


        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calendarToLocalDate() {
        LocalDate expected = LocalDate.of(2003,2,1);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, 2, 1);
        LocalDate actual = TimeUtilPro.calendarToLocalDate(calendar);

        assertEquals(expected, actual);
    }

    @Test
    public void intToLocalDateTime() {
        LocalDateTime expected = LocalDateTime.of(
                2003, 2, 1, 0,0);

        LocalDateTime actual = TimeUtilPro.intToLocalDateTime(20030201);

        assertEquals(expected, actual);
    }

    @Test
    public void longToLocalDateTime() {
        LocalDateTime expected = LocalDateTime.of(
                2003, 2, 1, 12,34);

        LocalDateTime actual = TimeUtilPro.longToLocalDateTime(200302011234L);

        assertEquals(expected, actual);
    }

    @Test
    public void dateToLocalDateTime() {
        LocalDateTime expected = LocalDateTime.of(
                2003, 2, 1, 12,34);

        Date date = new Date(2003, 2, 1);
        date.setHours(12);
        date.setMinutes(34);
        LocalDateTime actual = TimeUtilPro.dateToLocalDateTime(date);


        assertEquals(expected, actual);

    }

    @Test
    public void calendarToLocalDateTime() {
        LocalDateTime expected = LocalDateTime.of(
                2003, 2, 1, 12,34);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, 2, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 34);

        LocalDateTime actual = TimeUtilPro.calendarToLocalDateTime(calendar);

        assertEquals(expected, actual);
    }

    @Test
    public void localDateToInt() {
        int expected = 20030201;

        LocalDate localDate = LocalDate.of(2003, 2,1);

        int actual = TimeUtilPro.localDateToInt(localDate);

        assertEquals(expected, actual);
    }

    @Test
    public void localDateTimeToInt() {
        int expected = 20030201;

        LocalDateTime localDateTime = LocalDateTime.of(2003, 2, 1, 12, 34);

        int actual = TimeUtilPro.localDateTimeToInt(localDateTime);

        assertEquals(expected, actual);
    }

    @Test
    public void localDateToLong() {
        long expected = 9999999991231L;

        LocalDate localDate = LocalDate.of(999999999,12,31);

        long actual = TimeUtilPro.localDateToLong(localDate);

        assertEquals(expected, actual);
    }

    @Test
    public void localDateTimeToLong() {
        long expected = 200312311234L;

        LocalDateTime localDateTime = LocalDateTime.of(2003,12,31,12,34);

        long actual = TimeUtilPro.localDateTimeToLong(localDateTime);

        assertEquals(expected, actual);
    }

    @Test
    public void localDateToDate() {
        Date expected = new Date(2003, Calendar.FEBRUARY, 1);

        Date actual = TimeUtilPro.localDateToDate(LocalDate.of(2003, 2,1));

        assertEquals(expected, actual);
    }

    @Test
    public void localDateTimeToDate() {
        Date expected = new Date(2003, Calendar.FEBRUARY, 1, 12, 34);

        Date actual = TimeUtilPro.localDateTimeToDate(LocalDateTime.of(2003, 2,1,12,34));

        assertEquals(expected, actual);
    }

    @Test
    public void localDateToCalendar() {
        Calendar expected = Calendar.getInstance();
        expected.set(2003, Calendar.FEBRUARY, 1);
        expected.set(Calendar.MILLISECOND, 0);

        Calendar actual = TimeUtilPro.localDateToCalendar(LocalDate.of(2003, 2,1));

        assertEquals(expected, actual);
    }

    @Test
    public void localDateTimeToCalendar() {
        Calendar expected = Calendar.getInstance();
        expected.set(2003, Calendar.FEBRUARY, 1);
        expected.set(Calendar.HOUR_OF_DAY, 12);
        expected.set(Calendar.MINUTE, 34);

        Calendar actual = TimeUtilPro.localDateTimeToCalendar(LocalDateTime.of(2003, 2,1, 12, 34));

        assertEquals(expected, actual);
    }
}
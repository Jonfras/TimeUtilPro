package net.htlgrieskirchen.pos3.timeutil;

import org.junit.Before;
import org.junit.Test;

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

        Date date = new Date(2003, Calendar.FEBRUARY, 1);
        LocalDate actual = TimeUtilPro.dateToLocalDate(date);


        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calendarToLocalDate() {
        LocalDate expected = LocalDate.of(2003,2,1);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.FEBRUARY, 1);
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
                2003, 2, 1, 0,0);

        Date date = new Date(2003, Calendar.FEBRUARY, 1);
        LocalDateTime actual = TimeUtilPro.dateToLocalDateTime(date);


        assertEquals(expected, actual);

    }

    @Test
    public void calendarToLocalDateTime() {
    }
}
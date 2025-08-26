package com.orangeandbronze.enlistment;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void testEquals_sameObject(){
        // Schedule should equal itself
        Schedule s1 = new Schedule(Days.MTH, new Period(830, 1000));
        assertEquals(s1, s1);
    }

    @Test
    public void testEquals_equalObject(){
        // Different instances with same values are not equal (equals compares reference)
        Schedule s1 = new Schedule(Days.MTH, new Period(830, 1000));
        Schedule s2 = new Schedule(Days.MTH, new Period(830, 1000));
        assertNotEquals(s1, s2);
    }

    @Test
    public void testEquals_differentDay(){
        // Schedules with different days are not equal
        Schedule s1 = new Schedule(Days.MTH, new Period(830, 1000));
        Schedule s2 = new Schedule(Days.WS, new Period(830, 1000));
        assertNotEquals(s1, s2);
    }

    @Test
    public void testEquals_differentPeriod(){
        // Schedules with different periods are not equal
        Schedule s1 = new Schedule(Days.MTH, new Period(830,1000));
        Schedule s2 = new Schedule(Days.MTH, new Period(900,1100));
        assertNotEquals(s1, s2);
    }

    @Test
    public void testEquals_null(){
        // Schedule is not equal to null
        Schedule s1 = new Schedule(Days.MTH, new Period(830, 1000));
        assertNotEquals(null, s1);
    }

}

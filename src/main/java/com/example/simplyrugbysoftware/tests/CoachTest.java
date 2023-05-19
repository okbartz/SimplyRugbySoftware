package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Coach;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * Coach test class, the class that tests the Coach class.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class CoachTest {

    @Test
    public void setTeamAssigned() {
        Coach c = new Coach(1,1,1);
        assertEquals(1,c.getTeamAssigned());
    }

    @Test
    public void setCoachID() {
        Coach c = new Coach(1,1,1);
        assertEquals(1,c.getCoachID());
    }

    //testing for errors

    @Test
    public void setTeamAssigned2() {
        Coach c = new Coach(1,0,1);
        assertEquals(-1,c.getTeamAssigned());
    }

    @Test
    public void setCoachID2() {
        Coach c = new Coach(1,1,-1);
        assertEquals(1,c.getCoachID());
    }
}
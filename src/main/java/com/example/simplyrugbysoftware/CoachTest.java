package com.example.simplyrugbysoftware;

import org.junit.Test;

import static org.junit.Assert.*;

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
package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Squad;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * Squad test class, the class that tests the Squad class.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class SquadTest {

    @Test
    public void setTeamID() {
        Squad s = new Squad(1,"U5");
        assertEquals(1,s.getTeamID());
    }

    @Test
    public void setAgeGrade() {
        Squad s = new Squad(1,"U5");
        assertEquals("U5",s.getAgeGrade());
    }

    @Test
    public void setTeamID2() {
        Squad s = new Squad(-1,"U5");
        assertEquals(-1,s.getTeamID());
    }
}

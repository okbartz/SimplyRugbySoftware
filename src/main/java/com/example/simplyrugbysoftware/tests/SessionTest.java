package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Player;
import com.example.simplyrugbysoftware.Session;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * Session test class, the class that tests the Session class.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class SessionTest {

    @Test
    public void setSessionID() {
        Session s = new Session(1,1,32,"22/05/2023","Passing");

        assertEquals(1,s.getSessionID());
    }

    @Test
    public void setTimeLimit() {
        Session s = new Session(1,1,32,"22/05/2023","Passing");

        assertEquals(32,s.getTimeLimit());
    }

    @Test
    public void setDate() {
        Session s = new Session(1,1,32,"22/05/2023","Passing");

        assertEquals("22/05/2023",s.getDate());
    }

    @Test
    public void setActivity() {
        Session s = new Session(1,1,32,"22/05/2023","Passing");

        assertEquals("Passing",s.getActivity());
    }

    @Test
    public void setSessionID2() {
        Session s = new Session(1,0,32,"22/05/2023","Passing");

        assertEquals(0,s.getSessionID());
    }

    @Test
    public void setTimeLimit2() {
        Session s = new Session(1,1,29,"22/05/2023","Passing");

        assertEquals(29,s.getTimeLimit());
    }

    @Test
    public void setDate2() {
        Session s = new Session(1,1,32,"22052023","Passing");

        assertEquals("22052023",s.getDate());
    }

    @Test
    public void setActivity2() {
        Session s = new Session(1,1,32,"22/05/2023","1");

        assertEquals("1",s.getActivity());
    }
}
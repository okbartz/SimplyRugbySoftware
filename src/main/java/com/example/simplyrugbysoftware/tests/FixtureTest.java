package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Fixture;
import com.example.simplyrugbysoftware.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixtureTest {

    @Test
    public void setFixtureID() {
        Fixture f = new Fixture(1,1,60,"Scotstoun Stadium","23/05/2023","Rucking");
        assertEquals(1,f.getFixtureID());
    }

    @Test
    public void setPlayingField() {
        Fixture f = new Fixture(1,1,60,"Scotstoun Stadium","23/05/2023","Rucking");
        assertEquals("SCOTSTOUN STADIUM",f.getPlayingField());
    }


    @Test
    public void setSkills() {
        Fixture f = new Fixture(1,1,60,"Scotstoun Stadium","23/05/2023","Rucking");
        assertEquals("Rucking",f.getSkills());
    }

    // Testing for errors

    @Test
    public void setFixtureID2() {
        Fixture f = new Fixture(0,1,60,"Scotstoun Stadium","23/05/2023","Rucking");
        assertEquals(0,f.getFixtureID());
    }

    @Test
    public void setPlayingField2() {
        Fixture f = new Fixture(1,1,60,"Scotstoun Stadium 1","23/05/2023","Rucking");
        assertEquals("SCOTSTOUN STADIUM 1",f.getPlayingField());
    }


    @Test
    public void setSkills2() {
        Fixture f = new Fixture(1,1,60,"Scotstoun Stadium","23/05/2023","Rucking21");
        assertEquals("Rucking21",f.getSkills());
    }
}
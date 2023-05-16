package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Member;
import com.example.simplyrugbysoftware.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getFieldPosition() {
        Player p = new Player("Fly-Half",1,1,8,10,10,10,10,true);
        assertEquals("Fly-Half",p.getFieldPosition());
    }

    @Test
    public void getPassing() {
        Player p = new Player("Fly-Half",1,1,8,10,10,10,10,true);
        assertEquals(8,p.getPassing());
    }

    @Test
    public void getConsent() {
        Player p = new Player();
        p.setConsent(true);
        assertEquals(true,p.getConsent());
    }

    //testing for failures
    @Test
    public void getFieldPosition2() {
        Player p = new Player("Number 8",1,1,8,10,10,10,10,true);
        assertEquals("Number 8",p.getFieldPosition());
    }

    @Test
    public void getPassing2() {
        Player p = new Player("Fly-Half",1,1,21,10,10,10,10,true);
        assertEquals(21,p.getPassing());
    }

    @Test
    public void getPassing3() {
        Player p = new Player("Fly-Half",1,1,Integer.valueOf("eight"),10,10,10,10,true);
        assertEquals("eight",p.getPassing());
    }

    @Test
    public void getConsent2() {
        Player p = new Player();
        p.setConsent(Boolean.valueOf("yes"));
        assertEquals("yes",p.getConsent());
    }
}
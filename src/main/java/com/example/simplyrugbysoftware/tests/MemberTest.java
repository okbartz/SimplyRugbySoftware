package com.example.simplyrugbysoftware.tests;

import com.example.simplyrugbysoftware.Member;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * Member test class, the class that tests the Member class.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class MemberTest {

    @Test
    public void getFname() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("Joe",m.getFname());
    }


    @Test
    public void getSname() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("Jones",m.getSname());
    }

    @Test
    public void getSex() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("M",m.getSex());
    }

    @Test
    public void getEmail() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("joejones@gmail.com",m.getEmail());
    }

    @Test
    public void getHomeAddress() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("G52 3AY",m.getHomeAddress());
    }

    @Test
    public void getMemberID() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals(1,m.getMemberID());
    }

    @Test
    public void getDob() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("12/06/2001",m.getDob());
    }


//testing for failures

    @Test
    public void getFname2() {
        Member m = new Member("Joe1","Jones","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("Joe1",m.getFname());
    }


    @Test
    public void getSname2() {
        Member m = new Member("Joe","1","M","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("1",m.getSname());
    }

    @Test
    public void getSex2() {
        Member m = new Member("Joe","Jones","a","joejones@gmail.com","G52 3AY",1,"12/06/2001");
        assertEquals("a",m.getSex());
    }

    @Test
    public void getEmail2() {
        Member m = new Member("Joe","Jones","M","joejonesgmailcom","G52 3AY",1,"12/06/2001");
        assertEquals("joejonesgmailcom",m.getEmail());
    }

    @Test
    public void getHomeAddress2() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G523",1,"12/06/2001");
        assertEquals("G523",m.getHomeAddress());
    }

    @Test
    public void getMemberID2() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",-1,"12/06/2001");
        assertEquals(-1,m.getMemberID());
    }

    @Test
    public void getDob2() {
        Member m = new Member("Joe","Jones","M","joejones@gmail.com","G52 3AY",1,"12062001");
        assertEquals("12062001",m.getDob());
    }
}
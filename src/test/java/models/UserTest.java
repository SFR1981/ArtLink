package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {


    User user;

    @Before
    public void before(){
        user = new User ("Dave");
    }

    @Test
    public void canGetUsername(){
        assertEquals("Dave", user.getUsername());
    }

    @Test
    public void canSetUsername() {
        user.setUsername("Terry");
        assertEquals("Terry", user.getUsername());
    }

    @Test
    public void getAdverts() {
    }

    @Test
    public void setAdverts() {
    }

    @Test
    public void getImage() {
    }

    @Test
    public void setImage() {
    }
}
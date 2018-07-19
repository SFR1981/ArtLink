package models;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserTest {


    User user;
    ArrayList<Advert> adverts;
    Item item;
    Artist artist;

    @Before
    public void before() {
        user = new User("Dave");
        item = new Item("Amazing Photography", "Y", user, Category.CLOTHES, "1234");
        artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh");
        adverts = new ArrayList<Advert>();

        adverts.add(artist);
        adverts.add(item);

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
        user.setAdverts(adverts);
        assertEquals(2, user.getAdverts().size());


    }

    @Test
    public void getImage() {
        assertNull(user.getImage());
    }

    @Test
    public void setImage() {
        user.setImage("1");
        assertEquals("1",user.getImage());
    }
}
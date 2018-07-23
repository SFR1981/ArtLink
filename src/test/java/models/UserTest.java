package models;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserTest {


    User user;
    ArrayList<Advert> adverts;
    ArrayList<Comment> comments;
    Item item;
    Artist artist;
    String text;
    Comment comment;

    @Before
    public void before() {
        user = new User("Dave");
        item = new Item("Amazing Photography", "Y", user, Category.CLOTHES, "1234");
        artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh","x");
        adverts = new ArrayList<Advert>();
        comments = new ArrayList<Comment>();
        user.setComments(comments);
        text = new String ("this is a test comment and it is well good.");

        comment = new Comment(user, artist, text);


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

    @Test
    public void canGetComments(){
        assertEquals(0, user.getComments().size());

    }

    @Test
    public void canSetComments(){
        user.addCommentToList(comment);
        assertEquals(1, user.getComments().size());
    }
}
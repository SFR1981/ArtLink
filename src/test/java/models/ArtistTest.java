package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ArtistTest {


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
        artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh", "x");
        adverts = new ArrayList<Advert>();
        comments = new ArrayList<Comment>();
        artist.setComments(comments);
        text = new String("this is a test comment and it is well good.");

        comment = new Comment(user, artist, text);
    }






    @Test
    public void getName() {
        assertEquals("Mike", artist.getName());
    }

    @Test
    public void setName() {
        artist.setName("Terry");
        assertEquals("Terry", artist.getName());
    }

    @Test
    public void getSkill() {
        assertEquals("painter", artist.getSkill().getValue());
    }

    @Test
    public void setSkill() {
        artist.setSkill(Skill.ACTOR);
        assertEquals("actor", artist.getSkill().getValue());
    }

    @Test
    public void getLocation() {
        assertEquals("Edinburgh", artist.getLocation());
    }

    @Test
    public void setLocation() {
        artist.setLocation("Glasgow");
        assertEquals("Glasgow", artist.getLocation());
    }


    @Test
    public void getTitle() {
        assertEquals("Amazing paint master", artist.getTitle());
    }

    @Test
    public void setTitle() {
        artist.setTitle("x");
        assertEquals("x", artist.getTitle());
    }

    @Test
    public void getDescription() {
        assertEquals("If you need a cool design in your weird coffee shop, this is your guy", artist.getDescription());
    }

    @Test
    public void setDescription() {
        artist.setDescription("y");
        assertEquals("y", artist.getDescription());
    }

    @Test
    public void getImage() {
        assertNull(artist.getImage());
    }

    @Test
    public void setImage() {
        artist.setImage("www.image.com");
        assertEquals("www.image.com", artist.getImage());
    }

    @Test
    public void getUser() {
        assertEquals("Dave", artist.getUser().getUsername());
    }

    @Test
    public void setUser() {
        User user2 = new User("X");
        artist.setUser(user2);
        assertEquals("X", artist.getUser().getUsername());
    }

    @Test
    public void canGetContact() {
        assertEquals("me@email.com", artist.getContact());
    }

    @Test
    public void canSetContact(){
        artist.setContact("x");
        assertEquals("x", artist.getContact());
    }

    @Test
    public void canGetComments(){
        assertEquals(0, artist.getComments().size());


    }

    @Test
    public void canSetComments(){
        artist.addCommentToList(comment);
        assertEquals(1, artist.getComments().size());

    }


}
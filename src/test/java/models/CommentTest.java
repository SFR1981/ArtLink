package models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    Artist artist;
    User user;
    Comment comment;
    String text;

    @Before
    public void before()  {
        user = new User ("Dave");
        artist = new Artist("Amazing paint master","If you need a cool design in your weird coffee shop, this is your guy",user, "Mike", Skill.PAINTER,"Edinburgh", "me@email.com");
        text = new String ("this is a test comment and it is well good.");

        comment = new Comment(user, artist, text);


    }

    @Test
    public void getUser() {
        assertEquals("Dave", comment.getUser().getUsername());
    }

    @Test
    public void setUser() {
    }

    @Test
    public void getAdvert() {
        assertEquals("Amazing paint master", comment.getAdvert().getTitle());
    }

    @Test
    public void setAdvert() {
    }

    @Test
    public void getText() {
        assertEquals("this is a test comment and it is well good.", comment.getText());
    }

    @Test
    public void setText() {
        comment.setText("wha happen?");
        assertEquals("wha happen?", comment.getText());
    }
}
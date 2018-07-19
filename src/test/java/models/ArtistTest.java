package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistTest {

    Artist artist;
    User user;
    @Before
    public void before()  {
        user = new User ("Dave");
        artist = new Artist("Amazing paint master","If you need a cool design in your weird coffee shop, this is your guy",user, "Mike", Skill.PAINTER,"Edinburgh");

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
    }

    @Test
    public void setSkill() {
    }

    @Test
    public void getLocation() {
    }

    @Test
    public void setLocation() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void getImage() {
    }

    @Test
    public void setImage() {
    }

    @Test
    public void getUser() {
    }

    @Test
    public void setUser() {
    }
}
package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    Item item;
    User user;
    @Before
    public void before()  {

        user = new User ("Dave");
        item = new Item("Amazing Photography","Y",user, Category.CLOTHES, "1234" );

    }
    @Test
    public void getCategory() {
        assertEquals("clothes", item.getCategory().getValue());
    }

    @Test
    public void setCategory() {
        item.setCategory(Category.CRAFT);
        assertEquals("craft & supplies", item.getCategory().getValue());
    }

    @Test
    public void getPrice() {
        assertEquals("1234", item.getPrice());
    }

    @Test
    public void setPrice() {
        item.setPrice("2345");
        assertEquals("2345", item.getPrice());
    }
}
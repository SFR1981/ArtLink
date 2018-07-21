package db;

import models.*;

import java.util.ArrayList;

public class Seeds {
    public static  void seedData(){

        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(Artist.class);
        DBHelper.deleteAll(Item.class);
        DBHelper.deleteAll(User.class);
        User user = new User("Dave");
        DBHelper.save(user);
        Item item = new Item("Amazing Photography", "Y", user, Category.CLOTHES, "1234");
        DBHelper.save(item);
        Artist artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh", "email");
        DBHelper.save(artist);

        ArrayList adverts = new ArrayList<Advert>();

        adverts.add(artist);
        adverts.add(item);
        user.setAdverts(adverts);
        DBHelper.save(user);
    }
}

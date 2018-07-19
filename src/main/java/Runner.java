import db.DBHelper;
import models.*;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {


        User user = new User("Dave");
        DBHelper.save(user);
        Item item = new Item("Amazing Photography", "Y", user, Category.CLOTHES, "1234");
        DBHelper.save(item);
        Artist artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh");
        DBHelper.save(artist);

        ArrayList adverts = new ArrayList<Advert>();

        adverts.add(artist);
        adverts.add(item);
        user.setAdverts(adverts);
        DBHelper.save(user);


//        DBUser.getItems(user);
//        DBUser.getArtists(user);




    }
    }
import db.DBHelper;
import db.DBUser;
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        DBHelper.getAll(Advert.class);
        String x = artist.getImage();
        System.out.println(x);

        List<Advert> foundAdvert = DBUser.getAdvertsForUser(user);

        List<Category> categoryList = Arrays.asList(Category.CLOTHES, Category.CRAFT, Category.JEWELlERY, Category.MISCELLANEOUS, Category.PAINTING, Category.VINTAGE, Category.PHOTOGRAPHY);


        for (Category category : categoryList){
            System.out.println(category.getValue());
        }

        List<Category> categories = DBHelper.getAll(Category.class);

        List<Category> categories2 = Arrays.asList(Category.values());


        System.out.println(Category.PHOTOGRAPHY.ordinal());

        Category madeCategory = Category.values()[1];
    }



    }

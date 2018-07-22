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

        Item item1 = new Item("Necklace", "Join the trend but make it your own. We're pretty sure you've seen this chain everywhere lately and there's a good reason why. It looks absolutely stunning dressed up or down.", user, Category.JEWELLERY, "20.00");
        item1.setImage("http://localhost:4567/images/necklace.jpg");
        DBHelper.save(item1);

        Item item2 = new Item("Ring", " We're pretty sure you've seen this chain everywhere lately and there's a good reason why. It looks absolutely stunning dressed up or down.", user, Category.JEWELLERY, "15.89");
        item2.setImage("http://localhost:4567/images/ring.jpg");
        DBHelper.save(item2);

        Item item3 = new Item("Dresses", "The green dress will carry you stylishly through the seasons. A summer dress for every day and a gorgeous party dress for autumn/winter.", user, Category.CLOTHES, "40.00");
        item3.setImage("http://localhost:4567/images/dress.jpg");
        DBHelper.save(item3);

        Item item4 = new Item("Painting", "Title: Tuscany with trees in bloom" +
                "*Size: painting" +
                "(On request I can paint this subject in other sizes. Please, contact me)" +
                "*Frame Width: 3.35”", user, Category.PAINTING, "100.00");
        item4.setImage("http://localhost:4567/images/painting.jpg");
        DBHelper.save(item4);

        Item item5 = new Item("Craft", "Inspired by the Game of Thrones war table pieces. These map markers are cast in solid resin using metal powders, in a process known as cold casting.", user, Category.CRAFT, "30.00");
        item5.setImage("http://localhost:4567/images/craft.jpg");
        DBHelper.save(item5);


        Artist artist1 = new Artist("Painter", "Very talented young painter from Glasgow", user, "Mike", Skill.PAINTER, "Glasgow", "email@address");
        artist1.setImage("http://localhost:4567/images/logo.jpg");
        DBHelper.save(artist1);

        Artist artist2 = new Artist("Jewellery maker", "Experienced jewellery maker, looking for collaboration.", user, "Hannah", Skill.JEWELER, "Edinburgh", "email@address");
        DBHelper.save(artist2);

        Artist artist3 = new Artist("Homemade crafts", "Talented mother of three years old.", user, "Paula", Skill.MISCELLANEOUS, "Edinburgh", "address@email");
        DBHelper.save(artist3);

        Artist artist4 = new Artist("Dressmaker", "Can make any dress you want ", user, "Hamish", Skill.TAILOR, "Edinburgh", "email@address");
        DBHelper.save(artist4);


        ArrayList adverts = new ArrayList<Advert>();

        adverts.add(artist1);
        adverts.add(item1);
        user.setAdverts(adverts);
        DBHelper.save(user);
    }
}

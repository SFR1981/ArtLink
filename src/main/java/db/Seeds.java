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
        user.setImage("http://localhost:4567/images/user1.png");
        DBHelper.save(user);
        User user2 = new User("ArtBot");
        user2.setImage("http://localhost:4567/images/user2.png");
        DBHelper.save(user2);
        User user3 = new User("Bert the Bear");
        user3.setImage("http://localhost:4567/images/bearfishriver.jpg");
        DBHelper.save(user3);
        User user4 = new User("Melinda");
        user4.setImage("http://localhost:4567/images/user3.png");
        DBHelper.save(user4);
        User user5 = new User("Maria");
        user5.setImage("http://localhost:4567/images/user4.jpeg");
        DBHelper.save(user5);

        User user6 = new User("Magda");
        user6.setImage("http://localhost:4567/images/IMG_0626.JPG");
        DBHelper.save(user6);




        Item item1 = new Item("Necklace", "Join the trend but make it your own. We're pretty sure you've seen this chain everywhere lately and there's a good reason why. It looks absolutely stunning dressed up or down.", user, Category.JEWELLERY, "20.00");
        item1.setImage("http://localhost:4567/images/necklace.jpg");
        DBHelper.save(item1);

        Item item2 = new Item("Ring", " We're pretty sure you've seen this chain everywhere lately and there's a good reason why. It looks absolutely stunning dressed up or down.", user, Category.JEWELLERY, "15.89");
        item2.setImage("http://localhost:4567/images/ring.jpg");
        DBHelper.save(item2);

        Item item3 = new Item("Dresses", "The green dress will carry you stylishly through the seasons. A summer dress for every day and a gorgeous party dress for autumn/winter.", user2, Category.CLOTHES, "40.00");
        item3.setImage("http://localhost:4567/images/dress.jpg");
        DBHelper.save(item3);

        Item item4 = new Item("Painting", "Title: Tuscany with trees in bloom" +
                "*Size: painting" +
                "(On request I can paint this subject in other sizes. Please, contact me)" +
                "*Frame Width: 3.35”", user3, Category.PAINTING, "100.00");
        item4.setImage("http://localhost:4567/images/painting.jpg");
        DBHelper.save(item4);

        Item item5 = new Item("Craft", "Inspired by the Game of Thrones war table pieces. These map markers are cast in solid resin using metal powders, in a process known as cold casting.", user4, Category.CRAFT, "30.00");
        item5.setImage("http://localhost:4567/images/craft.jpg");
        DBHelper.save(item5);

        Item item6 = new Item("Best moon painting of all time!!", "I have toiled long and hard over this, I expect nothing less than the full recommended retail price of one million pounds", user2, Category.PAINTING, "1000000");
        item6.setImage("http://localhost:4567/images/moon.png");
        DBHelper.save(item6);

        Item item7 = new Item( "incrediblly realistic sculpture I have done of a fish", "so hard to tell if it is somekind of very smelly sculpture or if it was got from a river?", user3, Category.CRAFT, "£4.78/kg");
        item7.setImage("http://localhost:4567/images/salmon.png");
        DBHelper.save(item7);

        Item item8 = new Item("Angels", "Beautiful handmade angels ", user5, Category.MISCELLANEOUS, "10.00");
        item8.setImage("http://localhost:4567/images/art_angels.jpeg");
        DBHelper.save(item8);

        Item item9 = new Item("Button bowl", "Beautiful handmade button bowl ", user6, Category.MISCELLANEOUS, "40.00");
        item9.setImage("http://localhost:4567/images/buttons_craft.jpg");
        DBHelper.save(item9);

        Item item10 = new Item("Earrings", "Beautiful handmade earrings!", user5, Category.JEWELLERY, "15.00");
        item10.setImage("http://localhost:4567/images/art3.jpeg");
        DBHelper.save(item10);

        Item item11 = new Item("Paper cloths", "Beautiful paper cloths!", user6, Category.CLOTHES, "5.00");
        item11.setImage("http://localhost:4567/images/cloths.jpeg");
        DBHelper.save(item11);

        Item item12 = new Item("Vintage furniture", "Vintage chest of drawers!", user3, Category.VINTAGE, "500.00");
        item12.setImage("http://localhost:4567/images/vintage_furniture.jpeg");
        DBHelper.save(item12);

        Item item13 = new Item("Photography", "Talented photographer check my portfolio", user2, Category.PHOTOGRAPHY, "50.00");
        item13.setImage("http://localhost:4567/images/art_photo.jpeg");
        DBHelper.save(item13);

        Item item14 = new Item("Photography", "Talented photographer wants to sell some photos", user5, Category.PHOTOGRAPHY, "30.00");
        item14.setImage("http://localhost:4567/images/art2_photo.jpeg");
        DBHelper.save(item14);


        Item item15 = new Item("weird thing I found in a bin", "pretty fly, am I right?", user3, Category.MISCELLANEOUS, "£78.99");
        item15.setImage("http://localhost:4567/images/cool.jpg");
        DBHelper.save(item15);




        Artist artist1 = new Artist("Painter", "Very talented young painter from Glasgow", user2, "Mike", Skill.PAINTER, "Glasgow", "email@address");
        artist1.setImage("http://localhost:4567/images/profile1.jpeg");
        DBHelper.save(artist1);

        Artist artist2 = new Artist("Jewellery maker", "Experienced jewellery maker, looking for collaboration.", user5, "Hannah", Skill.JEWELER, "Edinburgh", "email@address");
        artist2.setImage("http://localhost:4567/images/profile2.png");
        DBHelper.save(artist2);


        Artist artist3 = new Artist("Homemade crafts", "Talented mother of three years old.", user6, "Paula", Skill.MISCELLANEOUS, "Edinburgh", "address@email");
        artist3.setImage("http://localhost:4567/images/profile3.jpeg");
        DBHelper.save(artist3);

        Artist artist4 = new Artist("Dressmaker", "Can make any dress you want ", user4, "Hamish", Skill.TAILOR, "Edinburgh", "email@address");
        artist4.setImage("http://localhost:4567/images/profile4.jpeg");
        DBHelper.save(artist4);

        Artist artist5 = new Artist("performance artist", "I take a lot of inspiration from the wild, and am often complemented on my convincing portrayals of large bears", user3, "Bert", Skill.ACTOR, "Edinburgh", "send me a letter or something");
        artist5.setImage("http://localhost:4567/images/profile5.jpeg");
        DBHelper.save(artist5);


        ArrayList adverts = new ArrayList<Advert>();

        adverts.add(artist1);
        adverts.add(item1);
        user.setAdverts(adverts);
        DBHelper.save(user);
    }
}

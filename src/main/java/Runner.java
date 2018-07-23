import db.DBArtist;
import db.DBHelper;
import db.DBItem;
import db.DBUser;
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {


        User user = new User("Dave");
        User user2 = null;
        DBHelper.save(user);
        Item item = new Item("Amazing Photography", "Y", user, Category.CLOTHES, "1234");
        Item item2 = new Item("Amazing Photography", "Y", user2, Category.CLOTHES, "1234");
        DBHelper.save(item);
        DBHelper.save(item2);
        Artist artist = new Artist("Amazing paint master", "If you need a cool design in your weird coffee shop, this is your guy", user, "Mike", Skill.PAINTER, "Edinburgh", "email");
        DBHelper.save(artist);
        Artist artist2 = new Artist("test", "test", user, "mike",Skill.ACTOR, "place", "email");
        DBHelper.save(artist2);
        ArrayList adverts = new ArrayList<Advert>();

        adverts.add(artist);
        adverts.add(item);
        user.setAdverts(adverts);
        DBHelper.save(user);
        String text;
        text = new String("test comment");
        Comment comment;
        comment = new Comment(user, artist, text);
        DBHelper.save(comment);
        ArrayList<Comment> comments;
        comments = new ArrayList<Comment>();
        user.setComments(comments);
        user.addCommentToList(comment);
        artist.setComments(comments);
        artist.addCommentToList(comment);

        DBHelper.save(user);
        DBHelper.save(artist);





        Artist artistTest = new Artist("x", "x", user, "x", Skill.ACTOR, "x", "x");
        artistTest.setImage("test");

        DBHelper.save(artistTest);

//        DBUser.getItems(user);
//        DBUser.getArtists(user);

        DBHelper.getAll(Advert.class);
        String x = artist.getImage();
        System.out.println(x);

        List<Advert> foundAdvert = DBUser.getAdvertsForUser(user);

        List<Item> foundItem = DBUser.getItemsForUser(user);

        List<Artist> foundArtist = DBUser.getArtistsForUser(user);














        List<Category> categoryList = Arrays.asList(Category.CLOTHES, Category.CRAFT, Category.JEWELLERY, Category.MISCELLANEOUS, Category.PAINTING, Category.VINTAGE, Category.PHOTOGRAPHY);


        for (Category category : categoryList){
            System.out.println(category.getValue());
        }

        List<Category> categories = DBHelper.getAll(Category.class);

        List<Category> categories2 = Arrays.asList(Category.values());


        System.out.println(Category.PHOTOGRAPHY.ordinal());

        Category madeCategory = Category.values()[1];


        Category newCategory = Category.values()[6];


        int d = item2.getCategory().ordinal();


        List<Item> foundClothes = DBItem.getItemsForCategory(Category.JEWELLERY);

        List<Artist> foundPainter = DBArtist.getArtistsFor(Skill.PAINTER);

    }



    }

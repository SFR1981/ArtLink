package db;

import com.sun.tools.javac.jvm.Items;
import models.Advert;
import models.Artist;
import models.Item;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBUser {



    private static Session session;



    public static List<Advert> getAdvertsForUser(User user){
        List<Advert> ads = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq( "user", user));
            ads = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return ads;
    }


    public static List<Item> getItemsForUser(User user){
        List<Item> items = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Item.class);
            cr.add(Restrictions.eq( "user", user));
            items = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return items;
    }


    public static List<Artist> getArtistsForUser(User user){
        List<Artist> artists = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Artist.class);
            cr.add(Restrictions.eq( "user", user));
            artists = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return artists;
    }




}
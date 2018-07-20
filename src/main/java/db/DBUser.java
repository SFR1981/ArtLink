package db;

import models.Advert;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBUser {
}


    private static Session session;



    public static List<Advert> getAdvertsForUser(User user){
        List<Advert> ads = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.createAlias("cast","actor" );
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return films;
    }


    public static List<Film> getFilmsByGenre(Actor actor, Genre genre){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("cast","actor" );
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            cr.add(Restrictions.eq("genre", genre));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return films;
    }


}
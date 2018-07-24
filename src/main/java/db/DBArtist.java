package db;

import com.sun.tools.javac.jvm.Items;
import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class DBArtist {


    private static Session session;


    public static List<Artist> getArtistsFor(Skill skill) {
        List<Artist> artists = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Artist.class);
            cr.add(Restrictions.eq("skill", skill));
            artists = cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return artists;
    }


}











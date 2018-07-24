package db;

import com.sun.tools.javac.jvm.Items;
import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class DBItem {


    private static Session session;


    public static List<Item> getItemsForCategory(Category category) {
        List<Item> items = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Item.class);
            cr.add(Restrictions.eq("category", category));
            items = cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return items;
    }


}











package db;

import com.sun.tools.javac.jvm.Items;
import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class DBComment {


    private static Session session;


    public static void addComment(Comment comment, User user, Advert advert){
        user.addCommentToList(comment);
        advert.addCommentToList(comment);
        DBHelper.save(user);
        DBHelper.save(advert);
        DBHelper.save(comment);
    }


}











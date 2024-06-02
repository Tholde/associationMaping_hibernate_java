package database;

import entity.Association;
import entity.Member;
import entity.Passport;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Database {
    Session session = null;
    Transaction tx = null;

    public void create(Person person, Passport passport) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(passport);
            session.save(person);
            tx.commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void createAssociation(Association association) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(association);
            tx.commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void createMember(Member member) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(member);
            tx.commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

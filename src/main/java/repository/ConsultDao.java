package repository;

import model.Consult;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

public class ConsultDao {

    public Consult findByIdConsult(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Consult consult = session.find(Consult.class, id);
            return consult;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createConsult(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteConsult(Consult Consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(Consult);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateConsult(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(consult);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
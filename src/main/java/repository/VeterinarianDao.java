package repository;

import model.Pet;
import model.Veterinarian;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class VeterinarianDao {
    public  Veterinarian findByIdVeterinarian(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Veterinarian veterinarian = session.find(Veterinarian.class, id);
            session.close();
            return  veterinarian;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }

    public  void createVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public void deleteVeterinarian(Veterinarian veterinarian) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateVeterinarian(Veterinarian veterinarian) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public List<Veterinarian> findByNameVet(String firstName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian where firstName=:firstName", Veterinarian.class);
            query.setParameter("firstName", firstName);

            List<Veterinarian> veterinarianList =  query.list();

            return veterinarianList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public List<Veterinarian> displayVet() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian", Veterinarian.class);
            List<Veterinarian> vets = query.list();
            return vets;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void displayAllVets() {
        List<Veterinarian> vets = displayVet();
        System.out.println("\tVets: \t");
        for (Veterinarian vet : vets) {
            System.out.println(vet);
        }
    }
}
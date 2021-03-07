package repository;
import model.Pet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class PetDao {
    public Pet findByIdPet(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Pet Pet = session.find(Pet.class, id);
            session.close();
            return Pet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createPet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deletePet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updatePet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public List<Pet> displayPets() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pet", Pet.class);
            List<Pet> pets = query.list();
            return pets;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void displayAllPets() {
        List<Pet> pets = displayPets();
        System.out.println("\tPets: \t");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

}
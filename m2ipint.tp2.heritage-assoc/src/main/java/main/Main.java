package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

public class Main {

	private static final String PERSISTENCE_UNIT_NAME = "companies";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // create new todo
        em.getTransaction().begin();
        Company aCompany = new Company();
        aCompany.setName("Boulangerie Nicolas");
        em.persist(aCompany);
        em.getTransaction().commit();
        
        // read the existing entries and write to console
        Query q = em.createQuery("select c from Company c");
        List<Company> compList = q.getResultList();
        for (Company comp : compList) {
            System.out.println(comp);
        }
        System.out.println("Size: " + compList.size());

        em.close();
    }

}

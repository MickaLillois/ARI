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
        Employee anEmp = new Employee();
        anEmp.setLastname("JOURNAULT");
        anEmp.setFirstname("Rémi");
        anEmp.setAge(23);
        em.persist(anEmp);
        Address anAddress = new Address();
        anAddress.setCity("Lille Hellemmes");
        anAddress.setCountry("FRANCE");
        anAddress.setStreet("Rue Victor Hugo");
        anAddress.setStreetNumber(42);
        anAddress.setZipCode("59260");
        
        anEmp.addAddress(anAddress);
        anEmp.setCompany(aCompany);
        aCompany.getEmployeeList().add(anEmp);
        em.persist(anAddress);
        em.persist(aCompany);
        em.persist(anEmp);
        
        // read the existing entries and write to console
        Query q = em.createQuery("select c from Company c");
        List<Company> compList = q.getResultList();
        for (Company comp : compList) {
            System.out.println(comp);
            for(Employee emp : comp.getEmployeeList()) {
            	System.out.println(emp);
            }
        }

        em.getTransaction().commit();
        
        

        em.close();
    }

}

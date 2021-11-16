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

        em.getTransaction().begin();
        
        
        Company aCompany = new Company();
        aCompany.setName("Boulangerie Nicolas");

        Team aTeam = new Team();
        aTeam.setName("Team BS");
        
        Employee anEmp1 = new Employee();
        anEmp1.setLastname("JOURNAULT");
        anEmp1.setFirstname("Rémi");
        anEmp1.setAge(23);
        Employee anEmp2 = new Employee();
        anEmp2.setLastname("BAUDRY");
        anEmp2.setFirstname("Manon");
        anEmp2.setAge(56);
        
        //anEmp1.addTeam(aTeam);
        anEmp1.setTeam(aTeam);
        anEmp1.setTeam(aTeam);
        
        Address anAddress = new Address();
        anAddress.setCity("Lille Hellemmes");
        anAddress.setCountry("FRANCE");
        anAddress.setStreet("Rue Victor Hugo");
        anAddress.setStreetNumber(42);
        anAddress.setZipCode("59260");
        
        Project aProj1 = new Project();
        aProj1.setName("Projet Cool");
        Project aProj2 = new Project();
        aProj2.setName("Projet Super Cool");
        
        anEmp1.addProject(aProj1);
        anEmp1.addProject(aProj2);
        anEmp2.addProject(aProj1);
        anEmp2.addProject(aProj2);
        
        anEmp1.addAddress(anAddress);
        anEmp1.setCompany(aCompany);
        anEmp2.setCompany(aCompany);
        aCompany.getEmployeeList().add(anEmp1);
        aCompany.getEmployeeList().add(anEmp2);
        
        em.persist(anAddress);
        em.persist(aTeam);
        em.persist(aCompany);
        em.persist(anEmp1);
        em.persist(anEmp2);
        em.persist(aProj1);
        em.persist(aProj2);
        
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

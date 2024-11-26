package pe.edu.i202221471.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221471.entity.Country;

public class JPARemove {
    public static void main(String[] args){
    // referenciar a la unidad de persistencia
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WORLD_PU");
    EntityManager em = emf.createEntityManager();
    // Referenciar
    Country country = em.find(Country.class, "LUX");
    // eliminar Country
    em.getTransaction().begin();
    em.remove(country);
    em.getTransaction().commit();

    }

}

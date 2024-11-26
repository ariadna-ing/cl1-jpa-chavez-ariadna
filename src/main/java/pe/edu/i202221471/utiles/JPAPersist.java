package pe.edu.i202221471.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221471.entity.City;
import pe.edu.i202221471.entity.Country;
import pe.edu.i202221471.entity.CountryLanguage;
import pe.edu.i202221471.entity.LanguagePk;

import java.util.ArrayList;
import java.util.List;

public class JPAPersist {

    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WORLD_PU");
        EntityManager em = emf.createEntityManager();
        // Iniciar la transacción
        em.getTransaction().begin();

        // Registrar un país
        Country country = new Country("LUX", "Luxre", "Oceania", "Islas ", 1000.0,
                1980, 500000, 75.0, 100000.0, 80000.0, "Luxre H",
                "Republic", "Alex Pérez Flores",  12, "LU",null,null);
        // Persistir el país
        em.persist(country);
        // Registrar ciudades asociadas al país
        City city1 = new City(null, "Ciudad 1", "Distrito 1", 200000, country);
        City city2 = new City(null, "Ciudad 2", "Distrito 2", 150000, country);
        City city3 = new City(null, "Ciudad 3", "Distrito 3", 100000, country);

        // Crear y registrar idiomas asociados al país
        LanguagePk languagePk1 = new LanguagePk("LUX", "Español");
        LanguagePk languagePk2 = new LanguagePk("LUX", "Ingles");
        CountryLanguage language1 = new CountryLanguage(languagePk1, true, 80.0, country);
        CountryLanguage language2 = new CountryLanguage(languagePk2, false, 20.0, country);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("Pais y ciudades persistidos con éxito.");
    }


}

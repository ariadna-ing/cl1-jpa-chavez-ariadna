package pe.edu.i202221471.utiles;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import pe.edu.i202221471.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        // Crear la instancia de EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WORLD_PU");
        EntityManager em = emf.createEntityManager();
        try {
            // Buscar el país "PER" usando find
            String countryCode = "PER";
            Country country = em.find(Country.class, countryCode);
            // Verificar si  fue encontrado
            if (country != null) {
                System.out.println("Ciudades de " + country.getName() + " con población mayor a 700,000:");
                // Filtrar y mostrar las ciudades con población > 700k
                country.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName() + " - Población: " + city.getPopulation()));
            } else {
                System.out.println("No se encontró el país con el código " + countryCode);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }
    }
}
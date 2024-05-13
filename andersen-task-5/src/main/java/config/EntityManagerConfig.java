package config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {

    private final static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("test");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

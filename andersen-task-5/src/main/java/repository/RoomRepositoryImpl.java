package repository;

import config.EntityManagerConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Room;


import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public RoomRepositoryImpl() {
        this.entityManager = EntityManagerConfig.getEntityManager();
    }

    @Override
    public List<Room> getAllRooms() {
        return entityManager.createQuery("from Room", Room.class).getResultList();
    }

    @Override
    public void save(Room room) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(room);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Room update(Room room) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(room);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return room;
    }

    @Override
    public boolean deleteByNumber(Integer number) {
        try {
            entityManager.getTransaction().begin();
            Room room = entityManager.find(Room.class, number);
            entityManager.remove(room);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return false;
    }
}

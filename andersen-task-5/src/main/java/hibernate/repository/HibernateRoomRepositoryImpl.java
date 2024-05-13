package hibernate.repository;

import config.HibernateSessionFactoryUtil;
import model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateRoomRepositoryImpl implements HibernateRoomRepository {

    @Override
    public List<Room> getAllRooms() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("from Room", Room.class).list();
    }

    @Override
    public void save(Room room) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
    }

    @Override
    public Room update(Room room) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public void deleteByNumber(Integer number) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, number);
        session.delete(room);
        transaction.commit();
        session.close();
    }
}

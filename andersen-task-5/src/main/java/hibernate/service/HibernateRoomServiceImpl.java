package hibernate.service;

import hibernate.repository.HibernateRoomRepository;
import hibernate.repository.HibernateRoomRepositoryImpl;
import model.Room;

import java.util.List;

public class HibernateRoomServiceImpl implements HibernateRoomService {

    private final HibernateRoomRepository hibernateRoomRepository = new HibernateRoomRepositoryImpl();

    @Override
    public List<Room> getAllRooms() {
        return hibernateRoomRepository.getAllRooms();
    }

    @Override
    public void save(Room room) {
        hibernateRoomRepository.save(room);
    }

    @Override
    public Room update(Room room) {
        return hibernateRoomRepository.update(room);
    }

    @Override
    public void deleteByNumber(Integer number) {
        hibernateRoomRepository.deleteByNumber(number);
    }
}

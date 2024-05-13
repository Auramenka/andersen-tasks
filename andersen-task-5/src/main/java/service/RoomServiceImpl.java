package service;

import model.Room;
import repository.RoomRepository;
import repository.RoomRepositoryImpl;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository = new RoomRepositoryImpl();

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room update(Room room) {
        return roomRepository.update(room);
    }

    @Override
    public boolean deleteByNumber(Integer number) {
        return roomRepository.deleteByNumber(number);
    }
}

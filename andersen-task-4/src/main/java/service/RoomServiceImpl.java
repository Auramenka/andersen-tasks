package service;

import db.ConnectionManager;
import model.Room;
import repository.RoomRepository;
import repository.RoomRepositoryImpl;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final ConnectionManager connection = new ConnectionManager();
    private final RoomRepository roomRepository = new RoomRepositoryImpl(connection);

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void update(Room room, Boolean access) {
        roomRepository.update(room, access);
    }

    @Override
    public boolean deleteByNumber(Integer number) {
        return roomRepository.deleteByNumber(number);
    }
}

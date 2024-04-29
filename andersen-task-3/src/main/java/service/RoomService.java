package service;

import model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    public Room createRoom(int number) {
        checkNumberOfRoom(number);
        Room room = new Room();
        room.setNumber(number);
        rooms.add(room);
        return room;
    }

    public boolean deleteByNumber(int number) {
        checkNumberOfRoom(number);
        return rooms.removeIf(room -> room.getNumber() == number);
    }

    public void updateRoom(int number, boolean access) {
        for (Room r : rooms) {
            if (number == r.getNumber()) {
                r.setAccess(access);
                return;
            }
        }
        throw new RuntimeException("Number of room can't exist");
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    private void checkNumberOfRoom(int number) {
        if (number <= 0) {
            throw new RuntimeException("Number of room can't be negative");
        }
    }
}

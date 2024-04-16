package service;

import model.Room;

public class RoomService {

    public Room createRoom(int number) {
        checkNumberOfRoom(number);
        return new Room(number);
    }

    private void checkNumberOfRoom(int number) {
        if (number <= 0) {
            throw new RuntimeException("Number of room can't be negative");
        }
    }
}

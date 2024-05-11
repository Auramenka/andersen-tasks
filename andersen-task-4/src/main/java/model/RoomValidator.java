package model;


public class RoomValidator {

    public boolean checkRoomAccess(Room room) {
        return room.isAccess();
    }
}

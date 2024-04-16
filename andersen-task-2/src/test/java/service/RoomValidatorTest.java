package service;

import model.Room;
import model.RoomValidator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoomValidatorTest  {

    private final RoomValidator testSubject = new RoomValidator();

    @Test
    void shouldCheckAvailabilityWithValidCurrentRoom() {
        //given
        Room room = new Room(15);
        room.setAccess(true);
        //when
        boolean result = testSubject.checkRoomAccess(room);
        //then
        assertEquals(result, room.isAccess());
    }

    @Test
    void shouldCheckAvailabilityWithNotValidCurrentRoom() {
        //given
        Room room = new Room(87);
        room.setAccess(false);
        //when
        boolean result = testSubject.checkRoomAccess(room);
        //then
        assertEquals(result, room.isAccess());
    }
}
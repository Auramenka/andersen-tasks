package service;

import model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomServiceTest {

    private final RoomService testSubject = new RoomService();

    @Test
    void shouldSaveCurrentRoom() {
        //given
        int number = 15;
        //when
        Room result = testSubject.createRoom(number);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(15, result.getNumber());
    }

    @Test
    void shouldNotSaveRoom_thenException() {
        //given
        int number = -1;
        //when
        RuntimeException result = Assertions.assertThrows(RuntimeException.class, () -> testSubject.createRoom(number));
        //then
        Assertions.assertEquals("Number of room can't be negative", result.getMessage());
    }

}
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

    @Test
    void shouldDeleteExistedRoom() {
        //given
        testSubject.createRoom(15);
        testSubject.createRoom(16);
        //when
        boolean result = testSubject.deleteByNumber(16);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldNotDeleteRoom_thenException() {
        //given
        testSubject.createRoom(15);
        testSubject.createRoom(16);
        //when
        RuntimeException result = Assertions.assertThrows(RuntimeException.class, () -> testSubject.deleteByNumber(-5));
        //then
        Assertions.assertEquals("Number of room can't be negative", result.getMessage());
    }

    @Test
    void shouldNotUpdateExistedRoom_thenException() {
        //given
        testSubject.createRoom(15);
        //when
        RuntimeException result = Assertions.assertThrows(RuntimeException.class, () -> testSubject.updateRoom(16, true));
        //then
        Assertions.assertEquals("Number of room can't exist", result.getMessage());
    }
}
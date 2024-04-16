package service;

import model.ReservationDate;
import model.Room;
import model.RoomValidator;
import model.Status;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationRoomServiceTest {

    @Mock
    private ReservationDateService reservationDateService;

    @Mock
    private RoomValidator roomValidator;

    @InjectMocks
    private ReservationRoomService testSubject;

    @Test
    void shouldBookRoomWithValidRoomAndReservationDate() {
        //given
        LocalDate currentDate = LocalDate.now();
        LocalDate dateStart = currentDate.plusDays(5);
        LocalDate dateEnd = currentDate.plusDays(13);
        ReservationDate reservation = new ReservationDate();
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
        Room room = new Room(18);
        room.setAccess(true);
        when(reservationDateService.availableReservationDate(reservation)).thenReturn(true);
        when(roomValidator.checkRoomAccess(room)).thenReturn(true);
        //when
        Status result = testSubject.reserveRoom(reservation, room);
        //then
        assertEquals(Status.OK, result);
        verify(reservationDateService, times(1)).availableReservationDate(reservation);
        verify(roomValidator, times(1)).checkRoomAccess(room);
    }

    @Test
    void shouldNotBookRoomAlreadyOccupiedRoomAndReservationDate() {
        //given
        LocalDate currentDate = LocalDate.now();
        LocalDate dateStart = currentDate.plusDays(5);
        LocalDate dateEnd = currentDate.plusDays(13);
        ReservationDate reservation = new ReservationDate();
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
        Room room = new Room(19);
        when(reservationDateService.availableReservationDate(reservation)).thenReturn(true);
        when(roomValidator.checkRoomAccess(room)).thenReturn(false);
        //when
        Status result = testSubject.reserveRoom(reservation, room);
        //then
        assertEquals(Status.ERROR, result);
        verify(reservationDateService, times(1)).availableReservationDate(reservation);
        verify(roomValidator, times(1)).checkRoomAccess(room);
    }
}
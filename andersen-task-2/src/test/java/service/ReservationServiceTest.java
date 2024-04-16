package service;

import model.ReservationDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ReservationServiceTest {

    private final ReservationDateService testSubject = new ReservationDateService();

    @Test
    void shouldNotMakeReservationDateStartNotExist_thenException() {
        //given
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setDateStart(null);
        //when
        RuntimeException result = assertThrows(RuntimeException.class,
                () -> testSubject.availableReservationDate(reservationDate));
        //then
        assertEquals("You can't make reservation from this date", result.getMessage());
    }

    @Test
    void shouldNotMakeReservationDateEndNotExist_thenException() {
        //given
        ReservationDate reservationDate = new ReservationDate();
        LocalDate currentDate = LocalDate.now();
        LocalDate dateStart = currentDate.plusDays(4);
        reservationDate.setDateStart(dateStart);
        reservationDate.setDateEnd(null);
        //when
        RuntimeException result = assertThrows(RuntimeException.class,
                () -> testSubject.availableReservationDate(reservationDate));
        //then
        assertEquals("You can't make reservation to this date", result.getMessage());
    }

    @Test
    void shouldNotMakeReservationDateStartAndDateEndNotExist_thenException() {
        //given
        ReservationDate reservationDate = new ReservationDate();
        LocalDate currentDate = LocalDate.now();
        LocalDate dateStart = currentDate.plusDays(5);
        LocalDate dateEnd = currentDate.minusDays(8);
        reservationDate.setDateStart(dateStart);
        reservationDate.setDateEnd(dateEnd);
        //when
        RuntimeException result = assertThrows(RuntimeException.class,
                () -> testSubject.availableReservationDate(reservationDate));
        //then
        assertEquals("You can't make reservation on this date", result.getMessage());
    }

    @Test
    void shouldMakeReservationOnAvailableDateStartAndDateEnd() {
        //given
        LocalDate currentDate = LocalDate.now();
        LocalDate dateStart = currentDate.plusDays(3);
        LocalDate dateEnd = dateStart.plusDays(17);
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setDateStart(dateStart);
        reservationDate.setDateEnd(dateEnd);
        //when
        boolean result = testSubject.availableReservationDate(reservationDate);
        //then
        assertTrue(result);
    }
}
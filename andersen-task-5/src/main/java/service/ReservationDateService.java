package service;

import model.ReservationDate;

import java.time.LocalDate;

public class ReservationDateService {

    public boolean availableReservationDate(ReservationDate reservationDate) {

        checkDateOfReservation(reservationDate);
        checkReservationOnThisDate(reservationDate);

        return reservationDate.getDateStart().isBefore(reservationDate.getDateEnd())
                && reservationDate.getDateEnd().isAfter(reservationDate.getDateStart());
    }

    private void checkDateOfReservation(ReservationDate reservationDate) {
        if (reservationDate.getDateStart() == null) {
            throw new RuntimeException("You can't make reservation from this date");
        }

        if (reservationDate.getDateEnd() == null) {
            throw new RuntimeException("You can't make reservation to this date");
        }
    }

    private void checkReservationOnThisDate(ReservationDate reservationDate) {
        if (reservationDate.getDateStart().isAfter(LocalDate.now())
                && !reservationDate.getDateEnd().isAfter(reservationDate.getDateStart())) {
            throw new RuntimeException("You can't make reservation on this date");
        }
    }
}

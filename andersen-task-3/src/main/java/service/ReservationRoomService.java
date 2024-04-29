package service;

import model.*;

public class ReservationRoomService {

    private final ReservationDateService reservationDateService;
    private final RoomValidator roomValidator;

    public ReservationRoomService(ReservationDateService reservationDateService, RoomValidator roomValidator) {
        this.reservationDateService = reservationDateService;
        this.roomValidator = roomValidator;
    }

    public Status reserveRoom(ReservationDate reservationDate, Room room) {
        ReservationRoom reservationRoom = new ReservationRoom();
        if (reservationDateService.availableReservationDate(reservationDate) && roomValidator.checkRoomAccess(room)) {
            reservationRoom.setStatus(Status.OK);
        } else {
            reservationRoom.setStatus(Status.ERROR);
        }
        return reservationRoom.getStatus();
    }
}

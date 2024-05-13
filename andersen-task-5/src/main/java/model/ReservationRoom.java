package model;

public class ReservationRoom {

    private Status status;

    public ReservationRoom() {
    }

    public ReservationRoom(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

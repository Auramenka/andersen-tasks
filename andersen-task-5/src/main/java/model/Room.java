package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    private int number;

    private boolean access;

    public Room() {
    }

    public Room(int number, boolean access) {
        this.number = number;
        this.access = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", access=" + access +
                '}';
    }
}

package model;

public class Room {
    private int number;
    private boolean access;

    public Room(int number) {
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
}

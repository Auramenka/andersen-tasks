package db;

public class SQLRequests {

    public static final String SAVE_ROOM = "insert into room (number, access) values (?, ?)";
    public static final String GET_ALL_ROOMS = "select number, access from room";
    public static final String DELETE_BY_NUMBER_OF_ROOM = "delete from room where number = ?";
    public static final String UPDATE_ROOM = "update room set access = ? where number = ?";
}

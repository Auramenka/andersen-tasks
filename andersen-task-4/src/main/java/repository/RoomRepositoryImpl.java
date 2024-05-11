package repository;

import db.ConnectionManager;
import db.SQLRequests;
import model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    private final ConnectionManager connectionManager;

    public RoomRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLRequests.GET_ALL_ROOMS);
            while (resultSet.next()) {
                Room room = new Room();
                room.setNumber(resultSet.getInt("number"));
                room.setAccess(resultSet.getBoolean("access"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room save(Room room) {
        checkNumberOfRoom(room.getNumber());
        try (PreparedStatement preparedStatement = connectionManager.getConnection()
                .prepareStatement(SQLRequests.SAVE_ROOM)) {
            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setBoolean(2, room.isAccess());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public Room update(Room room, Boolean access) {
        try (PreparedStatement preparedStatement = connectionManager.getConnection()
                .prepareStatement(SQLRequests.UPDATE_ROOM)) {
            preparedStatement.setBoolean(1, access);
            preparedStatement.setInt(2, room.getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public boolean deleteByNumber(Integer number) {
        checkNumberOfRoom(number);
        List<Room> allRooms = getAllRooms();
        for (Room room : allRooms) {
            if (room.getNumber() == number) {
                try (PreparedStatement preparedStatement = connectionManager.getConnection()
                        .prepareStatement(SQLRequests.DELETE_BY_NUMBER_OF_ROOM)) {
                    preparedStatement.setInt(1, number);
                    preparedStatement.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private void checkNumberOfRoom(int number) {
        if (number <= 0) {
            throw new RuntimeException("Number of room can't be negative");
        }
    }
}

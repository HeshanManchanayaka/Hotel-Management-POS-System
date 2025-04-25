package controller.Room;

import Model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    boolean addRoom(Room room) throws SQLException;
    boolean updateRoom(Room room) throws SQLException;
    Room searchRoom(String room_no) throws SQLException;
    List<Room> getAll() throws SQLException;
    boolean deleteRoom(String id);

}

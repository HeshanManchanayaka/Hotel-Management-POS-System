package controller.Room;

import Model.Customer;
import Model.Room;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomController implements RoomService{
    @Override
    public boolean addRoom(Room room) throws SQLException {
        PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("Insert into Rooms (room_number, room_type, price_per_night, availability_status) Values(?,?,?,?)");
        prs.setString(1, String.valueOf(room.getNumber()));
        prs.setString(2, room.getType());
        prs.setString(3, String.valueOf(room.getPricePerNight()));
        prs.setString(4, room.getAvailabilityStatus());

        int res = prs.executeUpdate();
        return res>0;
    }

    @Override
    public boolean updateRoom(Room room) throws SQLException {
        PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("UPDATE Rooms SET room_type = ?, price_per_night = ?, availability_status = ? WHERE room_number = ?");
        System.out.println(room);
        prs.setString(1, room.getType());
        prs.setDouble(2, room.getPricePerNight());
        prs.setString(3, room.getAvailabilityStatus());
        prs.setString(4, room.getNumber());

        int res = prs.executeUpdate();
        return res > 0;

    }

    @Override
    public Room searchRoom(String room_no) throws SQLException {
         PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("SELECT room_number , room_type, price_per_night, availability_status FROM Rooms WHERE room_number = ?");
            prs.setString(1, room_no);
            ResultSet rst = prs.executeQuery();
        System.out.println(rst);
            if(rst.next()){
               Room room = new Room(rst.getString("room_number"),rst.getString("room_type"),rst.getDouble("price_per_night"),rst.getString("availability_status"));
                System.out.println(room);
               return room;
            }
            return null;
    }

    @Override
    public List<Room> getAll() throws SQLException {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT room_number , room_type , price_per_night , availability_status FROM rooms");

        while (resultSet.next()) {
            Room room = new Room(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            roomArrayList.add(room);
        }

        return roomArrayList;
    }

    @Override
    public boolean deleteRoom(String id) {
        return false;
    }
}

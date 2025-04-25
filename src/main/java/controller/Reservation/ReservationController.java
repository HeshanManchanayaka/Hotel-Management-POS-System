package controller.Reservation;

import Model.Reservation;
import db.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReservationController implements ReservationService{
//    @Override
//    public boolean addReservation(Reservation reservation) throws SQLException {
//            PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Reservations VALUES ( ?, ?, ?, ?, ?)");
//
//            prs.setString(1, String.valueOf(reservation.getCustomerId()));
//            prs.setString(2, reservation.getRoomNumber());
//            prs.setDate(3, Date.valueOf(String.valueOf(reservation.getCheckInDate())));
//            prs.setDate(4, Date.valueOf(String.valueOf(reservation.getCheckOutDate())));
//            prs.setString(5, reservation.getStatus());
//
//        int res = prs.executeUpdate();
//        return res > 0;
//    }
    @Override
    public boolean addReservation(Reservation reservation){
        PreparedStatement prs = null;
        try {
            prs = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Reservations (customer_id, room_number, check_in_date, check_out_date, status) VALUES (?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            prs.setInt(1, reservation.getCustomerId());
            prs.setString(2, reservation.getRoomNumber());
            prs.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            prs.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            prs.setString(5, reservation.getStatus());

            int res = prs.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        return false;
    }

    @Override
    public boolean searchReservation(Reservation reservation) {
        return false;
    }

    @Override
    public List<Reservation> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public boolean deleteReservation(String id) {
        return false;
    }
}

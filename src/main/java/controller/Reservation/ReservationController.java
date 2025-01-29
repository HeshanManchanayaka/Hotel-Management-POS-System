package controller.Reservation;

import Model.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationController implements ReservationService{
    @Override
    public boolean addReservation(Reservation reservation) {
        return false;
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

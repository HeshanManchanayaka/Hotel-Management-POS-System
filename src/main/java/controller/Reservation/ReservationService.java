package controller.Reservation;

import Model.Reservation;
import Model.Room;

import java.sql.SQLException;
import java.util.List;

public interface ReservationService {
        boolean addReservation(Reservation reservation) ;
        boolean updateReservation(Reservation reservation);
        boolean searchReservation(Reservation reservation);
        List<Reservation> getAll() throws SQLException;
        boolean deleteReservation(String id);
}

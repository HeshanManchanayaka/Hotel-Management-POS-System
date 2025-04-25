package controller.Reservation;

import Model.Reservation;
import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservationFormController {


    public TextField cmbCusId;
    @FXML
    private JFXComboBox<String> cmbResStatus;

    @FXML
    private JFXComboBox<String> cmbRoomId;

    @FXML
    private DatePicker dateCheckIn;

    @FXML
    private DatePicker dateCheckOut;

    @FXML
    private Label lblTotal;

    @FXML
    public void initialize() {
        loadCustomerIds();
        loadReservationStatuses();
    }


    private void loadCustomerIds() {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT room_number FROM Rooms WHERE availability_status = 'Available' ");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                cmbRoomId.getItems().add(resultSet.getString("room_number"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadReservationStatuses() {
        cmbResStatus.getItems().addAll("Confirmed", "Pending", "Cancelled");
    }


    public void reservationOnAction(ActionEvent actionEvent) throws SQLException {
        int cus_id = Integer.parseInt(cmbCusId.getText());
        String room_id = cmbRoomId.getValue();
        LocalDate check_in = dateCheckIn.getValue();
        LocalDate check_out = dateCheckOut.getValue();
        String resStatus = cmbResStatus.getValue();

        long days = ChronoUnit.DAYS.between(check_in, check_out);
        System.out.println(days);
//
//        // Fetch room price from the database
//        double roomPrice = fetchRoomPrice(room_id);
//        System.out.println(roomPrice);
//        if (roomPrice <= 0) {
//            System.out.println("Invalid room price. Please check the room ID.");
//            return;
//        }
//
//        // Calculate total cost
//        double total = days * roomPrice;
        double total = days * 4000;
        System.out.println(total);
        // Create a reservation object
        Reservation res = new Reservation(cus_id, room_id, check_in, check_out, total, resStatus);
        System.out.println(res);

        boolean isAdded = new ReservationController().addReservation(res);
        if (isAdded) {
            System.out.println("Success Reservation added successfully.");
            clearForm();
        } else {
            System.out.println("Error Failed to add reservation.");
        }
        System.out.println(res);



    }
//    private double fetchRoomPrice(String roomNumber) throws SQLException {
//        String query = "SELECT price_per_night FROM Rooms WHERE room_number = ?";
//        try (Connection connection = DBConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setString(1, roomNumber);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                return resultSet.getDouble("price_per_night");
//            }
//        }
//        return 0.0;
//    }

    private void clearForm() {
        cmbCusId.setText(null);
        cmbRoomId.setValue(null);
        cmbResStatus.setValue(null);
        dateCheckIn.setValue(null);
        dateCheckOut.setValue(null);
    }
}

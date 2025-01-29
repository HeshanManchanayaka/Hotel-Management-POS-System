package controller.Reservation;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class ReservationFormController {

    @FXML
    private JFXComboBox cmbCusId;

    @FXML
    private JFXComboBox cmbResStatus;

    @FXML
    private JFXComboBox cmbRoomId;

    @FXML
    private DatePicker dateCheckIn;

    @FXML
    private DatePicker dateCheckOut;

    @FXML
    private Label lblTotal;

}

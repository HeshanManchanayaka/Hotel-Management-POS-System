package controller.Room;

import Model.Customer;
import Model.Room;
import com.jfoenix.controls.JFXTextField;
import controller.Customer.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class UpdateDeleteRoomController {

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXTextField txtCusPoint;

    @FXML
    private JFXTextField txtCusTp;

    @FXML
    private JFXTextField txtCusTp1;

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {
        boolean b = new RoomController().deleteRoom(txtCusTp.getText());
        if (b) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Room Remove success..!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) throws SQLException {
        Room room = new RoomController().searchRoom(txtCusTp.getText());
        if (room != null) {
            txtCusName.setText(room.getType());
            txtCusTp1.setText(String.valueOf(room.getPricePerNight()));
            txtCusPoint.setText(room.getAvailabilityStatus());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Customer not found !!!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) throws SQLException {
        String type =txtCusName.getText();
        double price= Double.parseDouble(txtCusTp1.getText());
        String status = txtCusPoint.getText();
        String No = txtCusTp.getText();
        Room room = new Room(No, type, price, status);

        boolean isAdded = new RoomController().updateRoom(room);

        Alert alert = new Alert(isAdded ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle("Customer Addition");
        alert.setHeaderText(null);
        alert.setContentText(isAdded ? "Room Update successfully!" : "Failed to Update Room!");
        alert.showAndWait();

        if (isAdded){
            txtCusName.clear();
            txtCusTp.clear();
            txtCusPoint.clear();
            txtCusTp1.clear();
        }
    }

}

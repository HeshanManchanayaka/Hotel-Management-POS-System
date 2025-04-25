package controller.Room;

import Model.Customer;
import Model.Room;
import com.jfoenix.controls.JFXTextField;
import controller.Customer.CustomerController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class SearchRoomController {

    @FXML
    private TableColumn colAvailabilityStates;

    @FXML
    private TableColumn colPricePerNight;

    @FXML
    private TableColumn colRoom_No;

    @FXML
    private TableColumn colRoom_Type;

    @FXML
    private TableView tblCustomer;

    @FXML
    private JFXTextField txtCusTp;

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        Room room = new RoomController().searchRoom(txtCusTp.getText());
        if(room!=null){
            colRoom_No.setCellValueFactory(new PropertyValueFactory<>("number"));
            colRoom_Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            colPricePerNight.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
            colAvailabilityStates.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));
            System.out.println("room "+room);
            tblCustomer.setItems(FXCollections.observableArrayList(room));}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Customer not found !!!");
            alert.showAndWait();
        }
    }

}

package controller.Room;

import Model.Room;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
    public TableView tblRoom;
    @FXML
    private ComboBox cmbRoomAvailabilityStatus;

    @FXML
    private ComboBox cmbRoomType;


    @FXML
    private TableColumn colRoomAvailableStatus;

    @FXML
    private TableColumn colRoomNo;

    @FXML
    private TableColumn colRoomPricePerNight;

    @FXML
    private TableColumn colRoomType;

    @FXML
    private JFXTextField txtPricePerNight;

    @FXML
    private JFXTextField txtRoomNo;

    private  void cmbRoomAvailabilityStatusSet(){
        ObservableList<String> cmbValueSet = FXCollections.observableArrayList();
        cmbValueSet.add("Available");
        cmbValueSet.add("Occupied");
        cmbRoomAvailabilityStatus.setItems(cmbValueSet);
    }
    private void setCmbRoomType(){
        ObservableList<String> cmbRoomTypes = FXCollections.observableArrayList();
        cmbRoomTypes.add("Single");
        cmbRoomTypes.add("Double");
        cmbRoomTypes.add("Suite");
        cmbRoomType.setItems(cmbRoomTypes);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbRoomAvailabilityStatusSet();
        setCmbRoomType();
    }

    public void btnRoomAddOnClickListener(ActionEvent actionEvent) throws SQLException {
        if (txtRoomNo.getText().isEmpty() ||
                cmbRoomType.getValue()==null||
                txtPricePerNight.getText().isEmpty() ||
                cmbRoomAvailabilityStatus.getValue()==null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields are required. Please fill in all fields!");
            alert.showAndWait();
        }else {
            String number = txtRoomNo.getText();
            double price = Double.parseDouble(txtPricePerNight.getText());
            String type = (String) cmbRoomType.getValue();
            String status = (String) cmbRoomAvailabilityStatus.getValue();

            Room room = new Room(number, type, price, status);
            boolean isAddedRoom = new RoomController().addRoom(room);

            Alert alert = new Alert(isAddedRoom ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
            alert.setTitle("Room Addition");
            alert.setHeaderText(null);
            alert.setContentText(isAddedRoom ? "Room added successfully!" : "Failed to add Room!");
            alert.showAndWait();

            if (isAddedRoom) {
                txtRoomNo.clear();
                txtPricePerNight.clear();
            }
        }
    }

    public void btnReloadOnClickListener(ActionEvent actionEvent) throws SQLException {
        loadTable();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateAndDeleteOnAction(ActionEvent actionEvent) {
    }

    private void loadTable() throws SQLException {
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("number"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomPricePerNight.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        colRoomAvailableStatus.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));

        ObservableList<Room> roomObaervableList = FXCollections.observableArrayList();
        List<Room> all = new RoomController().getAll();
        all.forEach(room->{
            roomObaervableList.add(room);
        });
        tblRoom.setItems(roomObaervableList);
    }
}

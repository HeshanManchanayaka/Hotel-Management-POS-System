package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    public AnchorPane loadFormContent;
    public Label lbldate;
    public Label lblTime;
    @FXML
    private AnchorPane display;
    

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Admin/Customer/CustomerManagement.fxml");

        assert resource != null;

        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/Admin/Reservation/ReservationForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnRoomManagemnetOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/Admin/Room/RoomManagementForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }
    private void setDateAndTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String format = simpleDateFormat.format(date);
        lbldate.setText(format);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e ->{
                    LocalTime now =LocalTime.now();
                    lblTime.setText(now.getHour()+":"+now.getMinute()+":"+now.getSecond());
                }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateAndTime();
    }

    public void btnDeleteCustomerManagementOnAction(ActionEvent actionEvent) {
        URL resource = this.getClass().getResource("/view/Admin/Customer/UpdateDeleteCustomer.fxml");

        assert resource != null;

        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnSearchCustomerManagementOnAction(ActionEvent actionEvent) {
        URL resource = this.getClass().getResource("/view/Admin/Customer/SearchCustomers.fxml");

        assert resource != null;

        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnSearchRoomManagementOnAction(ActionEvent actionEvent) {
            URL resource = this.getClass().getResource("/view/Admin/Room/SearchRoom.fxml");

            assert resource != null;

            Parent load = null;
            try {
                load = FXMLLoader.load(resource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            loadFormContent.getChildren().clear();
            loadFormContent.getChildren().add(load);
    }

    public void btnDeleteRoomManagementOnAction(ActionEvent actionEvent) {
        URL resource = this.getClass().getResource("/view/Admin/Room/updateRoom.fxml");

        assert resource != null;

        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }
}

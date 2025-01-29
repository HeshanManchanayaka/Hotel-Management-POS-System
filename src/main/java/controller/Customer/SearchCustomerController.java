package controller.Customer;

import Model.Customer;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class SearchCustomerController {

    @FXML
    private TableColumn colCusId;

    @FXML
    private TableColumn colCusLoyaltyPoints;

    @FXML
    private TableColumn colCusName;

    @FXML
    private TableColumn colCustomerTp;

    @FXML
    private TableView tblCustomer;

    @FXML
    private JFXTextField txtCusTp;


    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        Customer customer = new CustomerController().searchCustomer(txtCusTp.getText());
        if(customer!=null){
        colCusId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerTp.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colCusLoyaltyPoints.setCellValueFactory(new PropertyValueFactory<>("loyaltyPoints"));
        tblCustomer.setItems(FXCollections.observableArrayList(customer));}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Customer not found !!!");
            alert.showAndWait();
        }
    }


}

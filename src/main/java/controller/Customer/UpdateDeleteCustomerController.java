package controller.Customer;

import Model.Customer;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class UpdateDeleteCustomerController {

    @FXML
    private JFXTextField txtCusId;

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXTextField txtCusPoint;

    @FXML
    private JFXTextField txtCusTp;

    @FXML
    private JFXTextField txtCusTp1;


    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) throws SQLException {
        boolean b = new CustomerController().deleteCustomer(txtCusTp.getText());
        if (b) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Customer delete success..!");
            alert.showAndWait();
        }

    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) throws SQLException {
        Customer customer = new CustomerController().searchCustomer(txtCusTp.getText());
        if (customer != null) {
            txtCusName.setText(customer.getName());
            txtCusTp1.setText(customer.getContactNo());
            txtCusPoint.setText(String.valueOf(customer.getLoyaltyPoints()));
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
        Customer customer = new CustomerController().searchCustomer(txtCusTp.getText());
        if (customer != null) {
            txtCusName.setText(customer.getName());
            txtCusTp1.setText(customer.getContactNo());
            txtCusPoint.setText(String.valueOf(customer.getLoyaltyPoints()));


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Customer not found !!!");
            alert.showAndWait();
        }
    }

}

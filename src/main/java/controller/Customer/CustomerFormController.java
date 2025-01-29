package controller.Customer;

import Model.Customer;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {

    public TableColumn colCusId;

    public TableColumn colCusLoyaltyPoints;

    public TableColumn colCustomerTp;

    public TableColumn colCusName;

    public TableView tblCustomer;

    @FXML
    private JFXTextField txtCusId;

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXTextField txtCusPoint;

    @FXML
    private JFXTextField txtCusTp;

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) throws SQLException {
        if(txtCusId.getText().isEmpty() || txtCusName.getText().isEmpty() || txtCusTp.getText().isEmpty() || txtCusPoint.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields are required. Please fill in all fields!");
            alert.showAndWait();
        }
        int id = Integer.parseInt(txtCusId.getText());
        String name = txtCusName.getText();
        String tp = txtCusTp.getText();
        int points = Integer.parseInt(txtCusPoint.getText());
        Customer customer = new Customer(id,name,tp,points);

        boolean isAdded = new CustomerController().addCustomer(customer);

        Alert alert = new Alert(isAdded ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle("Customer Addition");
        alert.setHeaderText(null);
        alert.setContentText(isAdded ? "Customer added successfully!" : "Failed to add customer!");
        alert.showAndWait();

        if (isAdded){
            txtCusId.clear();
            txtCusName.clear();
            txtCusTp.clear();
            txtCusPoint.clear();
        }

    }

    @FXML
    void btnReloadCustomerOnAction(ActionEvent event) {
        loadTabel();
    }

    private void loadTabel(){
        colCusId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerTp.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colCusLoyaltyPoints.setCellValueFactory(new PropertyValueFactory<>("loyaltyPoints"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        List<Customer> all = new CustomerController().getAll();
        all.forEach(customer->{
           customerObservableList.add(customer);
        });
        tblCustomer.setItems(customerObservableList);
    }
}

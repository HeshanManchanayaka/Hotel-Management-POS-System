package controller.Customer;


import Model.Customer;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerService {

    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("Insert into Customers Values(?,?,?,?)");
        prs.setString(1, String.valueOf(customer.getId()));
        prs.setString(2,customer.getName());
        prs.setString(3,customer.getContactNo());
        prs.setString(4, String.valueOf(customer.getLoyaltyPoints()));

        int res = prs.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer searchCustomer(String contact) throws SQLException {
        PreparedStatement prs = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customers WHERE contact_details = ?");
        prs.setString(1, contact);
        ResultSet rst = prs.executeQuery();
        if(rst.next()){
            Customer customer=new Customer(rst.getInt("customer_id"), rst.getString("name"), rst.getString("contact_details"), rst.getInt("loyalty_points"));
            return customer;
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(String contact) throws SQLException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Customers WHERE contact_details = '"+contact+"' ")>0;
    }

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                customerArrayList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerArrayList;
    }

}

package controller.Customer;


import Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer);
    Customer searchCustomer(String contact) throws SQLException;
    List<Customer> getAll();
    boolean deleteCustomer(String contact) throws SQLException;
}

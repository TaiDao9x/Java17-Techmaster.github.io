package homework_02.handle;

import homework_02.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private static List<Customer> customers = new ArrayList<>();

    public List<Customer> allCustomers() {
        return customers;
    }


    public void addNewCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public boolean checkIdExist(int id) {
        for (Customer cus : customers) {
            if (cus.getId() == id) return true;
        }
        return false;
    }

    public Customer getCustomer(int customerId) {
        for (Customer cus : customers) {
            if (cus.getId() == customerId) return cus;
        }
        return null;
    }
}

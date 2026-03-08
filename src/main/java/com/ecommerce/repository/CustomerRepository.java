package com.ecommerce.repository;

import com.ecommerce.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private static CustomerRepository instance;


    private List<Customer> customers;


    private CustomerRepository() {
        customers = new ArrayList<>();
    }


    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }


    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}

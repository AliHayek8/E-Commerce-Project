package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;


    public CustomerService() {
        this.customerRepository = CustomerRepository.getInstance();
    }


    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}

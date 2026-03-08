package com.ecommerce.controller;

import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;


    public CustomerController() {
        this.customerService = new CustomerService();
    }


    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
        System.out.println("Customer added: " + customer.getName() );
    }


    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}

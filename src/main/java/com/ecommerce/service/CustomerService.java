package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer customer){

        Customer existing = customerRepository.findById(id).orElse(null);

        if(existing != null){
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            return customerRepository.save(existing);
        }

        return null;
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
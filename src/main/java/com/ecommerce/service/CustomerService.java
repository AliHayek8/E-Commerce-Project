package com.ecommerce.service;

import com.ecommerce.dto.customer.CustomerRequestDTO;
import com.ecommerce.dto.customer.CustomerResponseDTO;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    // CREATE
    public CustomerResponseDTO addCustomer(CustomerRequestDTO dto){

        Customer customer = mapToEntity(dto);

        Customer savedCustomer = customerRepository.save(customer);

        return mapToDTO(savedCustomer);
    }


    // READ ALL
    public List<CustomerResponseDTO> getAllCustomers(){

        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    // READ BY ID
    public CustomerResponseDTO getCustomerById(Long id){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return mapToDTO(customer);
    }


    // UPDATE
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto){

        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        existingCustomer.setName(dto.getName());
        existingCustomer.setEmail(dto.getEmail());

        Customer updatedCustomer = customerRepository.save(existingCustomer);

        return mapToDTO(updatedCustomer);
    }


    // DELETE
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }


    // =============================
    // Mapping Methods
    // =============================

    private Customer mapToEntity(CustomerRequestDTO dto){

        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());

        return customer;
    }


    private CustomerResponseDTO mapToDTO(Customer customer){

        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());

        return dto;
    }

}
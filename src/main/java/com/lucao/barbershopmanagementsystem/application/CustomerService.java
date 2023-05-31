package com.lucao.barbershopmanagementsystem.application;

import com.lucao.barbershopmanagementsystem.domain.Customer;
import com.lucao.barbershopmanagementsystem.infrastructure.persistence.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return  customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }
}

package com.lucao.barbershopmanagementsystem.application.customer;


import com.lucao.barbershopmanagementsystem.domain.customer.Customer;
import com.lucao.barbershopmanagementsystem.infrastructure.persistence.customer.CustomerRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void getAllCustomer_ReturnsListOfCustomers(){

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Biribinha","biribinha@email.org","4002-8002"));
        customers.add(new Customer("Rogerin","TortaoPraEsquerda@email.org","0800-777-7000"));

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(2,result.size());
        assertEquals(customers,result);
        verify(customerRepository,times(1)).findAll();
        
    }

    @Test
    void getCustomerById_ExistingCustomerId_ReturnsCustomer(){

        long customerId = 1l;
        Customer customer = new Customer("Rogerin","TortaoPraEsquerda@email.org","0800-777-7000");

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerById(customerId);

        assertEquals(Optional.of(customer),result);
        verify(customerRepository,times(1)).findById(customerId);

    }

    @Test
    void createCustomer_ValidCustomer_ReturnCreatedCustomer(){
        
    }




}

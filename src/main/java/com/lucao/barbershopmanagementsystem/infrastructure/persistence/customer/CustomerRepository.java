package com.lucao.barbershopmanagementsystem.infrastructure.persistence.customer;

import com.lucao.barbershopmanagementsystem.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

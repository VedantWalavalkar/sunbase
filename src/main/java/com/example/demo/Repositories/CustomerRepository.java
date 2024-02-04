package com.example.demo.Repositories;

import com.example.demo.Modals.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByFirstname(String firstname);

    public Customer findByEmail(String email);
}

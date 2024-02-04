package com.example.demo.Services;

import com.example.demo.DTO.RequestCustomer;
import com.example.demo.Modals.Customer;
import com.example.demo.Repositories.CustomerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(RequestCustomer customer){
        System.out.println("creating customer");
        Customer curr = new Customer();
        curr.setStreet(customer.getStreet());
        curr.setPhone(customer.getPhone());
        curr.setState(customer.getState());
        curr.setCity(customer.getCity());
        curr.setAddress(customer.getAddress());
        curr.setEmail(customer.getEmail());
        curr.setFirstname(customer.getFirstname());
        curr.setLastname(customer.getLastname());

        Customer savedCustomer = customerRepository.save(curr);
        return savedCustomer;
    }

    public Customer updateCustomer(RequestCustomer customer) throws Exception {
        Customer curr = customerRepository.findByEmail(customer.getEmail());
        if(curr == null) throw new Exception("Customer Not Found");
        curr.setStreet(customer.getStreet());
        curr.setPhone(customer.getPhone());
        curr.setState(customer.getState());
        curr.setCity(customer.getCity());
        curr.setAddress(customer.getAddress());
        curr.setEmail(customer.getEmail());
        curr.setFirstname(customer.getFirstname());
        curr.setLastname(customer.getLastname());
        Customer savedCustomer = customerRepository.save(curr);
        return savedCustomer;
    }


    public List<Customer> getListOfCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    public Customer getCustomerById(int id) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) throw new Exception("Customer Not Found");
        return optionalCustomer.get();
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}

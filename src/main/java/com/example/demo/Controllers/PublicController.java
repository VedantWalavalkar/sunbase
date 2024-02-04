package com.example.demo.Controllers;

import com.example.demo.DTO.RequestCustomer;
import com.example.demo.Modals.Customer;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to public place";
    }

    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody RequestCustomer requestCustomer) {
        Customer savedCustomer = customerService.createCustomer(requestCustomer);
        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomer(@RequestBody RequestCustomer customer) throws Exception {
        Customer savedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity getListOfCustomer(){
        List<Customer> customerList = customerService.getListOfCustomer();
        return new ResponseEntity(customerList, HttpStatus.FOUND);
    }

    @GetMapping("/getCustomerById")
    public ResponseEntity getCustomerById(@RequestParam int id) throws Exception {
        try{
            Customer customer = customerService.getCustomerById(id);
            return new ResponseEntity(customer,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteCustomer")
    public ResponseEntity deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
        return new ResponseEntity("Customer Deleted", HttpStatus.OK);
    }
}

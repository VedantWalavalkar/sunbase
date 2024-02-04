package com.example.demo.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RequestCustomer {
    String firstname;

    String lastname;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phone;
}

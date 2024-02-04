package com.example.demo.Modals;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstname;

    String lastname;

    String street;

    String address;

    String city;

    String state;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String phone;
}

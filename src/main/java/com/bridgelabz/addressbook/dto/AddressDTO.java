package com.bridgelabz.addressbook.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipcode;
}
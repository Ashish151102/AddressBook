package com.bridgelabz.addressbook.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private String name;
    private String phone;
    private String email;
}
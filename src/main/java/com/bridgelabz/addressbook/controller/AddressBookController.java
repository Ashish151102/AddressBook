package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping("/add/{name}")
    public ResponseEntity<String> addAddress(@PathVariable String name) {
        return ResponseEntity.ok(service.addAddress(name));
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllAddresses() {
        return ResponseEntity.ok(service.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok(service.getAddressById(id));
    }

    @PutMapping("/update/{id}/{newName}")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @PathVariable String newName) {
        return ResponseEntity.ok(service.updateAddress(id, newName));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteAddress(id));
    }
}
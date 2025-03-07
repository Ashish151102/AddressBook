package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend to access this API
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(service.addAddress(addressDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(service.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable long id) {
        Optional<Address> address = service.getAddressById(id);
        return address.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable long id, @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(service.updateAddress(id, addressDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {
        return ResponseEntity.ok(service.deleteAddress(id));
    }
}
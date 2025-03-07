package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressRepository repository;

    private Address convertToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setName(addressDTO.getName());
        address.setPhone(addressDTO.getPhone());
        address.setEmail(addressDTO.getEmail());
        address.setAddress(addressDTO.getAddress());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZipcode(addressDTO.getZipcode());
        return address;
    }

    public Map<String, Object> addAddress(AddressDTO addressDTO) {
        Address savedAddress = repository.save(convertToEntity(addressDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Contact added successfully");
        response.put("contact", savedAddress);

        return response; // ✅ Return a JSON object instead of just a string
    }


    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Optional<Address> getAddressById(long id) {
        return repository.findById(id);
    }

    public String updateAddress(long id, AddressDTO addressDTO) {
        Optional<Address> existingAddress = repository.findById(id);
        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();
            address.setName(addressDTO.getName());
            address.setPhone(addressDTO.getPhone());
            address.setEmail(addressDTO.getEmail());
            address.setAddress(addressDTO.getAddress());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setZipcode(addressDTO.getZipcode());
            repository.save(address);
            return "Updated Address: " + address;
        }
        return "Address not found for update at ID: " + id;
    }

    public String deleteAddress(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted Address with ID: " + id;
        }
        return "Address not found for deletion at ID: " + id;
    }
}
package com.bridgelabz.addressbook.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.Address;

@Service
public class AddressBookService {

    private final List<Address> addressBook = new ArrayList<>();
    private long idCounter = 1; // Simulating auto-increment ID

    public String addAddress(AddressDTO addressDTO) {
        Address address = new Address(idCounter++, addressDTO.getName(), addressDTO.getPhone(), addressDTO.getEmail());
        addressBook.add(address);
        return "Stored Address: " + address.toString();
    }

    public String getAllAddresses() {
        if (addressBook.isEmpty()) {
            return "No addresses found";
        }
        return "All Addresses: " + addressBook.toString();
    }

    public String getAddressById(long id) {
        for (Address address : addressBook) {
            if (address.getId() == id) {
                return "Found Address: " + address;
            }
        }
        return "Address not found for ID: " + id;
    }

    public String updateAddress(long id, AddressDTO addressDTO) {
        for (Address address : addressBook) {
            if (address.getId() == id) {
                address.setName(addressDTO.getName());
                address.setPhone(addressDTO.getPhone());
                address.setEmail(addressDTO.getEmail());
                return "Updated Address: " + address;
            }
        }
        return "Address not found for update at ID: " + id;
    }

    public String deleteAddress(long id) {
        for (Address address : addressBook) {
            if (address.getId() == id) {
                addressBook.remove(address);
                return "Deleted Address: " + address;
            }
        }
        return "Address not found for deletion at ID: " + id;
    }
}
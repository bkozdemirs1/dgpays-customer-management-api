package com.example.demo.controller;

import com.example.demo.CustomerResponseDto.CustomerResponseDto;
import com.example.demo.Customers.Customers;
import com.example.demo.Branch.Branch;
import com.example.demo.CustomerManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    private final CustomerManager manager ;

    public CustomerController(CustomerManager manager) {

        this.manager = manager;
    }

    //Add Customer
    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customers incomingCustomer) {
        manager.addCustomer(incomingCustomer);
        return ResponseEntity.ok(incomingCustomer.getCustomerName() + " added successfully!");
    }

    //Delete Customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        manager.deleteCustomerById(id);
        return ResponseEntity.ok(id + "The Customer has been deleted by ID.");
    }

    // Show Customer
    @GetMapping("/list")
    public ResponseEntity<List<CustomerResponseDto>> listCustomers() {
        List<CustomerResponseDto> list = manager.getAllCustomers();
        return ResponseEntity.ok(list);
    }

    // Update Customer
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateCustomers(@RequestParam String newname, @PathVariable String id, @RequestParam String newlastname , @RequestBody String newdepartmentId) {
        manager.updateCustomer(id, newname, newlastname,newdepartmentId);
        return ResponseEntity.ok("The Customer has been updated by ID!");
    }


}

package com.example.bankmanagementsystem.CustomersController;

import com.example.bankmanagementsystem.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank-management-system")
public class CustomersController {
    ArrayList<Customers> customers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public String addCustomers(@RequestBody Customers customer) {
        customers.add(customer);
        return customer.toString() + " added successfully";
    }
    @PutMapping("/update/{index}")
    public String updateCustomers(@PathVariable int index ,@RequestBody Customers customer) {
        customers.set(index,  customer);
        return customer.toString() + " updated successfully";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteCustomers(@PathVariable int index) {
        customers.remove(index);
        return index + " deleted customers successfully";
    }

    // Deposit money to a customer
    @PutMapping("/deposit/{id}/{amount}")
    public String depositMoney(@PathVariable int id, @PathVariable double amount) {
        for (Customers customer : customers) {
            if (customer.getId() == id) {
                customer.setBalance(customer.getBalance() + amount);
                return "Deposit successfully"; } }
        return "Customer not found";
    }
    // Withdraw money from a customer
    @PutMapping("/withdraw/{id}/{amount}")
    public String withdrawMoney(@PathVariable int id, @PathVariable double amount) {
        for (Customers customer : customers) {
            if (customer.getId() == id) {
                if (customer.getBalance() >= amount) {
                    customer.setBalance(customer.getBalance() - amount);
                    return "Withdrawal successfully ";
                } else {
                    return "Insufficient balance";
                }
            }
        }
        return "Customer not found";
    }

}

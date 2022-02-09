package com.example.springrestcrmapp.controller;

import com.example.springrestcrmapp.Service.CustomerService;
import com.example.springrestcrmapp.entity.Customer;
import com.example.springrestcrmapp.exception_handler.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null)
            throw new CustomerNotFoundException("Customer id not found: "+customerId);
        return customer;
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer id not found: "+customerId);
        }

        customerService.deleteCustomer(customerId);
    }

/*
    @PostMapping("/customer")
    public void saveCustomer(@RequestBody List<Customer> customer){
        customerService.saveCustomers(customer);
    }
*/

/*
    @PutMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomers(customer);
    }
*/

}

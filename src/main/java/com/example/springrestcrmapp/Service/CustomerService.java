package com.example.springrestcrmapp.Service;

import com.example.springrestcrmapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    void saveCustomers(List<Customer> customer);
    void saveCustomers(Customer customer);
    Customer getCustomer(Integer id);
    void deleteCustomer(Integer id);

}

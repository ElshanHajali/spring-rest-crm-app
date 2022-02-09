package com.example.springrestcrmapp.Service;

import com.example.springrestcrmapp.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void saveCustomer(){
        List<Customer> customers = new ArrayList<>();

        customers.add(Customer.builder()
                .firstName("Rustam")
                .lastName("Aliyev")
                .email("rustam@mail.ru")
                .build());
        customers.add(Customer.builder()
                .firstName("Ali")
                .lastName("Hucum")
                .email("ali@gmail.com")
                .build());

        customerService.saveCustomers(customers);
    }

}
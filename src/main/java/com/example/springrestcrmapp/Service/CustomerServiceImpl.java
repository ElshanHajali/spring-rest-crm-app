package com.example.springrestcrmapp.Service;

import com.example.springrestcrmapp.entity.Customer;
import com.example.springrestcrmapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    @Transactional
    @Modifying
    public void saveCustomers(List<Customer> customer) {
        customerRepository.saveAll(customer);
    }

    @Override
    public void saveCustomers(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Integer id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomerById(id);
    }

}

package com.example.springrestcrmapp.repository;

import com.example.springrestcrmapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(
            value = "Select * from Customer",
            nativeQuery = true
    )
    List<Customer> getCustomers();

    @Query(
            value="Select * from Customer c where c.id=:theId",
            nativeQuery = true
    )
    Customer getCustomer(Integer theId);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Customer c WHERE c.id=:theId",
            nativeQuery = true
    )
    void deleteCustomerById(Integer theId);

}

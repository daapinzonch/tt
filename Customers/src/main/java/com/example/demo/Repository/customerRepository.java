package com.example.demo.Repository;

import com.example.demo.Entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface customerRepository extends JpaRepository<customer, Integer> {
    @Query("select COUNT(customer_id) from customer where customer_id like :id")
    long countByCustomerId(@Param("id") String id);

    List<customer> findAll();
}

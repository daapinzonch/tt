package com.example.demo.Services;

import com.example.demo.Entity.customer;
import com.example.demo.Repository.customerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class customerService {
    @Autowired
    private customerRepository cusRepo;

    public boolean createCustomer(customer cus){
        if(cusRepo.countByCustomerId(cus.getCustomerId()) == 0) {
            cusRepo.save(cus);
            return true;
        }else{
            return false;
        }
    }

    public List<customer> getAllCustomers(){
        return cusRepo.findAll();
    }
}

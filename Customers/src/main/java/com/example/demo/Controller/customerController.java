package com.example.demo.Controller;

import com.example.demo.Entity.customer;
import com.example.demo.Services.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apicus")
public class customerController {
    @Autowired
    private final customerService cusSer;

    @GetMapping
    public String msg(){
        return "ALV";
    }

    @GetMapping("/customers")
    public ResponseEntity<List<customer>> allStores(){
        return ResponseEntity.ok(cusSer.getAllCustomers());
    }

    @PostMapping(path ="/create", consumes = "application/json")
    public ResponseEntity<Long> createUser(@RequestBody customer cus) {
        try{
            if(cusSer.createCustomer(cus)) {
                return new ResponseEntity<>((long) 1, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>((long) 0, HttpStatus.IM_USED);
            }
        }catch (Exception e){
            return new ResponseEntity<>((long) -1, HttpStatus.FORBIDDEN);
        }
    }

}

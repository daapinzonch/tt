package com.example.demo.Controller;

import com.example.demo.Entity.typePet;
import com.example.demo.Services.typePetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apitp")
public class typePetController {
    @Autowired
    private final typePetService tpSer;

    @GetMapping
    public String msg(){
        return "ALV";
    }

    @GetMapping("/typepet")
    public ResponseEntity<List<typePet>> allTypePet(){
        return ResponseEntity.ok(tpSer.getAllCustomers());
    }

    @PostMapping(path ="/create", consumes = "application/json")
    public ResponseEntity<Long> createTypePet(@RequestBody typePet tp) {
        try{
            if(tpSer.createTypePet(tp)) {
                return new ResponseEntity<>((long) 1, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>((long) 0, HttpStatus.IM_USED);
            }
        }catch (Exception e){
            return new ResponseEntity<>((long) -1, HttpStatus.FORBIDDEN);
        }
    }
}

package com.example.demo.Services;

import com.example.demo.Entity.typePet;
import com.example.demo.Repository.typePetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class typePetService {
    @Autowired
    private typePetRepository tpRepo;

    public boolean createTypePet(typePet tp){
        if(tpRepo.countByID(tp.getID()) == 0) {
            tpRepo.save(tp);
            return true;
        }else{
            return false;
        }
    }

    public List<typePet> getAllCustomers(){
        return tpRepo.findAll();
    }
}

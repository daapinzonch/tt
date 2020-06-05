package com.example.demo.Repository;

import com.example.demo.Entity.typePet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface typePetRepository extends JpaRepository<typePet, Integer> {
    long countByID(int id);

    List<typePet> findAll();
}

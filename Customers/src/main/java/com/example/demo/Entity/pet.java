package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Pet")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
@NoArgsConstructor
@AllArgsConstructor
public class pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NotBlank
    private String Name;

    @NotBlank
    //tabla de normalizacion (petType) - 5 animales
    private String Type;

    @NotNull
    private int Age;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonBackReference(value="cus-pet")
    private customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonBackReference(value="cus-tp")
    private typePet typePet;
}

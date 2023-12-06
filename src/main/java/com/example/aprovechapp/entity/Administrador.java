package com.example.aprovechapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Administrador {
    @Id
    @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    private String nombre;
    private String password;
    private String email;
    private ArrayList<Verduleria> verdulerias;


}

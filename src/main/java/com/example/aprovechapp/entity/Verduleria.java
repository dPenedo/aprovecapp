package com.example.aprovechapp.entity;

import com.example.aprovechapp.enums.TipoDeVerduleria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.awt.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Verduleria {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
            private Long id;
    private String nombre;
    private TipoDeVerduleria tipoDeVerduleria;
    private Point direccion;
    private ArrayList<Horario> horarios;

}

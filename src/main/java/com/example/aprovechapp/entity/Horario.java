package com.example.aprovechapp.entity;

import com.example.aprovechapp.enums.DiaSemana;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Horario {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private UUID id;
  private DiaSemana diaSemana;
  private String horaDeApertura;
  private String horaDeCierre;

  // Una verduleria puede tener muchos horarios
  @ManyToOne
  @JoinColumn(name = "verduleria_id")
  private Verduleria verduleria;

}

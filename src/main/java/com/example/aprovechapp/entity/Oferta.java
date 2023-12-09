package com.example.aprovechapp.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.example.aprovechapp.enums.TipoDeProducto;
import com.example.aprovechapp.enums.TipoDeVerduleria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Oferta {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private Long id;

  // Una verduleria puede tener muchas ofertas
  @ManyToOne
  @JoinColumn(name = "verduleria_id")
  private Verduleria verduleria;
  private String descripcion;
  private TipoDeProducto tipoDeProducto;
  private TipoDeVerduleria TipoDeVerduleria;
  private LocalDate limiteDisponibilidad;
  private int precio;

}

package com.example.aprovechapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Administrador {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private UUID id;
  private String nombre;
  private String password;
  private String email;

  // Un administrador puede tener varias verdulerias
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "administrador")
  private List<Verduleria> verdulerias;

  public List<GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));
  }

}

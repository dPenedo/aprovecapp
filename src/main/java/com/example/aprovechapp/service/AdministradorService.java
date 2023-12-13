package com.example.aprovechapp.service;

import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.exceptions.MyException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdministradorService{
  void registrarAdministrador(String nombre, String email, String password, String password2) throws  MyException;

  Administrador modificarAdministrador(Administrador administradorNuevo, Long uuid);

  Object registrarVerduleria(Verduleria verduleria);

  Verduleria modificarVerduleria(Verduleria verduleriaNueva, Long uuid);

  Oferta registrarOferta(Oferta oferta);

  Oferta modificarOferta(Oferta ofertaNueva, Long uuid);

  void validar(String nombre, String email, String password, String password2) throws MyException;

}

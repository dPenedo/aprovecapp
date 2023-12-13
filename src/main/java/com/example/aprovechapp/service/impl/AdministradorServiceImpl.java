package com.example.aprovechapp.service.impl;

import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.exceptions.MyException;
import com.example.aprovechapp.repository.AdministradorRepository;
import com.example.aprovechapp.repository.HorarioRepository;
import com.example.aprovechapp.repository.OfertaRepository;
import com.example.aprovechapp.repository.VerduleriaRepository;
import com.example.aprovechapp.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class AdministradorServiceImpl implements AdministradorService, UserDetailsService {
  @Autowired
  AdministradorRepository administradorRepository;
  @Autowired
  HorarioRepository horarioRepository;
  @Autowired
  OfertaRepository ofertaRepository;
  @Autowired
  VerduleriaRepository verduleriaRepository;

  @Override
  public void registrarAdministrador(String nombre, String email, String password, String password2) throws MyException {
      validar(nombre, email, password, password2);
      Administrador administrador = new Administrador();
      administrador.setNombre(nombre);
      administrador.setEmail(email);
      administrador.setPassword(new BCryptPasswordEncoder().encode(password));
    administradorRepository.save(administrador);
    }

  @Override
  public Administrador modificarAdministrador(Administrador administradorNuevo, Long uuid) {
    return null;
  }

  @Override
  public Verduleria registrarVerduleria(Verduleria verduleria) {
    return verduleriaRepository.save(verduleria);
  }

  @Override
  public Verduleria modificarVerduleria(Verduleria verduleriaNueva, Long uuid) {
    return null;
  }

  @Override
  public Oferta registrarOferta(Oferta oferta) {
    return null;
  }

  @Override
  public Oferta modificarOferta(Oferta ofertaNueva, Long uuid) {
    return null;
  }

  @Override
  public void validar(String nombre, String email, String password, String password2) throws  MyException{

      if (nombre.isEmpty() || nombre == null) {
        throw new MyException("el nombre no puede ser nulo o estar vacío");
      }
      if (email.isEmpty() || email == null) {
        throw new MyException("el email no puede ser nulo o estar vacio");
      }
      if (password.isEmpty() || password == null || password.length() <= 5) {
        throw new MyException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
      }

      if (!password.equals(password2)) {
        throw new MyException("Las contraseñas ingresadas deben ser iguales");
      }

    }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Administrador administrador = administradorRepository.findByEmail(email);

    if (administrador == null) {
      throw new UsernameNotFoundException("Usuario no registrado con el email: " + email);
    }

    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));

      return new User(administrador.getEmail(), administrador.getPassword(), authorities);

  }


}

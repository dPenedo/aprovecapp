package com.example.aprovechapp.service;


import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;

public interface AdministradorService {
    Administrador registrarAdministrador (Administrador administrador);
    Administrador modificarAdministrador (Administrador administradorNuevo, Long uuid);

    Object registrarVerduleria (Verduleria verduleria);
    Verduleria modificarVerduleria (Verduleria verduleriaNueva, Long uuid);

    Oferta registrarOferta(Oferta oferta);
    Oferta modificarOferta(Oferta ofertaNueva, Long uuid);




}
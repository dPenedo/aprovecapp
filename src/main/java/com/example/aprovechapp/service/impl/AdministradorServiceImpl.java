package com.example.aprovechapp.service.impl;

import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.repository.AdministradorRepository;
import com.example.aprovechapp.repository.HorarioRepository;
import com.example.aprovechapp.repository.OfertaRepository;
import com.example.aprovechapp.repository.VerduleriaRepository;
import com.example.aprovechapp.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    AdministradorRepository administradorRepository;
    @Autowired
    HorarioRepository horarioRepository;
    @Autowired
    OfertaRepository ofertaRepository;
    @Autowired
    VerduleriaRepository verduleriaRepository;

    @Override
    public Administrador registrarAdministrador(Administrador administrador) {
        return null;
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
}
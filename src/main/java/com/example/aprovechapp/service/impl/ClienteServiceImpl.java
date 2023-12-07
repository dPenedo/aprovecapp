package com.example.aprovechapp.service.impl;

import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.enums.TipoDeVerduleria;
import com.example.aprovechapp.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class ClienteServiceImpl implements ClienteService {
    @Override
    public ArrayList<Oferta> obtenerOfertas() {
        return null;
    }

    @Override
    public Optional<Verduleria> obtenerVerduleria(Long uuid) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Verduleria> obtenerVerduleriaPorTipo(TipoDeVerduleria tipoDeVerduleria) {
        return null;
    }
}
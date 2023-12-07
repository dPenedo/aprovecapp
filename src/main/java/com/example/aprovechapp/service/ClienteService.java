package com.example.aprovechapp.service;

import com.example.aprovechapp.entity.Oferta;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.enums.TipoDeVerduleria;

import java.util.ArrayList;
import java.util.Optional;

public interface ClienteService {
    ArrayList<Oferta> obtenerOfertas();
    Optional<Verduleria> obtenerVerduleria(Long uuid);

    ArrayList<Verduleria> obtenerVerduleriaPorTipo(TipoDeVerduleria tipoDeVerduleria);
}
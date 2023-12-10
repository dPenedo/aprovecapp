package com.example.aprovechapp.repository;

import com.example.aprovechapp.entity.Oferta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends CrudRepository <Oferta, Long> {
}

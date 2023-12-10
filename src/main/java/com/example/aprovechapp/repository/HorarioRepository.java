package com.example.aprovechapp.repository;

import com.example.aprovechapp.entity.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario,Long> {
}

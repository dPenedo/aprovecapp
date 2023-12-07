package com.example.aprovechapp.repository;

import com.example.aprovechapp.entity.Verduleria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerduleriaRepository extends CrudRepository <Verduleria, Long> {
}

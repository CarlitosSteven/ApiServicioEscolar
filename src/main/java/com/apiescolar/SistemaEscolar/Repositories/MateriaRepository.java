package com.apiescolar.SistemaEscolar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{

}

package com.apiescolar.SistemaEscolar.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{

  List<Materia> findByProfesorId(int profesorId);

  Optional<Materia> findByIdAndProfesorId(int id, int profesorId);

  long countById(int materiaId);

}

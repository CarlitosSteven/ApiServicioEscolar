package com.apiescolar.SistemaEscolar.Repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.Asistencia;
import com.apiescolar.SistemaEscolar.Entities.AsistenciaPK;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, AsistenciaPK>{

  @Override
  Optional<Asistencia>findById(AsistenciaPK id);

  long countByAlumnoIdAndMateriaId(int alumnoId, int materiaId);
}

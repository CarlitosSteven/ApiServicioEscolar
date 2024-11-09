package com.apiescolar.SistemaEscolar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.AlumnoMateria;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateriaPK;

@Repository
public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, AlumnoMateriaPK>{
}

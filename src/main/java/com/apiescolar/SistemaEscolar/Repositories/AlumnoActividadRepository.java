package com.apiescolar.SistemaEscolar.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.AlumnoActividad;
import com.apiescolar.SistemaEscolar.Entities.AlumnoActividadPK;

@Repository
public interface AlumnoActividadRepository extends JpaRepository<AlumnoActividad, AlumnoActividadPK>{


  List<AlumnoActividad> findByAlumnoId(int alumnoId);
}
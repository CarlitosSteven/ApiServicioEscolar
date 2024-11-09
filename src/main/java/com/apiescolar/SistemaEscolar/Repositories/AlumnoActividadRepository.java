package com.apiescolar.SistemaEscolar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.AlumnoActividad;
import com.apiescolar.SistemaEscolar.Entities.AlumnoActividadesPK;

@Repository
public interface AlumnoActividadRepository extends JpaRepository<AlumnoActividad, AlumnoActividadesPK>{

}

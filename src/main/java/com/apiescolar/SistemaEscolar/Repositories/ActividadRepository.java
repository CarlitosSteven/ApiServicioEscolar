package com.apiescolar.SistemaEscolar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiescolar.SistemaEscolar.Entities.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer>{

}

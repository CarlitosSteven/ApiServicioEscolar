package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;

@Service
public class AlumnoService {

  @Autowired
  AlumnoRepository alumnoRepository;

  public Alumno agregarAlumno(Alumno alumno){
    return alumnoRepository.save(alumno);
  }

  public List<Alumno> obtenerAlumnos(){
    return alumnoRepository.findAll();
  }

  public Optional<Alumno> obtenerAlumnoId(Integer id){
    return alumnoRepository.findById(id);
  }

  public void eliminarAlumno(Integer id){
    alumnoRepository.deleteById(id);
  }
  
}

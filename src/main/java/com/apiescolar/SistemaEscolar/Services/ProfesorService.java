package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Repositories.ProfesorRepository;

@Service
public class ProfesorService {

  @Autowired
  private ProfesorRepository profesorRepository;

  public Profesor agregarProfesor(Profesor profesor){
    return this.profesorRepository.save(profesor);
  }

  public List<Profesor> obtenerProfesores(){
    return this.profesorRepository.findAll();
  }

  public Optional<Profesor> obtenerProfesorId(Integer id){
    return this.profesorRepository.findById(id);
  }
  
  public void eliminarProfesor(Integer id){
    this.profesorRepository.deleteById(id);
  }
}

package com.apiescolar.SistemaEscolar.Services;

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
  
}

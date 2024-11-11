package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;

@Service
public class MateriaService {

  @Autowired
  private MateriaRepository materiaRepository;

  public Materia agregarMateria(Materia materia){

    return materiaRepository.save(materia);
  }

  public List<Materia> obtenerMaterias(){
    return materiaRepository.findAll();
  }

  public Optional<Materia> obtenerMateriaId(Integer id){
    return materiaRepository.findById(id);
  }

  public void eliminarMateria(Integer id){
    materiaRepository.deleteById(id);
  }
  
}

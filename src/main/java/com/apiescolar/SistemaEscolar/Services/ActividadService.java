package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Actividad;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Repositories.ActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;

@Service
public class ActividadService {

  @Autowired
  private ActividadRepository actividadRepository;

  @Autowired
  private MateriaRepository materiaRepository;

  public Actividad agregarActividad(Actividad actividad){

    Materia materia = materiaRepository.findById(actividad.getMateria().getId()).orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        
        // Asigna la materia a la actividad
    actividad.setMateria(materia);
        
        // Guarda la nueva actividad
    return actividadRepository.save(actividad);
  }

  public List<Actividad> obtenerActividades(){
    return actividadRepository.findAll();
  }

  public Optional<Actividad> obtenerActividadId(Integer id){
    return actividadRepository.findById(id);
  }

  public void eliminarActividad(Integer id){
    actividadRepository.deleteById(id);
  }
  
  
}

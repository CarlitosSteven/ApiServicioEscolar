package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.DTOS.ActividadDTO;
import com.apiescolar.SistemaEscolar.DTOS.MateriaDTO;
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

  public ActividadDTO agregarActividad(ActividadDTO actividadDTO){

    Materia materia = materiaRepository.findById(actividadDTO.getMateria().getId())
            .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

    // Crear una nueva actividad a partir del DTO
    Actividad actividad = new Actividad();
    actividad.setNombre(actividadDTO.getNombre());
    actividad.setDescripcion(actividadDTO.getDescripcion());
    actividad.setMateria(materia);

    // Guardar la nueva actividad en la base de datos
    Actividad savedActividad = actividadRepository.save(actividad);
        
    return new ActividadDTO(
        savedActividad.getNombre(),
        savedActividad.getDescripcion(),
        new MateriaDTO(savedActividad.getMateria().getId(), savedActividad.getMateria().getNombre())
    );

  }

  public List<ActividadDTO> obtenerActividades(){
    actividadRepository.findAll();
    List<Actividad> actividades = actividadRepository.findAll();
    
    // Mapear la lista de actividades a una lista de ActividadDTO
    return actividades.stream()
            .map(actividad -> new ActividadDTO(
                    actividad.getNombre(), 
                    actividad.getDescripcion(), 
                    new MateriaDTO(actividad.getMateria().getId(), actividad.getMateria().getNombre())
            ))
            .collect(Collectors.toList());
  }

  public ActividadDTO obtenerActividadId(Integer id){
    Actividad actividad = actividadRepository.findById(id).orElseThrow(() -> new RuntimeException("Actividad no encontrada"));

    return new ActividadDTO(
            actividad.getNombre(),
            actividad.getDescripcion(),
            new MateriaDTO(actividad.getMateria().getId(), actividad.getMateria().getNombre())
    );
  }

  public void eliminarActividad(Integer id){
    actividadRepository.deleteById(id);
  }
  
  
}

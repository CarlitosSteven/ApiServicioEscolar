package com.apiescolar.SistemaEscolar.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.DTOS.AlumnoDTO;
import com.apiescolar.SistemaEscolar.DTOS.MateriaDTO;
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
  


public MateriaDTO obtenerMateriaConAlumnosPorProfesor(int profesorId, int materiaId) {
  // Obtener la materia con su profesor y lista de alumnos
  Materia materia = materiaRepository.findByIdAndProfesorId(materiaId, profesorId)
          .orElseThrow(() -> new RuntimeException("Materia no encontrada para el profesor especificado"));

  // Convertir la entidad en DTO
  MateriaDTO materiaDTO = new MateriaDTO();
  materiaDTO.setId(materia.getId());
  materiaDTO.setNombre(materia.getNombre());

  // Convertir los alumnos de la materia a AlumnoDTO
  List<AlumnoDTO> alumnosDTO = materia.getAlumnoMaterias().stream()
          .map(alumnoMateria -> {
              AlumnoDTO alumnoDTO = new AlumnoDTO();
              alumnoDTO.setId(alumnoMateria.getAlumno().getId());
              alumnoDTO.setNombre(alumnoMateria.getAlumno().getNombre());
              return alumnoDTO;
          })
          .collect(Collectors.toList());

  materiaDTO.setAlumnos(alumnosDTO);

  return materiaDTO;
}
  



}

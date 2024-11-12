package com.apiescolar.SistemaEscolar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.DTOS.AlumnoDTO;
import com.apiescolar.SistemaEscolar.DTOS.AsistenciaDTO;
import com.apiescolar.SistemaEscolar.DTOS.MateriaDTO;
import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.Asistencia;
import com.apiescolar.SistemaEscolar.Entities.AsistenciaPK;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;
import com.apiescolar.SistemaEscolar.Repositories.AsistenciaRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;

@Service
public class AsistenciaService {

  @Autowired
  private AlumnoRepository alumnoRepository;
  
  @Autowired
  private MateriaRepository materiaRepository;

  @Autowired
  private AsistenciaRepository asistenciaRepository;

  public AsistenciaDTO registrarAsistencia(AsistenciaDTO asistenciaDTO){
    Alumno alumno = alumnoRepository.findById(asistenciaDTO.getAlumno().getId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Materia materia = materiaRepository.findById(asistenciaDTO.getMateria().getId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        // Crear la clave primaria compuesta AsistenciaPK
        AsistenciaPK asistenciaPK = new AsistenciaPK(
                asistenciaDTO.getAlumno().getId(),
                asistenciaDTO.getMateria().getId(),
                asistenciaDTO.getFecha()
        );

        // Crear la entidad Asistencia y asignar la clave primaria compuesta
        Asistencia asistencia = new Asistencia();
        asistencia.setId(asistenciaPK);
        asistencia.setAlumno(alumno);
        asistencia.setMateria(materia);
        asistencia.setAsistencia(asistenciaDTO.isAsistencia());

        // Guardar la asistencia
        Asistencia savedAsistencia = asistenciaRepository.save(asistencia);

        return new AsistenciaDTO(
          new AlumnoDTO(savedAsistencia.getAlumno().getId(), savedAsistencia.getAlumno().getNombre()),
          new MateriaDTO(savedAsistencia.getMateria().getId(), savedAsistencia.getMateria().getNombre()),
          savedAsistencia.isAsistencia(),
          savedAsistencia.getId().getFecha());
  }
}

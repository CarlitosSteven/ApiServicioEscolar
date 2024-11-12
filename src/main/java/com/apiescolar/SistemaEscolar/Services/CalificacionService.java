package com.apiescolar.SistemaEscolar.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.AlumnoActividad;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateria;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Repositories.ActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoMateriaRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;
import com.apiescolar.SistemaEscolar.Repositories.AsistenciaRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;

@Service
public class CalificacionService {

  @Autowired
  private AsistenciaRepository asistenciaRepository;

  @Autowired
  private AlumnoActividadRepository alumnoActividadRepository;

  @Autowired
  private AlumnoMateriaRepository alumnoMateriaRepository;

  @Autowired
  private MateriaRepository materiaRepository;

  @Autowired
  private ActividadRepository actividadRepository;

  @Autowired
  private AlumnoRepository alumnoRepository;

  public void calcularCalificacion(int alumnoId, int materiaId) {
    // Obtener asistencias
    long totalAsistencias = asistenciaRepository.countByAlumnoIdAndMateriaId(alumnoId, materiaId);
    long totalClases = materiaRepository.countById(materiaId); // Método para contar clases en una materia
    double porcentajeAsistencia = (double) totalAsistencias / totalClases * 100;

    // Obtener actividades entregadas
    List<AlumnoActividad> actividades = alumnoActividadRepository.findByAlumnoId(alumnoId);
    long actividadesEntregadas = actividades.stream()
            .filter(actividad -> actividad.isEntregado() && actividad.getActividad().getMateria().getId() == materiaId)
            .count();
    long totalActividades = actividadRepository.countByMateriaId(materiaId); // Método para contar actividades de la materia
    double porcentajeActividades = (double) actividadesEntregadas / totalActividades * 100;

    // Calcular calificación: 20% Asistencia, 80% Actividades
    double calificacion = 0.2 * porcentajeAsistencia + 0.8 * porcentajeActividades;
    
    if (calificacion > 100) {
    calificacion = 100;
    } else if (calificacion < 0) {
        calificacion = 0;
    }
     // Obtener las instancias completas de Alumno y Materia
    Alumno alumno = alumnoRepository.findById(alumnoId)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
    Materia materia = materiaRepository.findById(materiaId)
            .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

    // Obtener o crear la relación en la tabla alumno_materia
    AlumnoMateria alumnoMateria = alumnoMateriaRepository.findByAlumnoIdAndMateriaId(alumnoId, materiaId)
            .orElseGet(() -> new AlumnoMateria(alumno, materia));

    // Guardar la calificación
    alumnoMateria.setCalificacion(calificacion);
    alumnoMateriaRepository.save(alumnoMateria);
  }
}

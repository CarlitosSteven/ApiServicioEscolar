package com.apiescolar.SistemaEscolar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateria;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateriaPK;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoMateriaRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;

@Service
public class AlumnoMateriaService {

   @Autowired
    private AlumnoMateriaRepository alumnoMateriaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public AlumnoMateria agregarAlumnoAMateria(int alumnoId, int materiaId, Double calificacion) {
        // Obtener el alumno y la materia desde sus respectivos repositorios
        Alumno alumno = alumnoRepository.findById(alumnoId)
            .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
        Materia materia = materiaRepository.findById(materiaId)
            .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));

        // Crear el objeto AlumnoMateriaPK (clave compuesta)
        AlumnoMateriaPK alumnoMateriaPK = new AlumnoMateriaPK(alumnoId, materiaId);

        // Crear la instancia de AlumnoMateria y asignar la clave primaria compuesta
        AlumnoMateria alumnoMateria = new AlumnoMateria();
        alumnoMateria.setId(alumnoMateriaPK);
        alumnoMateria.setAlumno(alumno);
        alumnoMateria.setMateria(materia);
        alumnoMateria.setCalificacion(calificacion);

        // Guardar en la base de datos
        return alumnoMateriaRepository.save(alumnoMateria);
    }

}

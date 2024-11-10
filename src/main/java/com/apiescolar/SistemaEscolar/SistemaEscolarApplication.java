package com.apiescolar.SistemaEscolar;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apiescolar.SistemaEscolar.Entities.Actividad;
import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.AlumnoActividad;
import com.apiescolar.SistemaEscolar.Entities.AlumnoActividadesPK;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateria;
import com.apiescolar.SistemaEscolar.Entities.AlumnoMateriaPK;
import com.apiescolar.SistemaEscolar.Entities.Asistencia;
import com.apiescolar.SistemaEscolar.Entities.AsistenciaPK;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Repositories.ActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoMateriaRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;
import com.apiescolar.SistemaEscolar.Repositories.AsistenciaRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;
import com.apiescolar.SistemaEscolar.Repositories.ProfesorRepository;

@SpringBootApplication
public class SistemaEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEscolarApplication.class, args);
	}


	// @Bean
	// public CommandLineRunner testEntities(AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository, MateriaRepository materiaRepository, ActividadRepository actividadRepository, AlumnoActividadRepository alumnoActividadRepository, AlumnoMateriaRepository alumnoMateriaRepository, AsistenciaRepository asistenciaRepository){

	// 	return args -> {
	// 		LocalDate fechaActual = LocalDate.now();
	// 		// Crear instancias de las entidades (ejemplo con Alumno y Profesor)
	// 		Alumno alumno = new Alumno();
	// 		alumno.setId(1);
	// 		alumno.setNombre("Carlos");
	// 		alumnoRepository.save(alumno);

	// 		Profesor profesor = new Profesor();
	// 		profesor.setId(1);
	// 		profesor.setNombre("Juan Pérez");
	// 		profesor.setContrasenia("password");
	// 		profesorRepository.save(profesor);

	// 		Materia materia = new Materia();
	// 		materia.setId(1);
	// 		materia.setNombre("Matemáticas");
	// 		materia.setProfesor(profesor); // Asignamos el profesor a la materia
	// 		materiaRepository.save(materia);

	// 		Actividad actividad = new Actividad();
	// 		actividad.setMateria(materia);
	// 		actividad.setNombre("AsistenciaAct");
	// 		actividad.setDescripcion("ola");
	// 		actividad.setFechaEntrega(fechaActual);
	// 		actividadRepository.save(actividad);

	// 		AlumnoActividad alumnoActividad = new AlumnoActividad();
	// 		AlumnoActividadesPK alumnoActividadesPK = new AlumnoActividadesPK();
	// 		alumnoActividadesPK.setAlumnoId(1);
	// 		alumnoActividadesPK.setActividadId(1);
	// 		alumnoActividad.setId(alumnoActividadesPK);
	// 		alumnoActividad.setAlumno(alumno);
	// 		alumnoActividad.setActividad(actividad);
	// 		alumnoActividad.setEntregado(true);
	// 		alumnoActividadRepository.save(alumnoActividad);

	// 		AlumnoMateria alumnoMateria = new AlumnoMateria();
	// 		AlumnoMateriaPK AlMatPK = new AlumnoMateriaPK();
	// 		AlMatPK.setAlumnoId(1);
	// 		AlMatPK.setMateriaId(1);
	// 		alumnoMateria.setId(AlMatPK);
	// 		alumnoMateria.setAlumno(alumno);
	// 		alumnoMateria.setMateria(materia);
	// 		alumnoMateria.setCalificacion(9.5);
	// 		alumnoMateriaRepository.save(alumnoMateria);
			
	// 		Asistencia asistencia = new Asistencia();
	// 		AsistenciaPK asistenciaPK = new AsistenciaPK(); 
	// 		asistenciaPK.setMateriaId(1);
	// 		asistenciaPK.setAlumnoId(1);
	// 		asistenciaPK.setFecha(fechaActual);
	// 		asistencia.setId(asistenciaPK);
	// 		asistencia.setMateria(materia);
	// 		asistencia.setAlumno(alumno);
	// 		asistencia.setAsistencia(true);
	// 		asistenciaRepository.save(asistencia);

	// 		// Puedes realizar pruebas para ver si los objetos se crean correctamente
	// 		System.out.println("Alumno creado: " + alumno.getNombre());
	// 		System.out.println("Profesor asignado: " + profesor.getNombre());
	// 		System.out.println("Materia asignada: " + materia.getNombre());
	// 		System.out.println("Actividad Creada: " + actividad.getNombre());
	// 	};

	// }
 
}

package com.apiescolar.SistemaEscolar;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apiescolar.SistemaEscolar.Entities.Actividad;
import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Repositories.ActividadRepository;
import com.apiescolar.SistemaEscolar.Repositories.AlumnoRepository;
import com.apiescolar.SistemaEscolar.Repositories.MateriaRepository;
import com.apiescolar.SistemaEscolar.Repositories.ProfesorRepository;

@SpringBootApplication
public class SistemaEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEscolarApplication.class, args);
	}


	@Bean
	public CommandLineRunner testEntities(AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository, MateriaRepository materiaRepository, ActividadRepository actividadRepository){

		return args -> {
			LocalDate fechaActual = LocalDate.now();
			// Crear instancias de las entidades (ejemplo con Alumno y Profesor)
			Alumno alumno = new Alumno();
			alumno.setId(1);
			alumno.setNombre("Carlos");
			alumnoRepository.save(alumno);

			Profesor profesor = new Profesor();
			profesor.setId(1);
			profesor.setNombre("Juan Pérez");
			profesor.setContrasenia("password");
			profesorRepository.save(profesor);

			Materia materia = new Materia();
			materia.setId(1);
			materia.setNombre("Matemáticas");
			materia.setProfesor(profesor); // Asignamos el profesor a la materia
			materiaRepository.save(materia);

			Actividad actividad = new Actividad();
			actividad.setMateria(materia);
			actividad.setNombre("Tarea1");
			actividad.setDescripcion("ola");
			actividad.setFechaEntrega(fechaActual);
			actividadRepository.save(actividad);
			// Puedes realizar pruebas para ver si los objetos se crean correctamente
			System.out.println("Alumno creado: " + alumno.getNombre());
			System.out.println("Profesor asignado: " + profesor.getNombre());
			System.out.println("Materia asignada: " + materia.getNombre());
			System.out.println("Actividad Creada: " + actividad.getNombre());
		};

	}
 
}

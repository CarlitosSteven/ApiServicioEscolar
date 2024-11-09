package com.apiescolar.SistemaEscolar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Entities.Materia;

import com.apiescolar.SistemaEscolar.Entities.Profesor;

@SpringBootApplication
public class SistemaEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEscolarApplication.class, args);
	}


	@Bean
	public CommandLineRunner testEntities(){

		return args -> {
			// Crear instancias de las entidades (ejemplo con Alumno y Profesor)
			Alumno alumno = new Alumno();
			alumno.setId(1);
			alumno.setNombre("Carlos");

			Profesor profesor = new Profesor();
			profesor.setId(1);
			profesor.setNombre("Juan Pérez");
			profesor.setContrasenia("password");

			Materia materia = new Materia();
			materia.setId(1);
			materia.setNombre("Matemáticas");
			materia.setProfesor(profesor); // Asignamos el profesor a la materia

			// Puedes realizar pruebas para ver si los objetos se crean correctamente
			System.out.println("Alumno creado: " + alumno.getNombre());
			System.out.println("Profesor asignado: " + profesor.getNombre());
			System.out.println("Materia asignada: " + materia.getNombre());
		};

	}

}

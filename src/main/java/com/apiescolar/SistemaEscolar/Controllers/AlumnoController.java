package com.apiescolar.SistemaEscolar.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.Entities.Alumno;
import com.apiescolar.SistemaEscolar.Services.AlumnoService;

@RestController
public class AlumnoController {

  @Autowired  
  private AlumnoService alumnoService;

  @PostMapping("/agregarAlumno")
  public Alumno agregarAlumno(@RequestBody Alumno alumno){
    return alumnoService.agregarAlumno(alumno);
  }

  @GetMapping("/obtenerAlumnos")
  public List<Alumno> obtenerAlumnos(){
    return alumnoService.obtenerAlumnos();
  } 

  @GetMapping("/obtenerAlumnoId/{id}")
  public Optional<Alumno> obtenerAlumnoId(@PathVariable Integer id){
    return alumnoService.obtenerAlumnoId(id);
  }

  @DeleteMapping("/eliminarAlumno/{id}")
  public void eliminarAlumno(@PathVariable Integer id){
    alumnoService.eliminarAlumno(id);
  }
}

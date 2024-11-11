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

import com.apiescolar.SistemaEscolar.DTOS.MateriaDTO;
import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Services.MateriaService;

import jakarta.annotation.PostConstruct;

@RestController
public class MateriaController {

  @Autowired  
  private MateriaService materiaService;

  @PostConstruct
  public void init() {
      System.out.println("MateriaController está cargado");
  }

  @PostMapping("/agregarMateria")
  public Materia agregarMateria(@RequestBody Materia materia){
    return materiaService.agregarMateria(materia);
  }

  @GetMapping("/obtenerMaterias")
  public List<Materia> obtenerMaterias(){
    return materiaService.obtenerMaterias();
  } 

  @GetMapping("/obtenerMateriaId/{id}")
  public Optional<Materia> obtenerMateriaId(@PathVariable Integer id){
    return materiaService.obtenerMateriaId(id);
  }

  @DeleteMapping("/eliminarMateria/{id}")
  public void eliminarMateria(@PathVariable Integer id){
    materiaService.eliminarMateria(id);
  }
  @GetMapping("/profesores/{profesorId}/materias/{materiaId}/alumnos")
  public MateriaDTO obtenerAlumnosPorMateriaYProfesor(@PathVariable int profesorId, @PathVariable int materiaId) {
    System.out.println("Ruta alcanzada con profesorId: " + profesorId + " y materiaId: " + materiaId);
    return materiaService.obtenerMateriaConAlumnosPorProfesor(profesorId, materiaId);
  }
}

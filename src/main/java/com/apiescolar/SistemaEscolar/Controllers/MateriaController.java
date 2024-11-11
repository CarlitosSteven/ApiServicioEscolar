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

import com.apiescolar.SistemaEscolar.Entities.Materia;
import com.apiescolar.SistemaEscolar.Services.MateriaService;

@RestController
public class MateriaController {

  @Autowired  
  private MateriaService materiaService;

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
}

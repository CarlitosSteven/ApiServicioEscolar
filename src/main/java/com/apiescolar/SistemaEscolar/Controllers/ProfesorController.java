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

import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Services.ProfesorService;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class ProfesorController {
 
  @Autowired
  private ProfesorService profesorService;

  @PostMapping("/agregarProfesor")
  public Profesor agregarProfesor(@RequestBody Profesor profesor){
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    char[] charPassword = profesor.getContrasenia().toCharArray();
    String hash = argon2.hash(1, 1024, 1 , charPassword);
    profesor.setContrasenia(hash);
    return this.profesorService.agregarProfesor(profesor);
   
  }

  @GetMapping("/obtenerProfesores")
  public List<Profesor> obtenerProfesores(){
    return profesorService.obtenerProfesores();
  }

  @GetMapping("/obtenerProfesorId/{id}")
  public Optional<Profesor> obtenerProfesorId(@PathVariable Integer id){
    return profesorService.obtenerProfesorId(id);
  }

  @DeleteMapping("/eliminarProfesor/{id}")
  public void eliminarProfesor(@PathVariable Integer id){
    this.profesorService.eliminarProfesor(id);
  }

}

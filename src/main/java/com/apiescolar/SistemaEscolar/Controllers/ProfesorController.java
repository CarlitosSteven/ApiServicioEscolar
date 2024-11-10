package com.apiescolar.SistemaEscolar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Services.ProfesorService;

@RestController
public class ProfesorController {
 
  @Autowired
  private ProfesorService profesorService;

  @PostMapping("/agregarProfesor")
  public Profesor agregarProfesor(@RequestBody Profesor profesor){
    return this.profesorService.agregarProfesor(profesor);
   
  }
}

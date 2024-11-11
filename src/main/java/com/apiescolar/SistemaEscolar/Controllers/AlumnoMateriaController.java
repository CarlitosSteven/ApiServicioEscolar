package com.apiescolar.SistemaEscolar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.Entities.AlumnoMateria;
import com.apiescolar.SistemaEscolar.Services.AlumnoMateriaService;

@RestController
public class AlumnoMateriaController {
  
  @Autowired
  private AlumnoMateriaService alumnoMateriaService;

  @PostMapping("/agregarAlumnoMateria")
  public AlumnoMateria agregarAlumnoAMateria(
    @RequestParam int alumnoId, 
    @RequestParam int materiaId, 
    @RequestParam(required = false) Double calificacion) {

    return alumnoMateriaService.agregarAlumnoAMateria(alumnoId, materiaId, calificacion);
  }
}

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

import com.apiescolar.SistemaEscolar.DTOS.ActividadDTO;
import com.apiescolar.SistemaEscolar.Entities.Actividad;
import com.apiescolar.SistemaEscolar.Services.ActividadService;

@RestController
public class ActividadController {
  
  @Autowired
  ActividadService actividadService;

  @PostMapping("/agregarActividad")
  public ActividadDTO agregarActividad(@RequestBody ActividadDTO actividadDTO){
    return actividadService.agregarActividad(actividadDTO);
  }

  @GetMapping("/obtenerActividades")
  public List<Actividad> obtenerActividades(){
    return this.actividadService.obtenerActividades();
  }

  @GetMapping("/obtenerActividadId/{id}")
  public Optional<Actividad> obtenerActividadId(@PathVariable Integer id){
    return this.actividadService.obtenerActividadId(id);
  }

  @DeleteMapping("/eliminarActividad/{id}")
  public void eliminarActividad(@PathVariable Integer id){
    this.actividadService.eliminarActividad(id);
  }

}

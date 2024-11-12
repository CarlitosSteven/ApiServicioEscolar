package com.apiescolar.SistemaEscolar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.DTOS.AsistenciaDTO;
import com.apiescolar.SistemaEscolar.Services.AsistenciaService;

@RestController
public class AsistenciaController {

  @Autowired
  private AsistenciaService asistenciaService;

  @PostMapping("/registrarAsistencia")
  public AsistenciaDTO registrarAsistencia(@RequestBody AsistenciaDTO asistenciaDTO){

    return asistenciaService.registrarAsistencia(asistenciaDTO);

  }
}

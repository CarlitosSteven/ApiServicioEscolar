package com.apiescolar.SistemaEscolar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.Services.CalificacionService;

@RestController
public class CalificacionController {

  @Autowired
  private CalificacionService calificacionService;

  
  @PostMapping("/calificar")
  public ResponseEntity<String> calcularCalificacion(@RequestParam int alumnoId, @RequestParam int materiaId) {
    try {
        // Llamar al servicio para calcular la calificación
        calificacionService.calcularCalificacion(alumnoId, materiaId);
        
        // Si todo va bien, retornar un mensaje de éxito
        return ResponseEntity.ok("Calificación calculada y guardada correctamente");
    } catch (RuntimeException e) {
        return ResponseEntity.status(400).body("Error: " + e.getMessage());
    }
  }
}

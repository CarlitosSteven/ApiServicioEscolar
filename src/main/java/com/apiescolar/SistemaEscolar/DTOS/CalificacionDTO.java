package com.apiescolar.SistemaEscolar.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalificacionDTO {
  private double asistencias;
  
  private double actividades;

  private double calificacionFinal;
}

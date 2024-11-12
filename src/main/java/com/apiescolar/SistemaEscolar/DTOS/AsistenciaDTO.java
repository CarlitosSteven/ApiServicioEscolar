package com.apiescolar.SistemaEscolar.DTOS;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaDTO {

  private AlumnoDTO alumno;
  private MateriaDTO materia;
  private boolean asistencia;
  private LocalDate fecha;

}

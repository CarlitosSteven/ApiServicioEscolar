package com.apiescolar.SistemaEscolar.DTOS;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActividadDTO {

  private String nombre;      // Nombre de la actividad
  private String descripcion; // Descripción de la actividad
  private MateriaDTO materia;

  public ActividadDTO(String nombre, String descripcion, MateriaDTO materia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materia = materia;
    }
  
}

package com.apiescolar.SistemaEscolar.DTOS;

import java.util.List;

import lombok.Data;

@Data
public class MateriaDTO {

  private int id;
  private String nombre;
  private List<AlumnoDTO> alumnos;  
}

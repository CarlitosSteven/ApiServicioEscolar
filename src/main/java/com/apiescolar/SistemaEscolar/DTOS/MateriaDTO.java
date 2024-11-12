package com.apiescolar.SistemaEscolar.DTOS;

import java.util.List;

import lombok.Data;

@Data
public class MateriaDTO {

  private int id;
  private String nombre;
  private List<AlumnoDTO> alumnos;  

  public MateriaDTO(int id, String nombre) {
      this.id = id;
      this.nombre = nombre;
  }

  public MateriaDTO() {
    //TODO Auto-generated constructor stub
  }

  

}

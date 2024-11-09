package com.apiescolar.SistemaEscolar.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AlumnoMateriaPK implements Serializable{

  
  @Column(name = "alumno_id")
  private int alumnoId;


  @Column(name = "materia_id")
  private int materiaId;
}

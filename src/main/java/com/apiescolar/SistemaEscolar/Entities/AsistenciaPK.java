package com.apiescolar.SistemaEscolar.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaPK implements Serializable{

  @Column(name = "materia_id")
  private int materiaId;
  
  @Column(name = "alumno_id")
  private int alumnoId;
  
  @Column(name = "fecha")
  private LocalDate fecha;

}

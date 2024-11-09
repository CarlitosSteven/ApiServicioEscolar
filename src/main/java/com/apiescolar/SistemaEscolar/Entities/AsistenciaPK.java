package com.apiescolar.SistemaEscolar.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
public class AsistenciaPK implements Serializable{

  @Column(name = "materia_id")
  private int materiaId;
  
  @Column(name = "alumno_id")
  private int alumnoId;
  
  @Column(name = "fecha")
  private LocalDate fecha;
}

package com.apiescolar.SistemaEscolar.Entities;

import lombok.Data;
import jakarta.persistence.*; 

@Entity
@Table(name = "asistencias")
@Data
public class Asistencia {
  
  @EmbeddedId
  AsistenciaPK id;

  @ManyToOne
  @MapsId("materiaId")
  @JoinColumn(name = "materia_id", nullable=false)
  private Materia materia;

  @ManyToOne
  @MapsId("alumnoId")
  @JoinColumn(name = "alumno_id", nullable=false)
  private Alumno alumno;

  
  @Column(name = "asistencia")
  private boolean asistencia;

}

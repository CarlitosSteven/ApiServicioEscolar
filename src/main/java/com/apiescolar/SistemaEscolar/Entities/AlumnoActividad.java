package com.apiescolar.SistemaEscolar.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alumno_actividades")
public class AlumnoActividad {
  
  @EmbeddedId
  AlumnoActividadesPK id;


  @ManyToOne
  @MapsId("alumnoId")
  @JoinColumn(name = "alumno_id", nullable=false)
  private Alumno alumno;

  @ManyToOne
  @MapsId("actividadId")
  @JoinColumn(name = "actividad_id",nullable=false)
  private Actividad actividad;

  @Column(name = "entregado", nullable=false)
  private boolean entregado;

}

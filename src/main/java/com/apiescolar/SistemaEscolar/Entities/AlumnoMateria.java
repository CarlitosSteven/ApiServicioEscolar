package com.apiescolar.SistemaEscolar.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "alumnos_materias")
@Data
public class AlumnoMateria {

  //PrimaryKey Compuesta
  @EmbeddedId
  private AlumnoMateriaPK id;
  
  @ManyToOne
  @MapsId("alumnoId")
  @JoinColumn(name = "alumno_id", nullable=false)
  private Alumno alumno;

  @ManyToOne
  @MapsId("materiaId")
  @JoinColumn(name = "materia_id", nullable=false)
  private Materia materia;

  @Column(name = "calificacion")
  private Double calificacion;

}
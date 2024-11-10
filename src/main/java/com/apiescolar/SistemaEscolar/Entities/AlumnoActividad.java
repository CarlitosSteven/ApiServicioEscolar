package com.apiescolar.SistemaEscolar.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "alumno_actividades")
@Data
public class AlumnoActividad {
  
  //Creando las llaves primarias compuestas en la clase AlumnoActividadesPK
  @EmbeddedId
  AlumnoActividadPK id;


  //Relacion muchos a uno de Alumno
  @ManyToOne
  //Mapeando el id, que lo lleva hacia "alumnoId" de la clase AlumnoActvidadesPK
  @MapsId("alumnoId")
  //Define la columna "alumno_id" que esta en la tabla de alumno_actividades sera la columna que hace referencia a la PK de la tabla alulmnos
  @JoinColumn(name = "alumno_id", nullable=false)
  private Alumno alumno;


  //Relacion de muchos a uno de Actividad
  @ManyToOne
  //Mapeando el id, que lo lleva hacia "actividadId" de la clase AlumnoActvidadesPK
  @MapsId("actividadId")
  //Define la columna "actividad_id" que esta en la tabla de alumno_actividades sera la columna que hace referencia a la PK de la tabla actividades
  @JoinColumn(name = "actividad_id",nullable=false)
  private Actividad actividad;

  @Column(name = "entregado", nullable=false)
  private boolean entregado;

}

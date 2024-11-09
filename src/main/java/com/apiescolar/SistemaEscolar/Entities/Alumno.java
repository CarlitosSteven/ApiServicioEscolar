package com.apiescolar.SistemaEscolar.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

  @Id
  @Column(name = "id", nullable=false)
  private int id;

  @Column(name = "nombre", length=255)
  private String nombre;

 
  //Relacion uno a muchos en donde One es el alumno y tiene una lista de muchas materias
  //Y el mappebBy hace referencia al objeto de clase Alumno llamado "alumno" que esta en
  //la clase AlumnoMateria
  @OneToMany(mappedBy = "alumno")
  private List<AlumnoMateria> alumnoMaterias;

  @OneToMany(mappedBy = "alumno")
  private List<AlumnoActividad> alumnoActividades;

  @OneToMany(mappedBy = "alumno")
  private List<Asistencia> asistencias;

}

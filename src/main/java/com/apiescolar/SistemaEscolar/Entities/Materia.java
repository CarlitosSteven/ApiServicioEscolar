package com.apiescolar.SistemaEscolar.Entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "materias")
public class Materia {
  
  @Id
  @Column(name = "id", nullable=false)
  private int id;

  @Column(name = "nombre", length=255)
  private String nombre;

  //Llave foranea referenciando al id de profesor
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "profesor_id", nullable=true, referencedColumnName= "id")
  private Profesor profesor;
  
  @OneToMany(mappedBy="materia")
  private Set<Actividad> actividades = new HashSet<>();

  @OneToMany(mappedBy = "materia")
  private Set<AlumnoMateria> alumnoMaterias= new HashSet<>();

  @OneToMany(mappedBy = "materia")
  private Set<Asistencia> asistencias= new HashSet<>();
}

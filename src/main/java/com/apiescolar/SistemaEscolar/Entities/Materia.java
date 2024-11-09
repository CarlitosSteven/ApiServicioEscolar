package com.apiescolar.SistemaEscolar.Entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
  @ManyToOne
  @JoinColumn(name = "profesor_id", referencedColumnName = "id")
  private Profesor profesor;
  
  @OneToMany(mappedBy = "materia")
  private List<AlumnoMateria> alumnoMaterias;

  @OneToMany(mappedBy = "materia")
  private List<Asistencia> asistencias;
}

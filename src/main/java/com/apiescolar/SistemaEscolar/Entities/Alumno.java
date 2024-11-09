package com.apiescolar.SistemaEscolar.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

  @Id
  @Column(name = "id", nullable=false)
  private int id;

  @Column(name = "nombre")
  private String nombre;

 
  @OneToMany(mappedBy = "alumno")
  private List<AlumnoMateria> materias;

}

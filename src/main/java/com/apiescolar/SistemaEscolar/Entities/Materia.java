package com.apiescolar.SistemaEscolar.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "materias")
public class Materia {
  
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "nombre")
  private String nombre;

  //Llave foranea referenciando al id de profesor
  @ManyToOne
  @JoinColumn(name = "profesor_id", referencedColumnName = "id")
  private Profesor profesor;
  
  @OneToMany(mappedBy = "materia")
    private List<AlumnoMateria> alumnos;
}

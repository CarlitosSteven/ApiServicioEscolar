package com.apiescolar.SistemaEscolar.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

  @ManyToOne
  @JoinColumn(name = "profesor_id", referencedColumnName = "id")
  private Profesor profesor;
  
}

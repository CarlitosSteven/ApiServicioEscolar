package com.apiescolar.SistemaEscolar.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "nombre")
  private String nombre;

}

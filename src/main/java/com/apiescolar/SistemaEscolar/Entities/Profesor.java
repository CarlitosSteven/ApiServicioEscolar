package com.apiescolar.SistemaEscolar.Entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "profesores")
@Data
public class Profesor {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "contrasenia")
  private String contrasenia;

  //Se refiere a la relacion uno a muchos para materias
  @OneToMany(mappedBy = "profesor")
  private List<Materia> materias;
}

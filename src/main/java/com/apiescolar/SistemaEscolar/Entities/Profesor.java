package com.apiescolar.SistemaEscolar.Entities;

import java.util.List;

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
  @Column(name = "id", nullable=false)
  private Integer id;

  @Column(name = "nombre", length=255)
  private String nombre;

  @Column(name = "contrasenia", length=255)
  private String contrasenia;

  //Se refiere a la relacion uno a muchos para materias
  @OneToMany(mappedBy = "profesor")
  private List<Materia> materias;
}


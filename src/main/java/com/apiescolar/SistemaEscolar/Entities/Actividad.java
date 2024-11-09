package com.apiescolar.SistemaEscolar.Entities;

import java.util.Date;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "actividades")
@Data
public class Actividad {

  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  @Id 
  private int id;

  @ManyToOne 
  @JoinColumn(name = "materia_id", nullable = false)
  private Materia materia;

  @Column(name = "nombre",length = 255)
  private String nombre;

  @Column(name = "descripcion", length = 255)
  private String descripcion;

  @Column(name = "fecha_entrega")
  private Date fechaEntrega;


}

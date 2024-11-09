package com.apiescolar.SistemaEscolar.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
  private LocalDate fechaEntrega;


}

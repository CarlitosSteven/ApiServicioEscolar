package com.apiescolar.SistemaEscolar.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "actividades", uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "materia_id"}))
@Data
public class Actividad {

  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  @Id 
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "materia_id", nullable = false, referencedColumnName="id")
  private Materia materia;

  @Column(name = "nombre",length = 255)
  private String nombre;

  @Column(name = "descripcion", length = 255)
  private String descripcion;

  @Column(name = "fecha_entrega")
  private LocalDate fechaEntrega;


}

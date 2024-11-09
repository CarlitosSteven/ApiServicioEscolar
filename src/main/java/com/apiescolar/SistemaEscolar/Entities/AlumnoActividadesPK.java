package com.apiescolar.SistemaEscolar.Entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class AlumnoActividadesPK implements Serializable {

  @Column(name = "alumno_id")
  private int alumnoId;

  @Column(name = "actividad_id")
  private int actividadId;

}

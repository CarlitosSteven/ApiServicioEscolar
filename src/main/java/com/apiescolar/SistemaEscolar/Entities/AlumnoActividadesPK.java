package com.apiescolar.SistemaEscolar.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

//Anotacion utilizada que indica que esta es una clase Embebida, o sea
//que es una clase que puede ser usada como llave primaria
@Embeddable
@Data
public class AlumnoActividadesPK implements Serializable {

  @Column(name = "alumno_id")
  private int alumnoId;

  @Column(name = "actividad_id")
  private int actividadId;

}

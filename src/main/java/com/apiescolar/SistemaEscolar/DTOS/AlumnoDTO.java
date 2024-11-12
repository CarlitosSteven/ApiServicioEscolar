package com.apiescolar.SistemaEscolar.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
  private int id;
  private String nombre; 

    public AlumnoDTO(int id) {
        this.id = id;
    }


}

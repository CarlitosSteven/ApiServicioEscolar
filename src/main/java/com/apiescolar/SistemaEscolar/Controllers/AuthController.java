package com.apiescolar.SistemaEscolar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiescolar.SistemaEscolar.Entities.Profesor;
import com.apiescolar.SistemaEscolar.Services.ProfesorService;
import com.apiescolar.SistemaEscolar.Util.JWTUtil;

@RestController
public class AuthController {

 @Autowired
  private ProfesorService profesorService;

  @Autowired
  private JWTUtil jwtUtil; 

  @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam int id, @RequestParam String contrasenia) {
      // Paso 1: Verificar que el profesor existe por su ID
      Profesor profesor = profesorService.findById(id);

      // Paso 2: Validar que la contraseña sea correcta
      if (profesor == null || !profesor.getContrasenia().equals(contrasenia)) {
          return ResponseEntity.status(401).body("Credenciales incorrectas");
      }

      // Paso 3: Crear el token JWT
      String token = jwtUtil.create(String.valueOf(profesor.getId()), profesor.getContrasenia());

      // Paso 4: Devolver el token JWT
      return ResponseEntity.ok(token);
  }
}

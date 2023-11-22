package com.example.KonectaAPI.controladores;

import com.example.KonectaAPI.entidades.Afiliado;
import com.example.KonectaAPI.entidades.Examen;
import com.example.KonectaAPI.servicios.ExamenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/examenes")

public class ExamenControlador {
    @Autowired
      ExamenServicio examenServicio;
    @PostMapping
    public ResponseEntity<?> agregarExamen(@RequestBody Examen examen)  {
        try {
            Examen repuestaServicio=this.examenServicio.registarExamen(examen);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(repuestaServicio);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
@GetMapping("/{id}")
    public ResponseEntity<?> buscarExamen(@PathVariable Integer id){
        try {
            Examen respuestaServicio=this.examenServicio.consultarExamen(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @GetMapping
    public ResponseEntity<List<Examen>> consultarExamen(){
        try {
            List<Examen> listaConsultada= this.examenServicio.buscarExamenes();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaConsultada);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Examen> modificarExamen(@PathVariable Integer id,@RequestBody Examen examen){
        try {
            Examen examenRespuesta=  this.examenServicio.editarExamen(id,examen);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(examenRespuesta);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarExamen(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.examenServicio.retirarExamen(id));


        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }



}

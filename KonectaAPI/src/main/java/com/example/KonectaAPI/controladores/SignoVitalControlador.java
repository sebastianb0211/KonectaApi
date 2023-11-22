package com.example.KonectaAPI.controladores;

import com.example.KonectaAPI.entidades.Examen;
import com.example.KonectaAPI.entidades.SignoVital;
import com.example.KonectaAPI.servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/signosVitales")

public class SignoVitalControlador {
    @Autowired
    SignoVitalServicio signoVitalServicio;
    @PostMapping
    public ResponseEntity<?> agregarSignoVital(@RequestBody SignoVital signoVital){
        try {
            SignoVital respuestaServicio=this.signoVitalServicio.registarSignoVital(signoVital);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarExamen(@PathVariable Integer id){
        try {
            SignoVital respuestaServicio=this.signoVitalServicio.consultarSignoVital(id);
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
    public ResponseEntity<List<SignoVital>> consultarSignoVital(){
        try {
            List<SignoVital> listaConsultada= this.signoVitalServicio.buscarSignoVital();
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
    public ResponseEntity<SignoVital> modificarSignoVital(@PathVariable Integer id,@RequestBody SignoVital signoVital){
        try {
            SignoVital examenRespuesta=  this.signoVitalServicio.editarSignoVital(id,signoVital);
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
    public ResponseEntity<?> eliminarSignoVital(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.signoVitalServicio.retirarSignoVital(id));


        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}

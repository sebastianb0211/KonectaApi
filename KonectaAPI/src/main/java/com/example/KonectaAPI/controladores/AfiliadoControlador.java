package com.example.KonectaAPI.controladores;

import com.example.KonectaAPI.entidades.Afiliado;
import com.example.KonectaAPI.servicios.AfiliadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/afiliados")
public class AfiliadoControlador {
    //agregar afiliafo
    // buscar afiliado

    @Autowired
    private AfiliadoServicio afiliadoServicio;
    @PostMapping
    public ResponseEntity <?> agregarAfiliado(@RequestBody Afiliado afiliado){
        try {
          Afiliado respuestaServicio=this.afiliadoServicio.registarAfiliado(afiliado);
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
    public ResponseEntity<?> buscarAfiliado(@PathVariable Integer id){
        try {
         Afiliado respuestaServicio=this.afiliadoServicio.consultarAfiliado(id);
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
    public ResponseEntity<List<Afiliado>> consultarAfiliados(){
        try {
            List<Afiliado> listaConsultada= this.afiliadoServicio.buscarTodosAfiliados();
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
    public ResponseEntity<Afiliado> modificarAfiliado(@PathVariable Integer id,@RequestBody Afiliado afiliado){
        try {
          Afiliado afiliadoRespuestas=  this.afiliadoServicio.editarAfiliado(id,afiliado);
          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(afiliadoRespuestas);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAfiliado(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.afiliadoServicio.retirarAfiliado(id));


        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}

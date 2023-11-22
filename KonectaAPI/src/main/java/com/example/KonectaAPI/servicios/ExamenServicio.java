package com.example.KonectaAPI.servicios;

import com.example.KonectaAPI.entidades.Afiliado;
import com.example.KonectaAPI.entidades.Examen;
import com.example.KonectaAPI.repositorios.AfiliadoRepositorio;
import com.example.KonectaAPI.repositorios.ExamenRepositorio;
import com.example.KonectaAPI.utilidades.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServicio {
    @Autowired
    ExamenRepositorio examenRepositorio;


    //Registrar un afiliado
    public Examen registarExamen(Examen examen)throws Exception{
        try {
            return this.examenRepositorio.save(examen);

        }catch (Exception error){
            throw new Exception(Mensajes.ERROR_REGISTRO.getMensaje());

        }

    }


    public Examen consultarExamen(Integer idExamen)throws Exception{
        try {

            Optional<Examen> examenBuscado= this.examenRepositorio.findById(idExamen);
            if(examenBuscado.isPresent()){
                return examenBuscado.get();// lo encontro en la base de datos

            }else {// no lo encontre
                throw new Exception("Examen no encontrado");
            }

        }catch (Exception error){
            throw new Exception("error en la consulta afiliado");

        }
    }

    public List<Examen> buscarExamenes()throws Exception{

        try {
            List<Examen> listaConsultadaExamen= this.examenRepositorio.findAll();
            return listaConsultadaExamen;

        }catch (Exception error){

            throw new Exception("error consultando afiliados");

        }

    }

    public Examen editarExamen(Integer id,Examen examen) throws Exception{
        try {
            Optional<Examen>examenBuscado=this.examenRepositorio.findById(id);
            if (examenBuscado.isPresent()){
                Examen examenExistente= examenBuscado.get();
                examenExistente.setNombreExamen(examen.getNombreExamen());
                examenExistente.setImagenExamen(examen.getImagenExamen());

                Examen examenModificado =this.examenRepositorio.save(examenExistente);
                return examenModificado;

            }else {
                throw new Exception("no esta ´presente");
            }

        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception("fallamos editando");

        }
    }
    public Boolean retirarExamen(Integer id)throws Exception{
        try {
            Boolean ExamenEncontrado= this.examenRepositorio.existsById(id);
            if (ExamenEncontrado){
                this.examenRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("el examen no existe para eliminar");
            }

        }catch (Exception error){
            throw new Exception("Fallamos borrando");
        }
    }

}

package com.example.KonectaAPI.servicios;

import com.example.KonectaAPI.entidades.Afiliado;
import com.example.KonectaAPI.repositorios.AfiliadoRepositorio;
import com.example.KonectaAPI.utilidades.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServicio {

    @Autowired
    AfiliadoRepositorio afiliadoRepositorio;


    //Registrar un afiliado
    public Afiliado registarAfiliado(Afiliado afiliado)throws Exception{
        try {
           return this.afiliadoRepositorio.save(afiliado);

        }catch (Exception error){
            throw new Exception(Mensajes.ERROR_REGISTRO.getMensaje());

        }

    }
    //Consultar un afiliado

    public Afiliado consultarAfiliado(Integer idAfiliado)throws Exception{
        try {

            Optional<Afiliado>afiliadoBuscado= this.afiliadoRepositorio.findById(idAfiliado);
            if(afiliadoBuscado.isPresent()){
                return afiliadoBuscado.get();// lo encontro en la base de datos

            }else {// no lo encontre
                throw new Exception("Afiliado no encontrado");
            }

        }catch (Exception error){
            throw new Exception("error en la consulta afiliado");

        }
    }
    //Consultar Afiliados
    //Modificar Datos

    public List<Afiliado> buscarTodosAfiliados()throws Exception{

        try {
           List<Afiliado> listaConsultada= this.afiliadoRepositorio.findAll();
           return listaConsultada;

        }catch (Exception error){

            throw new Exception("error consultando afiliados");

        }

    }

    public Afiliado editarAfiliado(Integer id,Afiliado afiliado) throws Exception{
        try {
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(id);
            if (afiliadoBuscado.isPresent()){
               Afiliado afiliadoExistente= afiliadoBuscado.get();
               afiliadoExistente.setCorreo(afiliado.getCorreo());
               afiliadoExistente.setTelefono(afiliado.getTelefono());

               Afiliado afiliadoModificado =this.afiliadoRepositorio.save(afiliadoExistente);
                return afiliadoModificado;

            }else {
                throw new Exception("no esta ´presente");
            }

        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception("fallamos editando");

        }
    }

    public Boolean retirarAfiliado(Integer id)throws Exception{
        try {
            Boolean afiliadoEncontrar= this.afiliadoRepositorio.existsById(id);
            if (afiliadoEncontrar){
                this.afiliadoRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("el usuario no existe para eliminar");
            }

        }catch (Exception error){
            throw new Exception("Fallamos borrando");
        }
    }


}

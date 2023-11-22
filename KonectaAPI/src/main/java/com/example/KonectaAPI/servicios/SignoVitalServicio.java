package com.example.KonectaAPI.servicios;

import com.example.KonectaAPI.entidades.Afiliado;
import com.example.KonectaAPI.entidades.Examen;
import com.example.KonectaAPI.entidades.SignoVital;
import com.example.KonectaAPI.repositorios.AfiliadoRepositorio;
import com.example.KonectaAPI.repositorios.SignoVitalRepositorio;
import com.example.KonectaAPI.utilidades.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignoVitalServicio {
    @Autowired
    SignoVitalRepositorio signoVitalRepositorio;


    //Registrar un afiliado
    public SignoVital registarSignoVital(SignoVital signoVital)throws Exception{
        try {
            return this.signoVitalRepositorio.save(signoVital);

        }catch (Exception error){
            throw new Exception(Mensajes.ERROR_REGISTRO.getMensaje());

        }

    }

    public SignoVital consultarSignoVital(Integer idSignoVital)throws Exception{
        try {

            Optional<SignoVital> signoVitalBuscado= this.signoVitalRepositorio.findById(idSignoVital);
            if(signoVitalBuscado.isPresent()){
                return signoVitalBuscado.get();// lo encontro en la base de datos

            }else {// no lo encontre
                throw new Exception("Examen no encontrado");
            }

        }catch (Exception error){
            throw new Exception("error en la consulta afiliado");

        }
    }


    public List<SignoVital> buscarSignoVital()throws Exception{

        try {
            List<SignoVital> listaConsultadaSignoVital= this.signoVitalRepositorio.findAll();
            return listaConsultadaSignoVital;

        }catch (Exception error){

            throw new Exception("error consultando afiliados");

        }

    }
    public SignoVital editarSignoVital(Integer id,SignoVital signoVital) throws Exception{
        try {
            Optional<SignoVital>signoVitalBuscado=this.signoVitalRepositorio.findById(id);
            if (signoVitalBuscado.isPresent()){
                SignoVital signoVitalExistente= signoVitalBuscado.get();
                signoVitalExistente.setNombre(signoVital.getNombre());
                signoVitalExistente.setMaximoNormal(signoVital.getMaximoNormal());

                SignoVital signoVitalModificado =this.signoVitalRepositorio.save(signoVitalExistente);
                return signoVitalModificado;

            }else {
                throw new Exception("no esta ´presente");
            }

        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception("fallamos editando");

        }
    }

    public Boolean retirarSignoVital(Integer id)throws Exception{
        try {
            Boolean SignoVitalEncontrado= this.signoVitalRepositorio.existsById(id);
            if (SignoVitalEncontrado){
                this.signoVitalRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("el signo vital no existe para eliminar");
            }

        }catch (Exception error){
            throw new Exception("Fallamos borrando");
        }
    }
}

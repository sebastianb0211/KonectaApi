package com.example.KonectaAPI.repositorios;

import com.example.KonectaAPI.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepositorio extends JpaRepository<Afiliado,Integer> {
}

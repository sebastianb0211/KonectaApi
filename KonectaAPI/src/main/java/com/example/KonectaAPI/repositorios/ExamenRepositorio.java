package com.example.KonectaAPI.repositorios;

import com.example.KonectaAPI.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepositorio extends JpaRepository<Examen,Integer> {
}

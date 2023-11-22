package com.example.KonectaAPI.repositorios;

import com.example.KonectaAPI.entidades.SignoVital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignoVitalRepositorio extends JpaRepository<SignoVital,Integer> {
}

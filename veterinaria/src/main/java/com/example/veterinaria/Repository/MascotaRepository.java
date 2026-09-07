package com.example.veterinaria.Repository;


import com.example.veterinaria.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    List<Mascota> findByNombreContainingIgnoreCase(String nombre );

    List<Mascota> findByEspecieIgnoreCase(String especie);

    List<Mascota> findByPropietarioId(Long propietarioId);
}

package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.HistoriaClinica;
import org.springframework.stereotype.Service;


import java.util.List;

public interface HistoriaClinicaService {

    void eliminar(Long id);

    List<HistoriaClinica> listarTodos();

    HistoriaClinica buscarPorId(long id);

    HistoriaClinica crear(HistoriaClinica historia, long mascotaId);

    HistoriaClinica actualizar( long id,HistoriaClinica historia);



}

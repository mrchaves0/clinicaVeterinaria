package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodos();

    HistoriaClinica buscarPorId(long id);

    HistoriaClinica crear(HistoriaClinica historia, long mascotaId);

    HistoriaClinica actualizar( long id,HistoriaClinica historia);

    void eliminar(long id);
}

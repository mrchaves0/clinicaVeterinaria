package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Mascota;
import com.example.veterinaria.Entity.Veterinario;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodas();

    Mascota buscarPorId(long id);

    Mascota guardar(Mascota mascota, long propietarioId);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);

    List<Mascota> buscarPorPropietario(long propietarioId);

    Mascota asignarVeterinario(long mascotaId, long veterinarioId);
}

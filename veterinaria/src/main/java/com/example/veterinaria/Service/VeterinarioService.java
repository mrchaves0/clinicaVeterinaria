package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Veterinario;

import java.util.List;

public interface VeterinarioService {

    List<Veterinario> listarTodos();

    Veterinario buscarPorId(long id);

    Veterinario guardar(Veterinario veterinario);

    Veterinario actualizar( long id,Veterinario veterinario);

    void eliminar(long id);
}

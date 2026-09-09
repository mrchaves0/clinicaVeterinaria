package com.example.veterinaria.Service.ServiceImpl;


import com.example.veterinaria.Entity.Veterinario;
import com.example.veterinaria.Repository.VeterinarioRepository;
import com.example.veterinaria.Service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarPorId(long id) {
        return veterinarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(long id, Veterinario veterinario) {
        Veterinario existente = buscarPorId(id);
        existente.setNombre(veterinario.getNombre());
        existente.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        existente.setEspecialidad(veterinario.getEspecialidad());
        existente.setCorreo(veterinario.getCorreo());
        return veterinarioRepository.save(existente);
    }

    @Override
    public void eliminar(long id) {
        if (!veterinarioRepository.existsById(id)) {
            throw new RuntimeException("Veterinario no existe");
        }
        veterinarioRepository.deleteById(id);
    }
}
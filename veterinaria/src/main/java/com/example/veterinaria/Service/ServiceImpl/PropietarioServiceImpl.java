package com.example.veterinaria.Service.ServiceImpl;

import com.example.veterinaria.Entity.Propietario;
import com.example.veterinaria.Repository.PropietarioRepository;
import com.example.veterinaria.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarPorId(Long id) {
        return propietarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Propietario no encontrado"));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {
        Propietario existente = buscarPorId(id);
        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());
        return propietarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!propietarioRepository.existsById(id)) {
            throw new RuntimeException("Propietario no existe");
        }
        propietarioRepository.deleteById(id);
    }
}
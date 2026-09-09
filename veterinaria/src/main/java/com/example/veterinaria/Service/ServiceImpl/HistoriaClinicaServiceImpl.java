package com.example.veterinaria.Service.ServiceImpl;



import com.example.veterinaria.Entity.HistoriaClinica;
import com.example.veterinaria.Entity.Mascota;
import com.example.veterinaria.Repository.HistoriaClinicaRepository;
import com.example.veterinaria.Repository.MascotaRepository;
import com.example.veterinaria.Service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    public List<HistoriaClinica> listarTodos() {
        return historiaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarPorId(long id) {
        return historiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Historia Clínica no encontrada"));
    }

    @Override
    public HistoriaClinica crear(HistoriaClinica historia, long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        historia.setMascota(mascota);
        return historiaRepository.save(historia);
    }

    @Override
    public HistoriaClinica actualizar(long id, HistoriaClinica historia) {
        HistoriaClinica existente = buscarPorId(id);
        existente.setFechadeApertura(historia.getFechadeApertura());
        existente.setAntecedentes(historia.getAntecedentes());
        existente.setObservaciones(historia.getObservaciones());
        return historiaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!historiaRepository.existsById(id)) {
            throw new RuntimeException("Historia Clínica no existe");
        }
        historiaRepository.deleteById(id);
    }
}
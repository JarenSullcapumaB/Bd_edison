package SafeZone.SafeZoneBackend.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeZone.SafeZoneBackend.persistence.crud.EvidenciasCrudRepository;
import SafeZone.SafeZoneBackend.persistence.entity.Evidencias;

@Service
public class EvidenciaService {

    @Autowired
    private EvidenciasCrudRepository evidenciasCrudRepository;

    public List<Evidencias> listar() {
        return StreamSupport.stream(evidenciasCrudRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Evidencias guardar(Evidencias evidencia) {
        return evidenciasCrudRepository.save(evidencia);
    }

    public void eliminar(String id) {
        evidenciasCrudRepository.deleteById(id);
    }
}

package SafeZone.SafeZoneBackend.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeZone.SafeZoneBackend.domain.Repository.RegionesRepository;
import SafeZone.SafeZoneBackend.persistence.entity.Regiones;


@Service
public class RegionesService {
    @Autowired
    private RegionesRepository regionesRepository;

    public List<Regiones> listarTodas() {
        return regionesRepository.listarTodas();
    }

    public Regiones crear(Regiones region) {
        return regionesRepository.guardar(region);
    }

    public Regiones buscarPorId(String id) {
        return regionesRepository.buscarPorId(id).orElse(null);
    }
}

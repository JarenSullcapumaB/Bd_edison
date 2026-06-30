package SafeZone.SafeZoneBackend.domain.service;

import SafeZone.SafeZoneBackend.persistence.crud.SeguimientosCrudRepository;
import SafeZone.SafeZoneBackend.persistence.entity.Seguimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeguimientosService {

    @Autowired
    private SeguimientosCrudRepository seguimientosCrudRepository;

    public List<Seguimientos> listar() {
        return StreamSupport.stream(seguimientosCrudRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Seguimientos> buscarPorId(String id) {
        return seguimientosCrudRepository.findById(id);
    }

    public Seguimientos guardar(Seguimientos seguimiento) {
        return seguimientosCrudRepository.save(seguimiento);
    }

    public void eliminar(String id) {
        seguimientosCrudRepository.deleteById(id);
    }
}

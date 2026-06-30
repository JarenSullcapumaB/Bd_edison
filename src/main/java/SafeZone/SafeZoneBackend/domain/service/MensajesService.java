package SafeZone.SafeZoneBackend.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeZone.SafeZoneBackend.persistence.crud.MensajesCrudRepository;
import SafeZone.SafeZoneBackend.persistence.entity.Mensajes;

@Service
public class MensajesService {

    @Autowired
    private MensajesCrudRepository mensajesCrudRepository;

    public List<Mensajes> listar() {
        return StreamSupport.stream(mensajesCrudRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Mensajes> buscarPorId(String id) {
        return mensajesCrudRepository.findById(id);
    }

    public Mensajes guardar(Mensajes mensaje) {
        return mensajesCrudRepository.save(mensaje);
    }

    public void eliminar(String id) {
        mensajesCrudRepository.deleteById(id);
    }
}

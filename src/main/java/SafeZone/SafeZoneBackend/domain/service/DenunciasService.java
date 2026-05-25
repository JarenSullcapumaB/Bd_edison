package SafeZone.SafeZoneBackend.domain.service;

import SafeZone.SafeZoneBackend.domain.Repository.DenunciasRepository;
import SafeZone.SafeZoneBackend.domain.Repository.RegionesRepository;
import SafeZone.SafeZoneBackend.domain.Repository.UsuariosRepository;
import SafeZone.SafeZoneBackend.domain.dto.DenunciaRequest;
import SafeZone.SafeZoneBackend.persistence.entity.Denuncias;
import SafeZone.SafeZoneBackend.persistence.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DenunciasService {

  @Autowired
  public DenunciasRepository denunciasRepository;
  @Autowired
  private UsuariosRepository usuariosRepository;
    public List<Denuncias> listarTodas() {
        return denunciasRepository.listar();
    }

    public List<Denuncias> buscarPorVictimaId(String victimId) {
        return denunciasRepository.buscarporusuarioId(victimId);
    }
    public Optional<Denuncias> buscarPorUsuarioId(String id) {
        return denunciasRepository.buscarPorId(id);
    }
    public Denuncias crearDenuncia(DenunciaRequest request, String victimId) {
        Denuncias denuncia = new Denuncias();

        Usuarios usuarios = usuariosRepository.buscarUsuarioPorEmail(victimId);

        denuncia.setId(UUID.randomUUID().toString());
        denuncia.setUsuarioid(usuarios.getId());
        denuncia.setVictimaId(usuarios.getEmail());
        denuncia.setTitulo(request.getTitulo());
        denuncia.setDescripcion(request.getDescripcion());
        denuncia.setTipoViolencia(request.getTipoViolencia());
        denuncia.setNivelRiesgo(request.getNivelRiesgo());
        denuncia.setEstado(request.getEstado() != null ? request.getEstado() : "PENDIENTE");
        denuncia.setDireccion(request.getDireccion());
        denuncia.setFechaDenuncia(denuncia.getFechaDenuncia());
        return denunciasRepository.guardar(denuncia);
    }

    public Denuncias actualizar(String id, DenunciaRequest request) {
        Denuncias existente = denunciasRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Denuncia no encontrada: " + id));

        existente.setTitulo(request.getTitulo());
        existente.setDescripcion(request.getDescripcion());
        existente.setTipoViolencia(request.getTipoViolencia());
        existente.setNivelRiesgo(request.getNivelRiesgo());
        existente.setEstado(request.getEstado());

        return denunciasRepository.guardar(existente);
    }




  public void eliminar(Denuncias denuncias) {
    // RF-02 REGISTRAR INFORMACIÓN DE VIOLENCIA
    public Denuncias registrarViolencia(String denunciaId, ViolenciaRequest request) {

        Denuncias denuncia = denunciasRepository.buscarPorId(denunciaId)
                .orElseThrow(() -> new RuntimeException("Denuncia no encontrada"));

        denuncia.setTipoViolencia(request.getTipoViolencia());
        denuncia.setDescripcion(request.getDescripcion());
        denuncia.setNivelRiesgo(request.getNivelRiesgo());
        denuncia.setDireccion(request.getDireccion());

        return denunciasRepository.guardar(denuncia);
    }

    // ELIMINAR
    public void eliminar(Denuncias denuncias) {
        denunciasRepository.eliminar(denuncias);
    }







}

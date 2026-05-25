// domain/dto/ReportResponse.java
package SafeZone.SafeZoneBackend.domain.dto;

import SafeZone.SafeZoneBackend.persistence.entity.Denuncias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaRespoonse {

    private String id;
    private String usuarioid;
    private String victimaid;
    private String titulo;
    private String descripcion;
    private String tipoViolencia;
    private String nivelRiesgo;
    private String estado;
    private String direccion;
    private String fechaDenuncia;

    public static DenunciaRespoonse from(Denuncias d) {
        DenunciaRespoonse r = new DenunciaRespoonse();
        r.setId(d.getId());
        r.setUsuarioid(d.getUsuarioid());
        r.setVictimaid(d.getVictimaId());
        r.setTitulo(d.getTitulo());
        r.setDescripcion(d.getDescripcion());
        r.setTipoViolencia(d.getTipoViolencia());
        r.setNivelRiesgo(d.getNivelRiesgo());
        r.setEstado(d.getEstado());
        r.setDireccion(d.getDireccion());
        r.setFechaDenuncia(d.getFechaDenuncia() != null
                ? d.getFechaDenuncia().toString() : null);
        return r;
    }

}
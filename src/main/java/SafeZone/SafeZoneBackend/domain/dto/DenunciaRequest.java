package SafeZone.SafeZoneBackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaRequest {

    private String titulo;


    private String descripcion;


    private String tipoViolencia;


    // VIOLENCIAFISICA, ABUSOPSICOLOGICO, OTRO
    private String nivelRiesgo;

    // ALTO, MEDIO, BAJO

    private String estado;

    // PENDIENTE, EN_ESPERA, EN_PROCESO, RESUELTO
    private String direccion;
}
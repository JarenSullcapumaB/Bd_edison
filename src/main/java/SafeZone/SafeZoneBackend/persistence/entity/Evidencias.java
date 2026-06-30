package SafeZone.SafeZoneBackend.persistence.entity;


import java.time.Instant;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Container(containerName ="evidencias")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Evidencias {
    @Id
    private String id;
    @PartitionKey
    private String denunciaid;
    private String urlStorage;
    private String tipoArchivo;
    private Instant fechaCarga;






}

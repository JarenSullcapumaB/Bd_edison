package SafeZone.SafeZoneBackend.persistence.crud;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import SafeZone.SafeZoneBackend.persistence.entity.Seguimientos;

public interface SeguimientosCrudRepository extends CosmosRepository<Seguimientos, String> {
}
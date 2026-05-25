package SafeZone.SafeZoneBackend.persistence.crud;

import SafeZone.SafeZoneBackend.persistence.entity.Denuncias;
import SafeZone.SafeZoneBackend.persistence.entity.Usuarios;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DenunciasCrudRepository extends CosmosRepository<Denuncias,String> {
    // Usar @Query explícito para buscar por partition key
        @Query("SELECT * FROM c WHERE c.usuarioid = @usuarioid")
        List<Denuncias> findByUsuarioid(@Param("usuarioid") String usuarioid);

    @Override
    List<Denuncias> findAll();
}

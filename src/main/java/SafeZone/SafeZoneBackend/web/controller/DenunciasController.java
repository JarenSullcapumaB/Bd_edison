package SafeZone.SafeZoneBackend.web.controller;

import SafeZone.SafeZoneBackend.domain.dto.DenunciaRequest;
import SafeZone.SafeZoneBackend.domain.service.DenunciasService;
import SafeZone.SafeZoneBackend.persistence.entity.Denuncias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class DenunciasController {

@Autowired
public DenunciasService denunciasService;

    // GET /api/reports?victimId=1
    @GetMapping
    public ResponseEntity<List<DenunciaRespoonse>> listar(
            @RequestParam(required = false) String victimId) {

        System.out.println(">>> victimId recibido: " + victimId);
        List<Denuncias> denuncias = victimId != null
                ? denunciasService.buscarPorVictimaId(victimId)  // devuelve List
                : denunciasService.listarTodas();
        System.out.println(">>> total encontradas: " + denuncias.size());
        List<DenunciaRespoonse> response = denuncias.stream()
                .map(DenunciaRespoonse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    // GET /api/reports/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DenunciaRespoonse> obtenerPorId(@PathVariable String id) {
        return denunciasService.buscarPorUsuarioId(id)
                .map(d -> ResponseEntity.ok(DenunciaRespoonse.from(d)))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/reports
    @PostMapping
    @PreAuthorize("hasRole('VICTIM')")
    public ResponseEntity<DenunciaRespoonse> crear(
            @Valid @RequestBody DenunciaRequest request,
            @AuthenticationPrincipal String victimId) {

        Denuncias nueva = denunciasService.crearDenuncia(request, victimId);
        return ResponseEntity.status(HttpStatus.CREATED).body(DenunciaRespoonse.from(nueva));
    }

    // RF-02 REGISTRAR INFORMACIÓN DE VIOLENCIA
    @PutMapping("/violencia/{id}")
    public Denuncias registrarViolencia(
            @PathVariable String id,
            @RequestBody ViolenciaRequest request) {

        return denunciasService.registrarViolencia(id, request);
    }

    // RF-09 ASIGNAR CASO
    @PatchMapping("/{id}/asignar")
    public Denuncias asignarCaso(
            @PathVariable String id,
            @RequestBody AsignacionCasoRequest request
    ) {
        return denunciasService.asignarCaso(id, request);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Denuncias denuncias) {
        denunciasService.eliminar(denuncias);
    }
}
















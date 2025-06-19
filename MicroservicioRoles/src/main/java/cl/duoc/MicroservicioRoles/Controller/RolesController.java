package cl.duoc.MicroservicioRoles.Controller;

import cl.duoc.MicroservicioRoles.Model.Rol;
import cl.duoc.MicroservicioRoles.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {

    @Autowired
    private RolService rolService;

    // Obtener todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> listarTodosLosRoles() {
        List<Rol> roles = rolService.obtenerTodos();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    // Obtener un rol por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRolPorId(@PathVariable Long id) {
        try {
            Rol rol = rolService.obtenerPorId(id);
            return ResponseEntity.ok(rol);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Rol> crearNuevoRol(@RequestBody Rol nuevoRol) {
        Rol rolGuardado = rolService.guardar(nuevoRol);
        return ResponseEntity.ok(rolGuardado);
    }

    // Eliminar un rol por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRolPorId(@PathVariable Long id) {
        try {
            rolService.eliminar(id);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el rol con ID: " + id);
        }
    }
}
package cl.duoc.MicroservicioRoles.Repository;

import cl.duoc.MicroservicioRoles.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    
}
package cl.duoc.MicroservicioRoles.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Long idRol;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
}


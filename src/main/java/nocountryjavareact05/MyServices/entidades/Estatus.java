package nocountryjavareact05.MyServices.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "estatus")
public class Estatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "estatus",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<contratacion> contratacion;
}

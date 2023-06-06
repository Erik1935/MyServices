package nocountryjavareact05.MyServices.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Getter
@Setter
@Table(name = "contrataciones")
public class contratacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Services services;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn (name = "estatus_id",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Estatus estatus;
    @NumberFormat(pattern = "###,###,##0.00")
    private float price;

}

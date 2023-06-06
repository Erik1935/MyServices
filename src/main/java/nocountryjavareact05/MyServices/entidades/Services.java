package nocountryjavareact05.MyServices.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "service")
public class Services implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4, max = 50)
    private String name;
    @Size(max = 255)
    private String description;
    //Relacion bidireccional con category
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn (name = "category_id",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
    @ManyToMany(mappedBy = "servicio",fetch=FetchType.EAGER)
    private List<User> usuario_id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn (name = "user_id",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn (name = "experto_id",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Expert experto;
    private int activo;

}

package nocountryjavareact05.MyServices.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "expert")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @NotNull
    @Size(min = 4, max = 50)
    private String email;
    @NotNull
    @Size(min = 6, max = 100)
    private String password;
    private String profesion;
    private String pais;
    private String provincia;
    private String localidad;
   @OneToOne
    @JoinColumn(name="user_id")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
   @OneToMany(fetch = FetchType.EAGER,mappedBy = "experto",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Services> services;

}

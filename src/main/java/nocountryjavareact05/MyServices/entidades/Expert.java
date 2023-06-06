package nocountryjavareact05.MyServices.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "expert")
@AllArgsConstructor
@NoArgsConstructor
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
    private String photo;
    private String profesion;
    private String pais;
    private String provincia;
    private String localidad;
   @OneToMany(fetch = FetchType.EAGER,mappedBy = "experto",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Services> services;

}

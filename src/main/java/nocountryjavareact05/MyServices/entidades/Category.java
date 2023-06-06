package nocountryjavareact05.MyServices.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4, max = 50)
    private String name;
    @Size(max = 255)
    private String description;
    private String image;
    //Relacion bidireccional con services
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Services> services;
}

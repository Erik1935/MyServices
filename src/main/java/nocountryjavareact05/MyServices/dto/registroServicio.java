package nocountryjavareact05.MyServices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.User;

import java.util.List;

@Getter
@Setter
public class registroServicio {
    @NotNull
    @Size(min = 4, max = 50)
    private String name;
    @Size(max = 255)
    private String description;
    private int category;
    private int usuario;
    private int experto;
}

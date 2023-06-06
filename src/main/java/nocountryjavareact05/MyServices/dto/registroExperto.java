package nocountryjavareact05.MyServices.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class registroExperto {

    @NotNull
    @Size(min = 6, max = 100)
    private String name;
    @NotNull
    @Size(min = 6, max = 100)
    private String lastname;
    @NotNull
    @Size(min = 4, max = 50)
    private String email;
    @NotNull
    @Size(min = 6, max = 100)
    private String password;
    private String photo;
    @NotNull
    @Size(min = 4, max = 100)
    private String profesion;
    @NotNull
    @Size(max = 100)
    private String pais;
    @NotNull
    @Size(max = 100)
    private String provincia;
    @NotNull
    @Size(max = 100)
    private String localidad;
}

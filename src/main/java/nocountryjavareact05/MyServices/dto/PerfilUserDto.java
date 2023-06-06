package nocountryjavareact05.MyServices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUserDto {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String pais;
    private String provincia;
    private String localidad;
}

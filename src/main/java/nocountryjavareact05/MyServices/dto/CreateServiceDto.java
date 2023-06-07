package nocountryjavareact05.MyServices.dto;


import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateServiceDto {
    private String titulo;
    @Size(max = 255)
    private String descripcion;
    //Relacion bidireccional con category
    private int categoria;
    private int id;

}

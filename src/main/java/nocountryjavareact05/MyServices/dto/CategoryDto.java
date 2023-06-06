package nocountryjavareact05.MyServices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String titulo;
    private String imagen;
    private String descripcion;
    private List<?> profesionales;
}

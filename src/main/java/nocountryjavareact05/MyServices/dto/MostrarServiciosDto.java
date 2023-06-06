package nocountryjavareact05.MyServices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MostrarServiciosDto {
    private Long id;
    private Long servicio;
    private String titulo;
    private String descripcion;
}

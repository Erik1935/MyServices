package nocountryjavareact05.MyServices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String error;
    private String status;
    private String details;
}

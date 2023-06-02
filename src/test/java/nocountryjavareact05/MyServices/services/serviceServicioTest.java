package nocountryjavareact05.MyServices.services;

import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class serviceServicioTest {
@Autowired
private serviceServicio servicio;
    @Test
    void getAllUsers() {
        for(Expert expert:servicio.findExperts(1L)){
            System.out.println("expert.getName() = " + expert.getName());
            System.out.println("expert.getId() = " + expert.getId());
        }
    }

}
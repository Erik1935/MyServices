package nocountryjavareact05.MyServices.controllers;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.services.ServiceService;
import nocountryjavareact05.MyServices.services.serviceServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/servicios")
@RestController
@AllArgsConstructor
public class ServiceController {
    private final ServiceService service;
    private final serviceServicio servicio;
    @GetMapping("/services")
    public List<Services> findAll(){
        return service.findAll();
    }
    @GetMapping("/service/{id}")
    public Services findById(@PathVariable int id){
        return service.findById(Long.valueOf(id));
    }
    @GetMapping("/experts/{id}")
    public List<Expert> getExperts(@PathVariable int id){
        return servicio.findExperts(Long.valueOf(id));
    }

}

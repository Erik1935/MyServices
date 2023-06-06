package nocountryjavareact05.MyServices.controllers;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.dto.CreateServiceDto;
import nocountryjavareact05.MyServices.dto.ExpertoDto;
import nocountryjavareact05.MyServices.dto.MostrarServiciosDto;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.services.ServiceService;
import nocountryjavareact05.MyServices.services.serviceServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public List<ExpertoDto> getExperts(@PathVariable int id){
        return servicio.findExperts(Long.valueOf(id));
    }
    @GetMapping("/services/users")
    public ResponseEntity<List<MostrarServiciosDto>>serviciosDeTodosLosUsuarios(){
        return new ResponseEntity<List<MostrarServiciosDto>>(servicio.mostrarServiciosDeTodosLosUsuarios(), HttpStatus.OK);
    }
    /*@GetMapping("/services/user/{id}")
    public ResponseEntity<List<MostrarServiciosDto>>serviciosDeUnUsuario(@PathVariable int id){
        return new ResponseEntity<List<MostrarServiciosDto>>(servicio.mostrarServiciosDeUsuario(Long.valueOf(id)), HttpStatus.OK);
    }*/
    @GetMapping("/services/experts")
    public ResponseEntity<List<MostrarServiciosDto>>serviciosDeTodosLosExpertos(){
        return new ResponseEntity<List<MostrarServiciosDto>>(servicio.mostrarServiciosDeExpertos(), HttpStatus.OK);
    }
    @PostMapping("/user/service")
    public ResponseEntity<Succes>crearServicioUsuario(@RequestBody CreateServiceDto serviceDto){
        return new ResponseEntity<Succes>(servicio.createUserService(serviceDto),HttpStatus.OK);
    }
    @PostMapping("expert/service")
    public ResponseEntity<Succes>crearServicioExperto(@RequestBody CreateServiceDto serviceDto){
        return new ResponseEntity<Succes>(servicio.createExpertService(serviceDto),HttpStatus.OK);
    }



}

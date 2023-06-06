package nocountryjavareact05.MyServices.controllers;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.dto.PerfilUserDto;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/user/{id}")
    public ResponseEntity<PerfilUserDto>perfilUser(@RequestParam int id){
        return new ResponseEntity<PerfilUserDto>(userService.perfilUser(Long.valueOf(id)), HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<Succes>editUser(@RequestBody PerfilUserDto perfilUserDto){
        return new ResponseEntity<Succes>(userService.editarDatosUser(perfilUserDto),HttpStatus.OK);
    }
}

package nocountryjavareact05.MyServices.services;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.dto.PerfilUserDto;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public List<User> findAll(){
        return userRepository.findAll();//Pendiente de mapear
        //No es necesario incluir el registro de usuarios ya que se encuentra en security
    }
    public PerfilUserDto perfilUser(Long id){
        User user = userRepository.findById(id).get();
        PerfilUserDto perfilUserDto = new PerfilUserDto();
        perfilUserDto.setId(user.getId());
        perfilUserDto.setName(user.getName());
        perfilUserDto.setLastname(user.getLastname());
        perfilUserDto.setEmail(user.getEmail());
        perfilUserDto.setPassword("");
        perfilUserDto.setPais(user.getPais());
        perfilUserDto.setLocalidad(user.getLocalidad());
        perfilUserDto.setProvincia(user.getProvincia());
        return perfilUserDto;
    }
    public Succes editarDatosUser(PerfilUserDto perfilUserDto){
        User user = userRepository.findById(perfilUserDto.getId()).get();
        user.setName(perfilUserDto.getName());
        user.setLastname(perfilUserDto.getLastname());
        user.setPassword(passwordEncoder.encode(perfilUserDto.getPassword()));
        user.setEmail(perfilUserDto.getEmail());
        user.setPais(perfilUserDto.getPais());
        user.setProvincia(perfilUserDto.getProvincia());
        user.setLocalidad(perfilUserDto.getLocalidad());
        userRepository.save(user);
        return new Succes("Cambios guardados exitosamente");
    }

}

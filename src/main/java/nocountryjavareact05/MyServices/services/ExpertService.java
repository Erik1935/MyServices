package nocountryjavareact05.MyServices.services;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.dto.registroExperto;
import nocountryjavareact05.MyServices.dto.registroServicio;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.CategoryRepository;
import nocountryjavareact05.MyServices.repositories.RepositoryExpert;
import nocountryjavareact05.MyServices.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpertService {
    private final UserRepository userRepository;
    private final RepositoryExpert repositoryExpert;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;
    public List<Expert>findAll(){
        return repositoryExpert.findAll();//Pendiente de mapear
    }

    public Succes registerExpert(registroExperto registro){
        //añadir error si el registroExperto es nulo o vacio
        var userExpert = Expert.builder()
                .email(registro.getEmail())
                .name(registro.getName())
                .lastname(registro.getLastname())
                .localidad(registro.getLocalidad())
                .password(passwordEncoder.encode(registro.getPassword()))
                .pais(registro.getPais())
                .provincia(registro.getProvincia())
                .profesion(registro.getProfesion())
                .photo(registro.getPhoto())
                .build();
        repositoryExpert.save(userExpert);
        return new Succes("Registro exitoso");
    }
    public Succes generarNuevoServicio(registroServicio registro){
        var servicio = Services.builder()
                .name(registro.getName())
                .description(registro.getDescription())
                .category(getCategory(registro.getCategory()))
                .usuario_id(getUser(registro.getUsuario()))
                .experto(getExpert(registro.getExperto()))
                .activo(1)
                .build();
        return new Succes("Servicio creado exitosamente");
    }
    private Category getCategory(int id){
        //Asignar un error si el resultado es null
        return categoryRepository.findById(Long.valueOf(id)).get();
    }
    private Expert getExpert(int id){
        //Asignar un error si el resultado es null
        return repositoryExpert.findById(Long.valueOf(id)).get();
    }
    private List<User> getUser(int id){
        //Asignar un error si el resultado es null
        List<User> user = new ArrayList<>();
        user.add(userRepository.findById(Long.valueOf(id)).get());
        return user;
    }
}

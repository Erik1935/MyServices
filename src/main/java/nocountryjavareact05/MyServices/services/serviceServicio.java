package nocountryjavareact05.MyServices.services;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.dto.CreateServiceDto;
import nocountryjavareact05.MyServices.dto.ExpertoDto;
import nocountryjavareact05.MyServices.dto.MostrarServiciosDto;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.ServiceRepository;
import nocountryjavareact05.MyServices.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class serviceServicio {
    private final ServiceRepository service;
    private final UserRepository userRepository;
   //No utilizar
    public List<ExpertoDto> findExperts(Long id){
        List<ExpertoDto> listExpertoDtos = new ArrayList<>();
        for(Expert expert:service.findExpertByCategoryId(id)){
            ExpertoDto expertoDto = new ExpertoDto();
            expertoDto.setId(expert.getId());
            expertoDto.setName(expert.getName());
            expertoDto.setPhoto(expert.getPhoto());
            expertoDto.setScore(4.5);
            listExpertoDtos.add(expertoDto);
        }
        return listExpertoDtos;
    }

    /*public List<MostrarServiciosDto>mostrarServiciosDeUsuario(Long id){
        List<MostrarServiciosDto>serviciosDtos = new ArrayList<>();
        for(Services services:service.findByUserId(id)){
            MostrarServiciosDto mostrarServiciosDto = new MostrarServiciosDto();
            for(User user:services.getUsuario_id()){
                mostrarServiciosDto.setId(user.getId());
            }
            mostrarServiciosDto.setServicio(services.getId());
            mostrarServiciosDto.setTitulo(services.getName());
            mostrarServiciosDto.setDescripcion(services.getDescription());
            serviciosDtos.add(mostrarServiciosDto);
        }
        return serviciosDtos;
    }*/
    public List<MostrarServiciosDto>mostrarServiciosDeTodosLosUsuarios(){
        List<MostrarServiciosDto>serviciosDtos = new ArrayList<>();
        for(Services services:service.findServicesOfUser()){
            MostrarServiciosDto mostrarServiciosDto = new MostrarServiciosDto();
            User user = services.getUser();
           mostrarServiciosDto.setId(user.getId());
            mostrarServiciosDto.setServicio(services.getId());
            mostrarServiciosDto.setTitulo(services.getName());
            mostrarServiciosDto.setDescripcion(services.getDescription());
            serviciosDtos.add(mostrarServiciosDto);
        }
        return serviciosDtos;
    }
    public List<MostrarServiciosDto>mostrarServiciosDeExpertos(){
        List<MostrarServiciosDto>serviciosDtos = new ArrayList<>();
        for(Services services:service.findServicesOfExperts()){
            MostrarServiciosDto mostrarServiciosDto = new MostrarServiciosDto();
            Expert expert = new Expert();
            expert.setId(services.getExperto().getId());
                mostrarServiciosDto.setServicio(services.getId());
                mostrarServiciosDto.setId(expert.getId());
                mostrarServiciosDto.setTitulo(services.getName());
                mostrarServiciosDto.setDescripcion(services.getDescription());
                serviciosDtos.add(mostrarServiciosDto);
        }
        return serviciosDtos;
    }
    public List<ExpertoDto> findExpertsByCategory(Long id){
        List<ExpertoDto>expertoDtos = new ArrayList<>();
        for(Expert expert:service.findExpertByCategoryId(id)){
            ExpertoDto expertoDto = new ExpertoDto();
            expertoDto.setId(expert.getId());
            expertoDto.setName(expert.getName());
            expertoDto.setPhoto(expert.getPhoto());
            expertoDto.setScore(4.5);
            expertoDtos.add(expertoDto);
        }
        return expertoDtos;
    }
    public Succes createExpertService(CreateServiceDto serviceDto){
        Services services = new Services();
        Category category = new Category();
        User user = new User();
        services.setName(serviceDto.getTitulo());
        services.setDescription(serviceDto.getDescripcion());
        //Category
        category.setId(Long.valueOf(serviceDto.getCategoria()));
        services.setCategory(category);
        //User
        user.setId(1L);
       services.setUser(user);
        //Experto
        Expert experto = new Expert();
        experto.setId(Long.valueOf(serviceDto.getId()));
        services.setExperto(experto);
        services.setActivo(1);
        service.save(services);
        return new Succes("Servicio generado exitosamente");
    }
    public Succes createUserService(CreateServiceDto serviceDto){
        Services services = new Services();
        Category category = new Category();
       User user = new User();
        services.setName(serviceDto.getTitulo());
        services.setDescription(serviceDto.getDescripcion());
        //Category
        category.setId(Long.valueOf(serviceDto.getCategoria()));
        services.setCategory(category);
        //User
        //user.setId(serviceDto.getId());
        user.setId(Long.valueOf(serviceDto.getId()));
        services.setUser(user);
        //Experto
        Expert experto = new Expert();
        experto.setId(1L);
        services.setExperto(experto);
        services.setActivo(1);
        service.save(services);
        return new Succes("Servicio generado exitosamente");
    }

    //Generar metodo para crear servicios de un experto
    //Generar metodo para crear servicios de un usuario

}

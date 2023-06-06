package nocountryjavareact05.MyServices.datosPrecargados;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.dto.CreateServiceDto;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.entidades.Estatus;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.repositories.CategoryRepository;
import nocountryjavareact05.MyServices.repositories.EstatusRepository;
import nocountryjavareact05.MyServices.repositories.RepositoryExpert;
import nocountryjavareact05.MyServices.security.auth.AuthenticationService;
import nocountryjavareact05.MyServices.security.auth.RegisterRequest;
import nocountryjavareact05.MyServices.services.serviceServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class Datos implements CommandLineRunner {
    private String[][] servicios ;
    private String[][] expertos ;
    private final CategoryRepository categoryRepository;
    private final RepositoryExpert repositoryExpert;
    private final AuthenticationService authenticationService;
    private final serviceServicio serviceServicio;
    private final EstatusRepository estatusRepository;

    private void generateContent(){
        servicios = new String[9][3];
        expertos = new String[4][9];
        servicios[0][0]="Construccion";
        servicios[0][1]="../assets/home/construccion.png";
        servicios[0][2]="Aquí puedes encontrar un listado de albañiles para solucionar los problemas de tu hogar";
        servicios[1][0]="Carpinteria";
        servicios[1][1]="../assets/home/carpintero.png";
        servicios[1][2]="Aquí puedes encontrar un listado de carpinteros para solucionar los problemas de tu hogar";
        servicios[2][0]="Electricidad";
        servicios[2][1]="../assets/home/electricista.png";
        servicios[2][2]="Aquí puedes encontrar un listado de electricistas para solucionar los problemas de tu hogar";
        servicios[3][0]="Jardinería";
        servicios[3][1]="../assets/home/jardinero.png";
        servicios[3][2]="Aquí puedes encontrar un listado de jardineros para solucionar los problemas de tu hogar";
        servicios[4][0]="Limpieza";
        servicios[4][1]="../assets/home/limpieza.png";
        servicios[4][2]="Aquí puedes encontrar un listado de personal de limpieza para solucionar los problemas de tu hogar";
        servicios[5][0]="Herrería";
        servicios[5][1]="../assets/home/herrero.png";
        servicios[5][2]="Aquí puedes encontrar un listado de herreros para solucionar los problemas de tu hogar";
        servicios[6][0]="Mudanza";
        servicios[6][1]="../assets/home/mudanza.png";
        servicios[6][2]="Aquí puedes encontrar un listado de personal de mudanzas para solucionar los problemas de tu hogar";
        servicios[7][0]="Pintura";
        servicios[7][1]="../assets/home/pintor.png";
        servicios[7][2]="Aquí puedes encontrar un listado de pintores para solucionar los problemas de tu hogar";
        servicios[8][0]="Plomería";
        servicios[8][1]="../assets/home/plomero.png";
        servicios[8][2]="Aquí puedes encontrar un listado de plomeros para solucionar los problemas de tu hogar";
        //Expertos
        expertos[0][0]="Default";
        expertos[0][1]="";
        expertos[0][2]="prueba00@gmail.com";
        expertos[0][3]="$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW";
        expertos[0][4]="Ingeniero";
        expertos[0][5]="Mexico";
        expertos[0][6]="Mexico";
        expertos[0][7]="Mexico";
        expertos[0][8]="";

        expertos[1][0]="Carlos González";
        expertos[1][1]="Perez";
        expertos[1][2]="prueba1@gmail.com";
        expertos[1][3]="$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW";
        expertos[1][4]="Ingeniero";
        expertos[1][5]="Mexico";
        expertos[1][6]="Mexico";
        expertos[1][7]="Mexico";
        expertos[1][8]="https://randomuser.me/api/portraits/men/1.jpg";

        expertos[2][0]="María López";
        expertos[2][1]="López";
        expertos[2][2]="prueba2@gmail.com";
        expertos[2][3]="$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW";
        expertos[2][4]="Ingeniero";
        expertos[2][5]="Mexico";
        expertos[2][6]="Mexico";
        expertos[2][7]="Mexico";
        expertos[2][8]="https://randomuser.me/api/portraits/women/1.jpg";

        expertos[3][0]="Juan Rodríguez";
        expertos[3][1]="Rodriguez";
        expertos[3][2]="prueba3@gmail.com";
        expertos[3][3]="$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW";
        expertos[3][4]="Ingeniero";
        expertos[3][5]="Mexico";
        expertos[3][6]="Mexico";
        expertos[3][7]="Mexico";
        expertos[3][8]="https://randomuser.me/api/portraits/men/2.jpg";




    }
    public void generateDatos(){
        generateContent();
        List<Category> categorias = new ArrayList<>();
        for (int i = 0; i < servicios.length; i++) {
            Category category = new Category();
            category.setName(servicios[i][0]);
            category.setImage(servicios[i][1]);
            category.setDescription(servicios[i][2]);
            categorias.add(category);
        }

        categoryRepository.saveAll(categorias);
    }
    private void generateExpertos(){
    List<Expert> experts = new ArrayList<>();
    for (int i = 0; i < expertos.length; i++) {
            Expert expert = new Expert();
            expert.setName(expertos[i][0]);
            expert.setLastname(expertos[i][1]);
        expert.setEmail(expertos[i][2]);
        expert.setPassword(expertos[i][3]);
        expert.setProfesion(expertos[i][4]);
        expert.setPais(expertos[i][5]);
        expert.setLocalidad(expertos[i][6]);
        expert.setProvincia(expertos[i][7]);
        expert.setPhoto(expertos[i][8]);
        experts.add(expert);
        }
    repositoryExpert.saveAll(experts);
    }
    private void generateUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName("Default");
        registerRequest.setLastname("some");
        registerRequest.setEmail("some");
        registerRequest.setPassword("some");
        registerRequest.setPais("Some");
        registerRequest.setLocalidad("some");
        registerRequest.setProvincia("Some");
        authenticationService.register(registerRequest);
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setName("Ricardo Tapia");
        registerRequest1.setLastname("Grayson");
        registerRequest1.setEmail("email123@hotmailc.com");
        registerRequest1.setPassword("$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW");
        registerRequest1.setPais("Mexico");
        registerRequest1.setLocalidad("Mexico");
        registerRequest1.setProvincia("Mexico");
        authenticationService.register(registerRequest1);
        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setName("Ricardo Perez");
        registerRequest2.setLastname("Lopez");
        registerRequest2.setEmail("email1234@hotmail.com");
        registerRequest2.setPassword("$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW");
        registerRequest2.setPais("Mexico");
        registerRequest2.setLocalidad("Mexico");
        registerRequest2.setProvincia("Mexico");
        authenticationService.register(registerRequest2);
        RegisterRequest registerRequest3 = new RegisterRequest();
        registerRequest3.setName("Marcos Roble");
        registerRequest3.setLastname("Benitez");
        registerRequest3.setEmail("email12345@hotmail.com");
        registerRequest3.setPassword("$2a$10$g.ss/qWtr3Fi9pRuIhILJ./6769FpozMENhdTwumFbdcjZy7wzHbW");
        registerRequest3.setPais("Mexico");
        registerRequest3.setLocalidad("Mexico");
        registerRequest3.setProvincia("Mexico");
        authenticationService.register(registerRequest3);

    }
    private void generateEstatus(){
        List<Estatus> estatusList = new ArrayList<>();
        Estatus estatus = new Estatus();
        estatus.setNombre("Pendiente");
        Estatus estatus1 = new Estatus();
        estatus1.setNombre("En proceso");
        Estatus estatus2 = new Estatus();
        estatus2.setNombre("Finalizado");
        Estatus estatus3 = new Estatus();
        estatus3.setNombre("Cancelado");
        estatusList.add(estatus);
        estatusList.add(estatus1);
        estatusList.add(estatus2);
        estatusList.add(estatus3);
        estatusRepository.saveAll(estatusList);

    }
    private void generateServices(){
        CreateServiceDto createServiceDto = new CreateServiceDto();
        createServiceDto.setTitulo("Servicio de construccion ");
        createServiceDto.setDescripcion("Se hacen planos y presupuestos, pregunte sin compromiso");
        createServiceDto.setCategoria(1L);
        createServiceDto.setId(2L);
        serviceServicio.createExpertService(createServiceDto);
        CreateServiceDto createServiceDto1 = new CreateServiceDto();
        createServiceDto1.setTitulo("Levantamiento de barda");
        createServiceDto1.setDescripcion("Requiero de un profesional para realizar el trabajo");
        createServiceDto1.setCategoria(1L);
        createServiceDto1.setId(2L);
        serviceServicio.createUserService(createServiceDto1);
        CreateServiceDto createServiceDto2 = new CreateServiceDto();
        createServiceDto2.setTitulo("Construccion");
        createServiceDto2.setDescripcion("Se hacen planos y presupuestos, pregunte sin compromiso");
        createServiceDto2.setCategoria(1L);
        createServiceDto2.setId(3L);
        serviceServicio.createExpertService(createServiceDto2);
        CreateServiceDto createServiceDto3 = new CreateServiceDto();
        createServiceDto3.setTitulo("Trabajos de carpinteria profesional");
        createServiceDto3.setDescripcion("Carpinteria en general");
        createServiceDto3.setCategoria(2L);
        createServiceDto3.setId(3L);
        serviceServicio.createExpertService(createServiceDto3);

    }

    @Override
    public void run(String... args) throws Exception {
        generateDatos();
        generateExpertos();
        generateUsers();
        generateEstatus();
        generateServices();
    }

    /*
    {
				id: 1,
				name: 'Carlos González',
				photo: 'https://randomuser.me/api/portraits/men/1.jpg',
				jobs: ['Plomero', 'Electricista'],
				score: '4,8',
			},
			{
				id: 2,
				name: 'María López',
				photo: 'https://randomuser.me/api/portraits/women/1.jpg',
				jobs: ['Carpintera', 'Pintora'],
				score: '4,5',
			},
			{
				id: 3,
				name: 'Juan Rodríguez',
				photo: 'https://randomuser.me/api/portraits/men/2.jpg',
				jobs: ['Albañil', 'Fontanero'],
				score: '4,2',
			},
			{
				id: 4,
				name: 'Ana Martínez',
				photo: 'https://randomuser.me/api/portraits/women/2.jpg',
				jobs: ['Mecánica', 'Jardinera'],
				score: '4,9',
			},
			{
				id: 5,
				name: 'Javier Torres',
				photo: 'https://randomuser.me/api/portraits/men/3.jpg',
				jobs: ['Gasista', 'Pintor'],
				score: '4,6',
			},
			{
				id: 6,
				name: 'Laura Sánchez',
				photo: 'https://randomuser.me/api/portraits/women/3.jpg',
				jobs: ['Cerrajera', 'Electricista'],
				score: '4,7',
			},
			{
				id: 7,
				name: 'Miguel Ramírez',
				photo: 'https://randomuser.me/api/portraits/men/4.jpg',
				jobs: ['Carpintero', 'Albañil'],
				score: '4,4',
			},
			{
				id: 8,
				name: 'Isabel García',
				photo: 'https://randomuser.me/api/portraits/women/4.jpg',
				jobs: ['Plomera', 'Jardinera'],
				score: '4,3',
			},
    */
}

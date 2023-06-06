package nocountryjavareact05.MyServices.services;


import nocountryjavareact05.MyServices.entidades.Services;

import java.util.List;


public interface ServiceService {

    List<Services> findAll();
    Services findById(Long id);
    Services findByName(String name);


}

package nocountryjavareact05.MyServices.services;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.repositories.ServiceRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService{

    private ServiceRepository serviceRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Services findById(Long id) {
        return serviceRepository.findById(id).orElseThrow();
    }

    @Override
    public Services findByName(String name) {
        return serviceRepository.findByName(name).orElseThrow();
    }


}

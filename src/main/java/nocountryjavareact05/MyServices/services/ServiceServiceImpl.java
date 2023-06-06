package nocountryjavareact05.MyServices.services;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.repositories.ServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
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

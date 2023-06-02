package nocountryjavareact05.MyServices.services;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.ServiceRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class serviceServicio {
    private final ServiceRepository service;
    public List<Expert> findExperts(Long id){
        return service.findExpertByCategoryId(id);
    }

}

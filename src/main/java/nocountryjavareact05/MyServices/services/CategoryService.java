package nocountryjavareact05.MyServices.services;

import nocountryjavareact05.MyServices.entidades.Category;

import java.math.BigInteger;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    List<Category> findByNameContains(String name);

}

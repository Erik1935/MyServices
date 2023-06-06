package nocountryjavareact05.MyServices.services;

import java.util.List;

import nocountryjavareact05.MyServices.entidades.Category;


public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Long var1);

    public List<Category> findByNameContains(String var1);
}

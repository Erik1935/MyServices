package nocountryjavareact05.MyServices.services;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> findByNameContains(String name) {
        return categoryRepository.findByNameContains(name);
    }


}

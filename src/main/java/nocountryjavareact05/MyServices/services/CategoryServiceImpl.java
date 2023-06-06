package nocountryjavareact05.MyServices.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.repositories.CategoryRepository;
import nocountryjavareact05.MyServices.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly=true)
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Transactional(readOnly=true)
    public Category findById(Long id) {
        return (Category)this.categoryRepository.findById(id).orElseThrow();
    }

    public List<Category> findByNameContains(String name) {
        return this.categoryRepository.findByNameContains(name);
    }


}

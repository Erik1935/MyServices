package nocountryjavareact05.MyServices.controllers;


import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.dto.CategoryDto;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.services.CategoryService;
import nocountryjavareact05.MyServices.services.ServiceCategory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    private final ServiceCategory serviceCategory;

    @GetMapping("")
    public List<CategoryDto> findAll(){
        return serviceCategory.getAllCategories();
    }
    @GetMapping("/category/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/{name}")
    public List<Category> findByNameContains(@PathVariable String name){
        return categoryService.findByNameContains(name);
    }
}

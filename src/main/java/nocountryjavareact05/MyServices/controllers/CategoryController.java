package nocountryjavareact05.MyServices.controllers;

import lombok.AllArgsConstructor;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    @GetMapping("")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/category/{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @GetMapping("/{name}")
    public List<Category> findByNameContains(@PathVariable String name){
        return categoryService.findByNameContains(name);
    }
}

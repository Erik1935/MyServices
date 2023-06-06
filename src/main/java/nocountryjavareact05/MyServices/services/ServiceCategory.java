package nocountryjavareact05.MyServices.services;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.dto.CategoryDto;
import nocountryjavareact05.MyServices.entidades.Category;
import nocountryjavareact05.MyServices.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCategory {
    private final CategoryRepository categoryRepository;
    private final serviceServicio serviceServicio;

    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category:categoryRepository.findAll()){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setTitulo(category.getName());
            categoryDto.setDescripcion(category.getDescription());
            categoryDto.setImagen(category.getImage());
            categoryDto.setProfesionales(serviceServicio.findExpertsByCategory(category.getId()));
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}

package nocountryjavareact05.MyServices.repositories;


import nocountryjavareact05.MyServices.entidades.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContains(String name);

}

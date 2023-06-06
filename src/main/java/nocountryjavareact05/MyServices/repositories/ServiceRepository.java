package nocountryjavareact05.MyServices.repositories;


import nocountryjavareact05.MyServices.entidades.Expert;
import nocountryjavareact05.MyServices.entidades.Services;
import nocountryjavareact05.MyServices.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Services, Long> {
    Optional<Services> findByName(String name);
    @Query(value = "SELECT * FROM service  WHERE category_id = :id",nativeQuery = true)
    List<Services> getAllUsers(Long id);
    @Query("SELECT s.experto FROM Services s WHERE s.category.id = :categoryId AND s.experto.id > 1")
    List<Expert> findExpertByCategoryId(@Param("categoryId") Long categoryId);
    //@Query(value = "SELECT * from service where experto_id = 1",nativeQuery = true)
    @Query(value = "SELECT s FROM Services s LEFT JOIN FETCH s.usuario_id WHERE s.experto.id = 1")
    List<Services> findServicesOfUser();
    @Query(value = "SELECT * from service where experto_id > 1",nativeQuery = true)
    List<Services> findServicesOfExperts();
    @Query(value = "SELECT * from service where experto_id > 1",nativeQuery = true)
    List<Services> find();

}

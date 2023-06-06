package nocountryjavareact05.MyServices.repositories;

import nocountryjavareact05.MyServices.entidades.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryExpert extends JpaRepository<Expert,Long> {
}

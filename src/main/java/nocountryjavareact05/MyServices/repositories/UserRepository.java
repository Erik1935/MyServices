package nocountryjavareact05.MyServices.repositories;


import nocountryjavareact05.MyServices.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

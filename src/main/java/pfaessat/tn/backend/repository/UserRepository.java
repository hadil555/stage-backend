package pfaessat.tn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pfaessat.tn.backend.Entity.User;

@EnableJpaRepositories

public interface UserRepository extends JpaRepository<User, Long> {

}

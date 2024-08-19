package pfaessat.tn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pfaessat.tn.backend.Entity.Project;

@EnableJpaRepositories
public interface ProjectRepository extends JpaRepository<Project, Long> {
}

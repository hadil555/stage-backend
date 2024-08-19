package pfaessat.tn.backend.Dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private String projectCreator;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<UserDto> users;
}

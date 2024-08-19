package pfaessat.tn.backend.mapper;

import pfaessat.tn.backend.Dto.ProjectDTO;
import pfaessat.tn.backend.Dto.UserDto;
import pfaessat.tn.backend.Entity.Project;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setProjectCreator(project.getProjectCreator());
        projectDTO.setStartDate(project.getStartDate());
        projectDTO.setEndDate(project.getEndDate());

        if (project.getUsers() != null) {
            Set<UserDto> userDTOs = project.getUsers().stream()
                    .map(UserMapper::toDTO)
                    .collect(Collectors.toSet());
            projectDTO.setUsers(userDTOs);
        }

        return projectDTO;
    }
}

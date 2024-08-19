package pfaessat.tn.backend.Service.Imp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pfaessat.tn.backend.Dto.ProjectDTO;
import pfaessat.tn.backend.Entity.Project;
import pfaessat.tn.backend.mapper.ProjectMapper;
import pfaessat.tn.backend.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProjectService {
    private ProjectRepository projectRepository;
    public Project updateP(Project employee) {
        // Optional<Facture> existingFactureOptional = departementRepository.findById(updatedFacture.getId());

        Project existingEmployee = projectRepository.findById(employee.getId()).get();
        existingEmployee.setName(employee.getName());



        existingEmployee.setProjectCreator(employee.getProjectCreator());

        existingEmployee.setStartDate(employee.getStartDate());


        existingEmployee.setEndDate(employee.getEndDate());


        existingEmployee.setUsers(employee.getUsers());

        return projectRepository.save(existingEmployee);

    }
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(ProjectMapper::toDTO)
                .collect(Collectors.toList());
    }
    public Project zid(Project employee) {
        // Optional<Facture> existingFactureOptional = departementRepository.findById(updatedFacture.getId());

        Project existingEmployee = new Project();
        existingEmployee.setName(employee.getName());





        existingEmployee.setProjectCreator(employee.getProjectCreator());

        existingEmployee.setStartDate(employee.getStartDate());


        existingEmployee.setEndDate(employee.getEndDate());


        existingEmployee.setUsers(employee.getUsers());

        return projectRepository.save(existingEmployee);


    }
    public Project createP(Project employee) {
        // Optional<Facture> existingFactureOptional = departementRepository.findById(updatedFacture.getId());

        Project existingEmployee = new Project();
        existingEmployee.setName(employee.getName());





        existingEmployee.setProjectCreator(employee.getProjectCreator());

        existingEmployee.setStartDate(employee.getStartDate());


        existingEmployee.setEndDate(employee.getEndDate());


        existingEmployee.setUsers(employee.getUsers());

        return projectRepository.save(existingEmployee);

    }

    @Transactional
    public void deleteEmployee(Long employeeId) {
        // employeeRepository.deleteRolesByEmployeeId(employeeId);
        //checkincheckoutRepository.deleteByEmployee_Id(employeeId);
        projectRepository.deleteById(employeeId);

    }
    public ProjectDTO getProjectById(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.map(ProjectMapper::toDTO).orElse(null);
    }

    public Page<Project> getAll(Pageable paging) {
        return projectRepository.findAll(paging);
    }

}

package pfaessat.tn.backend.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfaessat.tn.backend.Dto.ProjectDTO;
import pfaessat.tn.backend.Entity.Project;
import pfaessat.tn.backend.Service.Imp.ProjectService;
import pfaessat.tn.backend.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/projects")

public class ProjectController {
    @Autowired
    private ProjectService departementService;
    @Autowired
    private ProjectRepository departementRepository;







    @PostMapping

    public ResponseEntity<Project> createDepartement(@RequestBody Project departement){

        Project savedEmployee = departementService.createP(departement);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")

    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("id") Long projectId) {
        ProjectDTO projectDTO = departementService.getProjectById(projectId);
        if (projectDTO != null) {
            return new ResponseEntity<>(projectDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = departementService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    @PutMapping("{id}")

    public ResponseEntity<Project> updateEmployee(@PathVariable("id") Long employeeId,
                                                  @RequestBody Project dept){
        dept.setId(employeeId);
        Project updatedEmployee = departementService.updateP(dept);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        departementService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
    
}

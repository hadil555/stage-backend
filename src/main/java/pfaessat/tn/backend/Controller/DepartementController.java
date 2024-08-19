package pfaessat.tn.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.AllArgsConstructor;
import pfaessat.tn.backend.Entity.Departement;
import pfaessat.tn.backend.Service.Imp.DepartementService;
import pfaessat.tn.backend.repository.DepartementRepository;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/services")
public class DepartementController {
    @Autowired
    private DepartementService departementService;
    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Departement>> getAllDepartments() {
        List<Departement> departments = departementRepository.findAll();
        return ResponseEntity.ok(departments);
    }
    @PostMapping

    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement){

        Departement savedEmployee = departementService.createDet(departement);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")

    public ResponseEntity<  Optional<Departement>> getEmployeeById(@PathVariable("id") Long employeeId){
        Optional<Departement> Employee = departementService.getEmployeeById(employeeId);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    @PutMapping("{id}")

    public ResponseEntity<Departement> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody Departement dept){
        dept.setId(id);
        Departement updatedEmployee = departementService.updateEmployee(dept);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        departementService.deleteEmployee(id);
        return new ResponseEntity<>("dept successfully deleted!", HttpStatus.OK);
    }
}

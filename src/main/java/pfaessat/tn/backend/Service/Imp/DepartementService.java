package pfaessat.tn.backend.Service.Imp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import pfaessat.tn.backend.Entity.Departement;
import pfaessat.tn.backend.repository.DepartementRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartementService {
    private DepartementRepository departementRepository;
    //medecin secrteiare
    public Departement createDet(Departement departement) {

        return departementRepository.save(departement);
    }


    public Optional<Departement> getDepartementById(Long departementId) {
        return departementRepository.findById(departementId);


    }


    public Page<Departement> getAllDepartements(Pageable paging) {
        return departementRepository.findAll(paging);
    }


    public Departement updateEmployee(Departement employee) {
        // .get() aau lieu de orElse
        Departement existingEmployee = departementRepository.findById(employee.getId()).get();
        existingEmployee.setTitle(employee.getTitle());

        existingEmployee.setDescription(employee.getDescription());
        //existingEmployee.setPassword(employee.getPassword());

        return departementRepository.save(existingEmployee);

    }

    @Transactional
    public void deleteEmployee(Long employeeId) {
        // employeeRepository.deleteRolesByEmployeeId(employeeId);
        //checkincheckoutRepository.deleteByEmployee_Id(employeeId);
        departementRepository.deleteById(employeeId);

    }

    public Optional<Departement> getEmployeeById(Long employeeId) {
        return departementRepository.findById(employeeId);
              //  .orElseThrow(() -> new EmployeeNotFoundException("dept not found with the given ID."));

    }


}

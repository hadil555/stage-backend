package pfaessat.tn.backend.Service.Imp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pfaessat.tn.backend.Dto.UserDto;
import pfaessat.tn.backend.Entity.Departement;
import pfaessat.tn.backend.Entity.User;
import pfaessat.tn.backend.mapper.UserMapper;
import pfaessat.tn.backend.repository.DepartementRepository;
import pfaessat.tn.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createDet(User departement) {

        return userRepository.save(departement);
    }
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDTOList(users);
    }

    public Optional<User> getDepartementById(Long departementId) {
        return userRepository.findById(departementId);


    }
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return UserMapper.toDTO(user);
    }

    public Page<User> getAllDepartements(Pageable paging) {
        return userRepository.findAll(paging);
    }


    public User updateEmployee(User employee) {
        // .get() aau lieu de orElse
        User existingEmployee = userRepository.findById(employee.getId()).get();
        existingEmployee.setUsername(employee.getUsername());

        existingEmployee.setEmail(employee.getEmail());


        existingEmployee.setPassword(employee.getPassword());

        existingEmployee.setCin(employee.getCin());
        existingEmployee.setPhone(employee.getPhone());
    existingEmployee.setDepartement(employee.getDepartement());

        return userRepository.save(existingEmployee);

    }

    @Transactional
    public void deleteEmployee(Long employeeId) {
        // employeeRepository.deleteRolesByEmployeeId(employeeId);
        //checkincheckoutRepository.deleteByEmployee_Id(employeeId);
        userRepository.deleteById(employeeId);

    }

    public Optional<User> getEmployeeById(Long employeeId) {
        return userRepository.findById(employeeId);
              //  .orElseThrow(() -> new EmployeeNotFoundException("dept not found with the given ID."));

    }


}

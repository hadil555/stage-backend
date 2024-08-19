package pfaessat.tn.backend.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfaessat.tn.backend.Dto.UserDto;
import pfaessat.tn.backend.Entity.Departement;
import pfaessat.tn.backend.Entity.User;
import pfaessat.tn.backend.Service.Imp.DepartementService;
import pfaessat.tn.backend.Service.Imp.UserService;
import pfaessat.tn.backend.repository.DepartementRepository;
import pfaessat.tn.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping

    public ResponseEntity<User> create(@RequestBody User user){

        User saved = userService.createDet(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("{id}")

    public ResponseEntity<  Optional<User>> getById(@PathVariable("id") Long id){
        Optional<User> user = userService.getEmployeeById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("{id}")

    public ResponseEntity<User> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateEmployee(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")

    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.deleteEmployee(id);
        return new ResponseEntity<>("dept successfully deleted!", HttpStatus.OK);
    }
}

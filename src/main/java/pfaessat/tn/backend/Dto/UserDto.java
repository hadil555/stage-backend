package pfaessat.tn.backend.Dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data

public class UserDto  {
    private Long id;
    private String username;
    private String email;
    private String cin;
    private String phone;
    private String role;
    private DepartementDTO departement;}

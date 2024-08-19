package pfaessat.tn.backend.mapper;

import pfaessat.tn.backend.Dto.DepartementDTO;
import pfaessat.tn.backend.Dto.UserDto;
import pfaessat.tn.backend.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDTO(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCin(user.getCin());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());

        if (user.getDepartement() != null) {
            DepartementDTO departementDTO = new DepartementDTO();
            departementDTO.setId(user.getDepartement().getId());
            departementDTO.setTitle(user.getDepartement().getTitle());
            departementDTO.setDescription(user.getDepartement().getDescription());
            userDTO.setDepartement(departementDTO);
        }

        return userDTO;
    }
    public static List<UserDto> toDTOList(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
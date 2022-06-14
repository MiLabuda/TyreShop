package wszib.edu.pl.tyreshop.services;


import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.UserDto;


import java.util.List;

public interface IUserService {

    void updateEmail(UserDto userDto);
    List<UserDto> getAllUsers();
    User getUserByUsername(String username);
    void saveUser();
}

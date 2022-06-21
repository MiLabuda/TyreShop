package wszib.edu.pl.tyreshop.services;


import wszib.edu.pl.tyreshop.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void save(User user);

    void login(String username, String password);

    Optional<User> findById(Long id);

    User findByEmail(String email);

    User findByUsername(String username);

    List<User> getAllUsers();
}

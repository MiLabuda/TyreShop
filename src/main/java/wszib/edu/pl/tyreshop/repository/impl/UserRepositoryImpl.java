package wszib.edu.pl.tyreshop.repository.impl;


import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.repository.IUserRepository;

import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean existsUserByUserName(String username) {
        return false;
    }
}

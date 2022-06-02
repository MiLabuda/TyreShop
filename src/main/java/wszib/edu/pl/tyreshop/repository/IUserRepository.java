package wszib.edu.pl.tyreshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wszib.edu.pl.tyreshop.model.User;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();

    boolean existsUserByUserName(String username);

}

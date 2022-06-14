package wszib.edu.pl.tyreshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.model.User;

import java.util.List;

@Repository
public interface ITyreRepository extends JpaRepository<Tyre, Long> {
    Tyre getTyreByTyreId(Long tyreId);
    Tyre getTyreByEan(Long ean);
    void flush();
    List<Tyre> findAll();
}

package wszib.edu.pl.tyreshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wszib.edu.pl.tyreshop.model.Tyre;

import java.util.List;


@Repository
public interface ITyreRepository extends JpaRepository<Tyre, Long> {
    Tyre findByTyreId(Long tyreId);

    Tyre findByEan(Long ean);

    List<Tyre> findAll();

}

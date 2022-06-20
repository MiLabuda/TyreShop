package wszib.edu.pl.tyreshop.services;

import wszib.edu.pl.tyreshop.model.Tyre;

import java.util.List;

public interface ITyreService {

    void save (Tyre tyre);
    void edit(Long id, Tyre newTyre);
    void delete(Long id);
    Long count();
    Tyre getTyreById(Long id);
    Tyre getTyreByEan(Long ean);
    List<Tyre> findAll();


}

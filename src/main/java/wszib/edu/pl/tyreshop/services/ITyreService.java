package wszib.edu.pl.tyreshop.services;

import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Tyre;

import java.util.List;

public interface ITyreService {

    Tyre getTyreById(Integer id);
    Tyre getTyreByEan(Integer ean);
    void updateTyre(Tyre tyre);
    List<Tyre> getAllTyres();


}

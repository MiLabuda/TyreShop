package wszib.edu.pl.tyreshop.services.impl;

import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.services.ITyreService;

import java.util.List;

@Service
public class TyreServiceImpl implements ITyreService {

    @Override
    public Tyre getTyreById(Integer id) {
        return null;
    }

    @Override
    public Tyre getTyreByEan(Integer ean) {
        return null;
    }

    @Override
    public void updateTyre(Tyre tyre) {

    }

    @Override
    public List<Tyre> getAllTyres() {
        return null;
    }
}

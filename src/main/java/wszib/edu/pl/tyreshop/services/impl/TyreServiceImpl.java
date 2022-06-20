package wszib.edu.pl.tyreshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.repository.ITyreRepository;
import wszib.edu.pl.tyreshop.services.ITyreService;

import java.util.List;


@Service
public class TyreServiceImpl implements ITyreService {

    private final ITyreRepository tyreRepository;

    @Autowired
    public TyreServiceImpl(ITyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    @Override
    public void save(Tyre tyre) {
        tyreRepository.save(tyre);
    }

    @Override
    public void edit(Long id, Tyre newTyre) {
        Tyre updatedTyre = tyreRepository.getById(id);
        updatedTyre.setTyreManufacturer(newTyre.getTyreManufacturer());
        updatedTyre.setTyreModel(newTyre.getTyreModel());
        updatedTyre.setTyreWidth(newTyre.getTyreWidth());
        updatedTyre.setTyreProfile(newTyre.getTyreProfile());
        updatedTyre.setTyreRim(newTyre.getTyreRim());
        updatedTyre.setQuantity(newTyre.getQuantity());
        updatedTyre.setPrice(newTyre.getPrice());
    }

    @Override
    public void delete(Long id) {
        tyreRepository.delete(tyreRepository.findByTyreId(id));
    }

    @Override
    public Long count() {
        return tyreRepository.count();
    }

    @Override
    public Tyre getTyreById(Long id) {
        return tyreRepository.findByTyreId(id);
    }

    @Override
    public Tyre getTyreByEan(Long ean) {
        return tyreRepository.findByEan(ean);
    }

    @Override
    public List<Tyre> findAll() {
        return tyreRepository.findAll();
    }

}

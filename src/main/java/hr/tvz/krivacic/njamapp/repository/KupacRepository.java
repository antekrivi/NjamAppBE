package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Kupac;
import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.List;
import java.util.Optional;

public interface KupacRepository {
    List<Kupac> findAll();
    Optional<Kupac> findKupacByID(Long id);
    Optional<Kupac> spremiKupca(Kupac kupac);
    void izbrisiKupca(Long id);
}

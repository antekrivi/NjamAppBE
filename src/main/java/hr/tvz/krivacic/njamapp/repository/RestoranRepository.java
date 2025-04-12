package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.List;
import java.util.Optional;

public interface RestoranRepository {
    List<Restoran> findAll();
    Optional<Restoran> findRestoranByID(Long id);
    Optional<Restoran> findRestoranByIme(String ime);
    Optional<Restoran> spremiRestoran(Restoran restoran);
    void izbrisiRestoran(Long id);
}

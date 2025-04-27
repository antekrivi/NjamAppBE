package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestoranRepository {
    Set<Restoran> findAll();
    List<Restoran> findMichelinoveRestorane();
    Optional<Restoran> findRestoranByID(Long id);
    Optional<Restoran> findRestoranByIme(String ime);
    Optional<Restoran> spremiRestoran(Restoran restoran);
    void izbrisiRestoran(Long id);
}

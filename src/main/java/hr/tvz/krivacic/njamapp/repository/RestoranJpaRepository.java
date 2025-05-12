package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestoranJpaRepository extends JpaRepository<Restoran, Long> {

    List<Restoran> findAll();
    List<Restoran> findByMichelinZvijezdiceGreaterThan(int minZvijezdica);
    Optional<Restoran> findById(Long id);
    Optional<Restoran> findByImeRestorana(String ime);

}

package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {

    List<Recenzija> findAll();
    List<Recenzija> findByRestoranId(Long restoranId);


}

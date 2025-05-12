package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Recenzija;
import hr.tvz.krivacic.njamapp.model.Restoran;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {

    List<Recenzija> findAll();
    List<Recenzija> findByRestoranId(Long restoranId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Recenzija r WHERE r.restoran.id = :restoranId")
    void deleteByRestoranId(@Param("restoranId") Long restoranId);

    @Query("SELECT r.restoran FROM Recenzija r WHERE r.datumObjave >= :since" +
            " GROUP BY r.restoran ORDER BY AVG(r.ocjena) DESC")
    List<Restoran> findTopRestoranByAverageOcjenaSince(@Param("since") LocalDateTime since);

}

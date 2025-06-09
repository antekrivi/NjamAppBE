package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.NajpovoljnijiRestoran;
import hr.tvz.krivacic.njamapp.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface NajpovoljnijiRestoranRepository extends JpaRepository<NajpovoljnijiRestoran, Long> {
    @Query("SELECT n.restoran FROM NajpovoljnijiRestoran n WHERE n.datum = :datum")
    List<Restoran> findTopByDatum(@Param("datum") LocalDate datum);


}


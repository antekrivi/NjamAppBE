package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;

import java.util.List;
import java.util.Optional;

public interface RestoranService {
    List<RestoranDTO> findAll();
    RestoranDTO findRestoranByID(Long id);
    RestoranDTO findRestoranByIme(String ime);
    List<RestoranDTO> findNajblizi(String adresa, Double ocjena);
    List<RestoranDTO> findNajbolji(Double ocjena);
    Optional<RestoranDTO> spremiRestoran(RestoranCommand restoranCommand);
    void izbrisiRestoran(Long ID);
}

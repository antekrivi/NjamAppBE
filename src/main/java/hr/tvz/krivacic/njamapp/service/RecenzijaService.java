package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;
import hr.tvz.krivacic.njamapp.model.RecenzijaCommand;
import hr.tvz.krivacic.njamapp.repository.RecenzijaRepository;

import java.util.List;

public interface RecenzijaService {
    List<RecenzijaDTO> findAll();
    List<RecenzijaDTO> findByRestoranID(Long restoranId);

    void deleteByRestoranId(Long restoranId);
    RecenzijaDTO spremi(RecenzijaCommand recenzijaCommand);
    void delete(Long id);
    RecenzijaDTO update(Long id, RecenzijaCommand recenzijaCommand);
}

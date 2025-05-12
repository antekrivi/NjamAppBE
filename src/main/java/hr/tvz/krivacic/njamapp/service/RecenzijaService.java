package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;

import java.util.List;

public interface RecenzijaService {
    List<RecenzijaDTO> findAll();
    List<RecenzijaDTO> findByRestoranID(Long restoranId);

}

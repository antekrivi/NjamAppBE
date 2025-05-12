package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;
import hr.tvz.krivacic.njamapp.model.Recenzija;
import hr.tvz.krivacic.njamapp.repository.RecenzijaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecenzijaServiceImpl implements RecenzijaService{

    private final RecenzijaRepository recenzijaRepository;


    @Override
    public List<RecenzijaDTO> findAll() {
        return recenzijaRepository.findAll()
                .stream()
                .map(this::convertRecenzijaToRecenzijaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecenzijaDTO> findByRestoranID(Long restoranId) {
        return recenzijaRepository.findByRestoranId(restoranId)
                .stream()
                .map(this::convertRecenzijaToRecenzijaDTO)
                .collect(Collectors.toList());
    }

    private RecenzijaDTO convertRecenzijaToRecenzijaDTO(Recenzija recenzija) {
        return new RecenzijaDTO(
                recenzija.getId(),
                recenzija.getNaslov(),
                recenzija.getTekst(),
                recenzija.getOcjena(),
                recenzija.getRestoran()
        );
    }
    @Override
    public void deleteByRestoranId(Long restoranId) {
        recenzijaRepository.deleteByRestoranId(restoranId);
    }
}

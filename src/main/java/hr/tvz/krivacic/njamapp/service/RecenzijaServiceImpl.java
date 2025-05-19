package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;
import hr.tvz.krivacic.njamapp.model.Recenzija;
import hr.tvz.krivacic.njamapp.model.RecenzijaCommand;
import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.repository.RecenzijaRepository;
import hr.tvz.krivacic.njamapp.repository.RestoranRepository;
import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecenzijaServiceImpl implements RecenzijaService{

    private final RecenzijaRepository recenzijaRepository;
    private final UserRepository userRepository;
    private final RestoranService restoranService;

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

    @Override
    public void deleteByRestoranId(Long restoranId) {
        recenzijaRepository.deleteByRestoranId(restoranId);
    }

    @Override
    public RecenzijaDTO spremi(RecenzijaCommand recenzijaCommand) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserInfo user = userRepository.findByUsername(username);

        Restoran restoran = restoranService.findFullRestoranByID(recenzijaCommand.getRestoranId());

        Recenzija recenzija = new Recenzija();
        recenzija.setNaslov(recenzijaCommand.getNaslov());
        recenzija.setTekst(recenzijaCommand.getTekst());
        recenzija.setOcjena(recenzijaCommand.getOcjena());
        recenzija.setRestoran(restoran);
        recenzija.setKorisnik(user);

        Recenzija savedRecenzija = recenzijaRepository.save(recenzija);
        return convertRecenzijaToRecenzijaDTO(savedRecenzija);
    }

    @Override
    public void delete(Long id) {
        recenzijaRepository.deleteById(id);
    }

    @Override
    public RecenzijaDTO update(Long id, RecenzijaCommand recenzijaCommand) {
        return recenzijaRepository.findById(id)
                .map(recenzija -> {
                    recenzija.setNaslov(recenzijaCommand.getNaslov());
                    recenzija.setTekst(recenzijaCommand.getTekst());
                    recenzija.setOcjena(recenzijaCommand.getOcjena());
                    Recenzija updatedRecenzija = recenzijaRepository.save(recenzija);
                    return convertRecenzijaToRecenzijaDTO(updatedRecenzija);
                })
                .orElseThrow(() -> new RuntimeException("Recenzija not found"));
    }

    private RecenzijaDTO convertRecenzijaToRecenzijaDTO(Recenzija recenzija) {
        return new RecenzijaDTO(
                recenzija.getId(),
                recenzija.getNaslov(),
                recenzija.getTekst(),
                recenzija.getOcjena(),
                recenzija.getRestoran(),
                recenzija.getKorisnik().getUsername()
        );
    }
}

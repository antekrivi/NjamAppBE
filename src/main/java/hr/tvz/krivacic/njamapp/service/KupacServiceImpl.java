package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.KupacDTO;
import hr.tvz.krivacic.njamapp.model.Kupac;
import hr.tvz.krivacic.njamapp.model.KupacCommand;
import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.repository.KupacRepository;
import hr.tvz.krivacic.njamapp.repository.MockKupacRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KupacServiceImpl implements KupacService {
    private final MockKupacRepository kupacRepository;

    public KupacServiceImpl(MockKupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }
    @Override
    public List<KupacDTO> findAll() {
        return kupacRepository.findAll()
                .stream()
                .map(this::mapKupacToKupacDTO)
                .collect(Collectors.toList());
    }

    private KupacDTO mapKupacToKupacDTO(Kupac kupac) {
        return new KupacDTO(kupac);
    }

    @Override
    public KupacDTO findKupacByID(Long id) {
        return kupacRepository.findKupacByID(id)
                .map(this::mapKupacToKupacDTO)
                .orElse(null);
    }

    @Override
    public Optional<KupacDTO> spremiKupca(Kupac kupac) {
        return Optional.ofNullable(kupacRepository.spremiKupca(kupac)
                .map(this::mapKupacToKupacDTO)
                .orElse(null));
    }

    @Override
    public void izbrisiKupca(Long id) {
        kupacRepository.izbrisiKupca(id);
    }
}

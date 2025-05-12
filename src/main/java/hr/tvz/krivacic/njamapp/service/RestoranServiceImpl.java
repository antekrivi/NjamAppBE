package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.repository.JdbcRestoranRepository;
import hr.tvz.krivacic.njamapp.repository.MockRestoranRepository;
import hr.tvz.krivacic.njamapp.repository.RecenzijaRepository;
import hr.tvz.krivacic.njamapp.repository.RestoranJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService {
    private final RestoranJpaRepository restoranRepository;
    private final RecenzijaRepository recenzijaRepository;

    public RestoranServiceImpl(RestoranJpaRepository jdbcRestoranRepository, RecenzijaRepository recenzijaService) {
        this.restoranRepository = jdbcRestoranRepository;
        this.recenzijaRepository = recenzijaService;
    }
    @Override
    public List<RestoranDTO> findAll() {
        return restoranRepository.findAll()
                .stream()
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<RestoranDTO> findMichelinoveRestorane() {
        return restoranRepository.findByMichelinZvijezdiceGreaterThan(0)
                .stream()
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }
    private RestoranDTO mapRestoranToRestoranDTO(Restoran restoran) {
        return new RestoranDTO(restoran);
    }
    @Override
    public RestoranDTO findRestoranByID(Long id) {
        return restoranRepository.findById(id)
                .map(this::mapRestoranToRestoranDTO)
                .orElse(null);
    }
    @Override
    public Restoran findFullRestoranByID(Long id) {
        return restoranRepository.findById(id).get();
    }
    @Override
    public RestoranDTO findRestoranByIme(String ime) {
        return restoranRepository.findByImeRestorana(ime)
                .map(this::mapRestoranToRestoranDTO)
                .orElse(null);
    }
    @Override
    public List<RestoranDTO> findNajblizi(String adresa, Double ocjena) {
        return restoranRepository.findAll()
                .stream()
                .filter(restoran -> restoran.getProsOcjenaKupca() > ocjena && restoran.getAdresa().contains(adresa))
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestoranDTO> findNajbolji(Double ocjena) {
        return restoranRepository.findAll()
                .stream()
                .filter(restoran -> restoran.getProsOcjenaKupca() > 4.5)
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<RestoranDTO> spremiRestoran(RestoranCommand restoranCommand){
        Restoran noviRestoran = new Restoran(
                restoranCommand.getID(),
                restoranCommand.getImeRestorana(),
                restoranCommand.getAdresa(),
                restoranCommand.getBrojTelefona(),
                restoranCommand.getEmail(),
                restoranCommand.getRadnoVrijeme(),
                restoranCommand.getTrenutnoOtvoreno(),
                restoranCommand.getProsVrijemeDostave(),
                restoranCommand.getProsOcjenaKupca(),
                restoranCommand.getMaxBrojNarudzbi(),
                restoranCommand.getMichelinZvjezdice(),
                restoranCommand.getKratkiOpis(),
                restoranCommand.getBrojStolova(),
                restoranCommand.getGodinaOsnivanja()
        );
        Restoran spremljeniRestoran = restoranRepository.save(noviRestoran);
        return Optional.of(spremljeniRestoran)
                .map(this::mapRestoranToRestoranDTO);
    }
    @Override
    public void izbrisiRestoran(Long ID){
        recenzijaRepository.deleteByRestoranId(ID);
        restoranRepository.deleteById(ID);
    }

    @Override
    public List<RestoranDTO> findTrenutnoOtvoreniRestorani() {
        return restoranRepository.findAll()
                .stream()
                .filter(Restoran::getTrenutnoOtvoreno)
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RestoranDTO> azurirajRestoran(Long id, RestoranCommand restoranCommand) {
        Restoran restoran = new Restoran(
                id,
                restoranCommand.getImeRestorana(),
                restoranCommand.getAdresa(),
                restoranCommand.getBrojTelefona(),
                restoranCommand.getEmail(),
                restoranCommand.getRadnoVrijeme(),
                restoranCommand.getTrenutnoOtvoreno(),
                restoranCommand.getProsVrijemeDostave(),
                restoranCommand.getProsOcjenaKupca(),
                restoranCommand.getMaxBrojNarudzbi(),
                restoranCommand.getMichelinZvjezdice(),
                restoranCommand.getKratkiOpis(),
                restoranCommand.getBrojStolova(),
                restoranCommand.getGodinaOsnivanja()
        );
        Restoran spremljeniRestoran = restoranRepository.save(restoran);
        return Optional.of(spremljeniRestoran)
                .map(this::mapRestoranToRestoranDTO);
    }

    @Override
    public Optional<RestoranDTO> najboljiRestoranZadnjih7Dana() {
        return recenzijaRepository.findTopRestoranByAverageOcjenaSince(LocalDateTime.now().minusDays(7))
                .stream()
                .map(this::mapRestoranToRestoranDTO)
                .findFirst();
    }

    @Override
    public Optional<RestoranDTO> najboljiRestoranZadnjih30Dana() {
        return recenzijaRepository.findTopRestoranByAverageOcjenaSince(LocalDateTime.now().minusDays(30))
                .stream()
                .map(this::mapRestoranToRestoranDTO)
                .findFirst();
    }
}

package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.repository.JdbcRestoranRepository;
import hr.tvz.krivacic.njamapp.repository.MockRestoranRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService {
    private final JdbcRestoranRepository restoranRepository;

    public RestoranServiceImpl(JdbcRestoranRepository jdbcRestoranRepository) {
        this.restoranRepository = jdbcRestoranRepository;
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
        return restoranRepository.findMichelinoveRestorane()
                .stream()
                .filter(restoran -> restoran.getMichelinZvijezdice() > 0)
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }
    private RestoranDTO mapRestoranToRestoranDTO(Restoran restoran) {
        return new RestoranDTO(restoran);
    }
    @Override
    public RestoranDTO findRestoranByID(Long id) {
        return restoranRepository.findRestoranByID(id)
                .map(this::mapRestoranToRestoranDTO)
                .orElse(null);
    }
    @Override
    public Restoran findFullRestoranByID(Long id) {
        return restoranRepository.findRestoranByID(id).get();
    }
    @Override
    public RestoranDTO findRestoranByIme(String ime) {
        return restoranRepository.findRestoranByIme(ime)
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
        return restoranRepository.spremiRestoran(noviRestoran)
                .map(this::mapRestoranToRestoranDTO);
    }
    @Override
    public void izbrisiRestoran(Long ID){
        restoranRepository.izbrisiRestoran(ID);
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
        return restoranRepository.azurirajRestoran(id, restoran)
                .map(this::mapRestoranToRestoranDTO);
    }
}

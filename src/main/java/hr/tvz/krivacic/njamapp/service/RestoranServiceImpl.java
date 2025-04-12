package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.repository.MockRestoranRepository;
import hr.tvz.krivacic.njamapp.repository.RestoranRepository;
import hr.tvz.krivacic.njamapp.service.RestoranService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService {
    private final MockRestoranRepository restoranRepository;

    public RestoranServiceImpl(MockRestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }
    @Override
    public List<RestoranDTO> findAll() {
        return restoranRepository.findAll()
                .stream()
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
        return null;
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
                restoranCommand.getTrenutnoOtvoren(),
                restoranCommand.getProsVrijemeDostave(),
                restoranCommand.getProsOcjenaKupca(),
                restoranCommand.getMaxBrojNarudzbi(),
                restoranCommand.getMichelinZvjezdice(),
                restoranCommand.getKratkiOpis()
        );
        return restoranRepository.spremiRestoran(noviRestoran)
                .map(this::mapRestoranToRestoranDTO);
    }
    @Override
    public void izbrisiRestoran(Long ID){
        restoranRepository.izbrisiRestoran(ID);
    }
}

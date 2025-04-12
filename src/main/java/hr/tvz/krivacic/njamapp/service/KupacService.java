package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.dto.KupacDTO;
import hr.tvz.krivacic.njamapp.model.Kupac;
import hr.tvz.krivacic.njamapp.model.KupacCommand;
import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.List;
import java.util.Optional;

public interface KupacService {
    List<KupacDTO> findAll();
    KupacDTO findKupacByID(Long id);
    Optional<KupacDTO> spremiKupca(Kupac kupac);
    void izbrisiKupca(Long id);
}

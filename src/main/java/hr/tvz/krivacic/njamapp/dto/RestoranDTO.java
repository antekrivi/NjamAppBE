package hr.tvz.krivacic.njamapp.dto;

import hr.tvz.krivacic.njamapp.model.Restoran;
import lombok.Data;
import lombok.Getter;

import java.util.Map;
import java.util.random.RandomGenerator;

@Getter
@Data
public class RestoranDTO {

    private final Long ID;
    private final String imeRestorana;
    private final String adresa;
    private final boolean trenutnoOtvoreno;
    private final Integer postotakOpterecenosti;
    private final Integer michelinZvijezdice;
    private final String radnoVrijeme;
    private final Integer brojStolova;
    private final Integer godinaOsnivanja;


    public RestoranDTO(Restoran restoran) {
        this.ID = restoran.getId();
        this.imeRestorana = restoran.getImeRestorana();
        this.adresa = restoran.getAdresa();
        this.trenutnoOtvoreno = restoran.getTrenutnoOtvoreno();
        this.postotakOpterecenosti = RandomGenerator.getDefault().nextInt(10 ,101);
        this.michelinZvijezdice = restoran.getMichelinZvijezdice();
        this.radnoVrijeme = restoran.getRadnoVrijeme();
        this.brojStolova = restoran.getBrojStolova();
        this.godinaOsnivanja = restoran.getGodinaOsnivanja();
    }

}

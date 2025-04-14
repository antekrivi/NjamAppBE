package hr.tvz.krivacic.njamapp.dto;

import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.Map;
import java.util.random.RandomGenerator;

public class RestoranDTO {

    private final Long ID;
    private final String imeRestorana;
    private final String adresa;
    private final boolean trenutnoOtvoreno;
    private final Integer postotakOpterecenosti;
    private final Integer michelinZvijezdice;
    private final Map<String, String> radnoVrijeme;


    public RestoranDTO(Restoran restoran) {
        this.ID = restoran.getID();
        this.imeRestorana = restoran.getImeRestorana();
        this.adresa = restoran.getAdresa();
        this.trenutnoOtvoreno = restoran.getTrenutnoOtvoreno();
        this.postotakOpterecenosti = RandomGenerator.getDefault().nextInt(10 ,101);
        this.michelinZvijezdice = restoran.getMichelinZvijezdice();
        this.radnoVrijeme = restoran.getRadnoVrijeme();
    }

    public Long getID() {
        return ID;
    }

    public String getImeRestorana() {
        return imeRestorana;
    }

    public String getAdresa() {
        return adresa;
    }

    public boolean isTrenutnoOtvoreno() {
        return trenutnoOtvoreno;
    }

    public Integer getPostotakOpterecenosti() {
        return postotakOpterecenosti;
    }

    public Integer getMichelinZvijezdice() {
        return michelinZvijezdice;
    }
    public Map<String, String> getRadnoVrijeme() {
        return radnoVrijeme;
    }
}

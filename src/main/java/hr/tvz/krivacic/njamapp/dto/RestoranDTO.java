package hr.tvz.krivacic.njamapp.dto;

import hr.tvz.krivacic.njamapp.model.Restoran;

import java.util.random.RandomGenerator;

public class RestoranDTO {

    private final Long ID;
    private final String imeRestorana;
    private final String adresaRestorana;
    private final boolean trenutnoOtvoren;
    private final Integer postotakOpterecenosti;

    public RestoranDTO(Restoran restoran) {
        this.ID = restoran.getID();
        this.imeRestorana = restoran.getImeRestorana();
        this.adresaRestorana = restoran.getAdresa();
        this.trenutnoOtvoren = restoran.getTrenutnoOtvoren();
        this.postotakOpterecenosti = RandomGenerator.getDefault().nextInt(10 ,101);
    }

    public Long getID() {
        return ID;
    }

    public String getImeRestorana() {
        return imeRestorana;
    }

    public String getAdresaRestorana() {
        return adresaRestorana;
    }

    public boolean isTrenutnoOtvoren() {
        return trenutnoOtvoren;
    }

    public Integer getPostotakOpterecenosti() {
        return postotakOpterecenosti;
    }
}

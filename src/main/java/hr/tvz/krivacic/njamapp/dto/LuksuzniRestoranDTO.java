package hr.tvz.krivacic.njamapp.dto;

public class LuksuzniRestoranDTO {
    private final Long ID;
    private final String imeRestorana;
    private final String adresaRestorana;
    private final boolean trenutnoOtvoren;
    private final Integer postotakOpterecenosti;
    private final String tipKuhinje;
    private final Integer michelinZvjezdice;
    private final Integer brojStolova;

    public LuksuzniRestoranDTO(Long ID, String imeRestorana, String adresaRestorana, boolean trenutnoOtvoren, Integer postotakOpterecenosti, String tipKuhinje, Integer michelinZvjezdice, Integer brojStolova) {
        this.ID = ID;
        this.imeRestorana = imeRestorana;
        this.adresaRestorana = adresaRestorana;
        this.trenutnoOtvoren = trenutnoOtvoren;
        this.postotakOpterecenosti = postotakOpterecenosti;
        this.tipKuhinje = tipKuhinje;
        this.michelinZvjezdice = michelinZvjezdice;
        this.brojStolova = brojStolova;
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

    public String getTipKuhinje() {
        return tipKuhinje;
    }

    public Integer getMichelinZvjezdice() {
        return michelinZvjezdice;
    }

    public Integer getBrojStolova() {
        return brojStolova;
    }
}

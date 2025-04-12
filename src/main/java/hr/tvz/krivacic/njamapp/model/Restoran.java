package hr.tvz.krivacic.njamapp.model;

import java.util.Map;

public class Restoran {
    private Long ID;
    private String imeRestorana;
    private String adresa;
    private String brojTelefona;
    private String email;
    private Map<String, String> radnoVrijeme;
    private Boolean trenutnoOtvoren;
    private Integer prosVrijemeDostave;
    private Double prosOcjenaKupca;
    private Integer maxBrojNarudzbi;
    private Integer michelinZvjezdice;
    private String kratkiOpis;

    public Restoran(Long ID, String imeRestorana, String adresa, String brojTelefona, String email,
                    Map<String, String> radnoVrijeme, Boolean trenutnoOtvoren, Integer prosVrijemeDostave,
                    Double prosOcjenaKupca, Integer maxBrojNarudzbi, Integer michelinZvjezdice, String kratkiOpis) {
        this.ID = ID;
        this.imeRestorana = imeRestorana;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.radnoVrijeme = radnoVrijeme;
        this.trenutnoOtvoren = trenutnoOtvoren;
        this.prosVrijemeDostave = prosVrijemeDostave;
        this.prosOcjenaKupca = prosOcjenaKupca;
        this.maxBrojNarudzbi = maxBrojNarudzbi;
        this.michelinZvjezdice = michelinZvjezdice;
        this.kratkiOpis = kratkiOpis;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getImeRestorana() {
        return imeRestorana;
    }

    public void setImeRestorana(String imeRestorana) {
        this.imeRestorana = imeRestorana;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getRadnoVrijeme() {
        return radnoVrijeme;
    }

    public void setRadnoVrijeme(Map<String, String> radnoVrijeme) {
        this.radnoVrijeme = radnoVrijeme;
    }

    public Boolean getTrenutnoOtvoren() {
        return trenutnoOtvoren;
    }

    public void setTrenutnoOtvoren(Boolean trenutnoOtvoren) {
        this.trenutnoOtvoren = trenutnoOtvoren;
    }

    public Integer getProsVrijemeDostave() {
        return prosVrijemeDostave;
    }

    public void setProsVrijemeDostave(Integer prosVrijemeDostave) {
        this.prosVrijemeDostave = prosVrijemeDostave;
    }

    public Double getProsOcjenaKupca() {
        return prosOcjenaKupca;
    }

    public void setProsOcjenaKupca(Double prosOcjenaKupca) {
        this.prosOcjenaKupca = prosOcjenaKupca;
    }

    public Integer getMaxBrojNarudzbi() {
        return maxBrojNarudzbi;
    }

    public void setMaxBrojNarudzbi(Integer maxBrojNarudzbi) {
        this.maxBrojNarudzbi = maxBrojNarudzbi;
    }

    public Integer getMichelinZvjezdice() {
        return michelinZvjezdice;
    }

    public void setMichelinZvjezdice(Integer michelinZvjezdice) {
        this.michelinZvjezdice = michelinZvjezdice;
    }

    public String getKratkiOpis() {
        return kratkiOpis;
    }

    public void setKratkiOpis(String kratkiOpis) {
        this.kratkiOpis = kratkiOpis;
    }

}

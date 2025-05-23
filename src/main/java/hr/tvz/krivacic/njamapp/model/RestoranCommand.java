package hr.tvz.krivacic.njamapp.model;


import jakarta.validation.constraints.*;


import java.util.Map;

public class RestoranCommand {
    private Long ID;
    @NotBlank(message = "Ime restorana ne smije biti prazno")
    private String imeRestorana;
    @NotBlank(message = "Adresa restorana ne smije biti prazna")
    private String adresa;
    @NotBlank(message = "Broj telefona ne smije biti prazan")
    @Pattern(regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{3}$", message = "Broj telefona mora biti u formatu 123-456-789")
    private String brojTelefona;
    @NotBlank(message = "Email ne smije biti prazan")
    @Email(message = "Email mora biti u točnom formatu")
    private String email;
    @NotNull(message = "Radno vrijeme ne smije biti prazno")
    private Map<String, String> radnoVrijeme;
    @NotNull(message = "Trenutno otvoren ne smije biti prazno")
    private Boolean trenutnoOtvoreno;
    @NotNull(message = "Postotak opterećenosti ne smije biti prazno")
    private Integer prosVrijemeDostave;
    @PositiveOrZero(message = "Ocjena ne smije biti negativna")
    private Double prosOcjenaKupca;
    @NotNull(message = "Max broj narudžbi ne smije biti prazno")
    private Integer maxBrojNarudzbi;
    @PositiveOrZero(message = "Zvijezdice ne smiju biti negativne")
    private Integer michelinZvjezdice;
    @NotBlank(message = "Kratki opis ne smije biti prazan")
    private String kratkiOpis;
    @NotNull(message = "Broj stolova ne smije biti prazno")
    private Integer brojStolova;
    @NotNull(message = "Godina osnivanja ne smije biti prazno")
    private Integer godinaOsnivanja;

    public RestoranCommand(Long ID, String imeRestorana, String adresa, String brojTelefona, String email, Map<String,
            String> radnoVrijeme, Boolean trenutnoOtvoreno, Integer prosVrijemeDostave, Double prosOcjenaKupca,
            Integer maxBrojNarudzbi, Integer michelinZvjezdice, String kratkiOpis, Integer brojStolova, Integer godinaOsnivanja) {
        this.ID = ID;
        this.imeRestorana = imeRestorana;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.radnoVrijeme = radnoVrijeme;
        this.trenutnoOtvoreno = trenutnoOtvoreno;
        this.prosVrijemeDostave = prosVrijemeDostave;
        this.prosOcjenaKupca = prosOcjenaKupca;
        this.maxBrojNarudzbi = maxBrojNarudzbi;
        this.michelinZvjezdice = michelinZvjezdice;
        this.kratkiOpis = kratkiOpis;
        this.brojStolova = brojStolova;
        this.godinaOsnivanja = godinaOsnivanja;
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

    public Boolean getTrenutnoOtvoreno() {
        return trenutnoOtvoreno;
    }

    public void setTrenutnoOtvoreno(Boolean trenutnoOtvoreno) {
        this.trenutnoOtvoreno = trenutnoOtvoreno;
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

    public Integer getBrojStolova() {
        return brojStolova;
    }

    public void setBrojStolova(Integer brojStolova) {
        this.brojStolova = brojStolova;
    }

    public Integer getGodinaOsnivanja() {
        return godinaOsnivanja;
    }

    public void setGodinaOsnivanja(Integer godinaOsnivanja) {
        this.godinaOsnivanja = godinaOsnivanja;
    }
}

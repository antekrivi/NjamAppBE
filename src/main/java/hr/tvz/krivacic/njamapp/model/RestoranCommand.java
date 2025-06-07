package hr.tvz.krivacic.njamapp.model;


import jakarta.validation.constraints.*;
import lombok.Data;


import java.util.Map;

@Data
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
    private String radnoVrijeme;
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

}

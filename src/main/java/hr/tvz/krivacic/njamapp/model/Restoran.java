package hr.tvz.krivacic.njamapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imeRestorana;
    private String adresa;
    private String brojTelefona;
    private String email;
    private String radnoVrijeme;
    private Boolean trenutnoOtvoreno;
    private Integer prosVrijemeDostave;
    private Double prosOcjenaKupca;
    private Integer maxBrojNarudzbi;
    private Integer michelinZvijezdice;
    private String kratkiOpis;
    private Integer brojStolova;
    private Integer godinaOsnivanja;

}

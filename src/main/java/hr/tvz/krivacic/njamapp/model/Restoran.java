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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imeRestorana;
    private String adresa;
    private String brojTelefona;
    private String email;
    @ElementCollection
    @CollectionTable(name = "radno_vrijeme", joinColumns = @JoinColumn(name = "restoran_id"))
    @MapKeyColumn(name = "dan")
    @Column(name = "vrijeme")
    private Map<String, String> radnoVrijeme;
    private Boolean trenutnoOtvoreno;
    private Integer prosVrijemeDostave;
    private Double prosOcjenaKupca;
    private Integer maxBrojNarudzbi;
    private Integer michelinZvijezdice;
    private String kratkiOpis;
    private Integer brojStolova;
    private Integer godinaOsnivanja;

}

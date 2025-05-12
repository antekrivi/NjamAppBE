package hr.tvz.krivacic.njamapp.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Recenzija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naslov;
    private String tekst;
    private Integer ocjena;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restoran_id", referencedColumnName = "id")
    private Restoran restoran;
    private LocalDateTime datumObjave;

    @PrePersist
    protected void onCreate() {
        this.datumObjave = LocalDateTime.now();
    }

}

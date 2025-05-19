package hr.tvz.krivacic.njamapp.model;

import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    private String tekst;
    private Integer ocjena;

    @ManyToOne
    @JoinColumn(name = "restoran_id", referencedColumnName = "id")
    private Restoran restoran;
    private LocalDateTime datumObjave;

    @PrePersist
    protected void onCreate() {
        this.datumObjave = LocalDateTime.now();
    }
    @ManyToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    private UserInfo korisnik;
}

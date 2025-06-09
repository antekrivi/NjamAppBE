package hr.tvz.krivacic.njamapp.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "najpovoljniji_restorani")
@Data
public class NajpovoljnijiRestoran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restoran_id", nullable = false)
    private Restoran restoran;

    @Column(nullable = false)
    private LocalDate datum;


}

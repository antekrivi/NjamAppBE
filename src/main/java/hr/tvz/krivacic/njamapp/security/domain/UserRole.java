package hr.tvz.krivacic.njamapp.security.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grupa_korisnika")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String name;
}

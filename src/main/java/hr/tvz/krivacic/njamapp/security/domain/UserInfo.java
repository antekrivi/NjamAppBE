package hr.tvz.krivacic.njamapp.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "korisnik")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "korisnicko_ime")
    private String username;

    @JsonIgnore
    @Column(name = "lozinka")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "korisnik_grupa",
            joinColumns = { @JoinColumn(name = "korisnik_id") },
            inverseJoinColumns = { @JoinColumn(name = "grupa_id") }
    )
    private List<UserRole> roles = new ArrayList<>();
}

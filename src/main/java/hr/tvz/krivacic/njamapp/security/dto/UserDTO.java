package hr.tvz.krivacic.njamapp.security.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String id;
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private Set<String> role;

}

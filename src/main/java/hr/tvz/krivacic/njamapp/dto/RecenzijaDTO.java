package hr.tvz.krivacic.njamapp.dto;

import hr.tvz.krivacic.njamapp.model.Restoran;
import lombok.Data;

@Data
public class RecenzijaDTO {
    
    private final Long id;
    private final String naslov;
    private final String tekst;
    private final int ocjena;
    private final Restoran restoranId;
}

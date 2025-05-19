package hr.tvz.krivacic.njamapp.model;

import lombok.Data;

@Data
public class RecenzijaCommand {
    private final String naslov;
    private final String tekst;
    private final int ocjena;
    private final Long restoranId;
}

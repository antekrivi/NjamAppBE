package hr.tvz.krivacic.njamapp.dto;

import hr.tvz.krivacic.njamapp.model.Kupac;

import java.util.Random;
import java.util.random.RandomGenerator;

public class KupacDTO {
    private final String imePrezime;
    private final Integer brojNarudzbi;
    private final Integer dob;

    public KupacDTO(Kupac kupac) {
        this.imePrezime = kupac.getIme() + " " + kupac.getPrezime();
        this.brojNarudzbi =  RandomGenerator.getDefault().nextInt(1, 10);
        this.dob = RandomGenerator.getDefault().nextInt(18, 80);
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public Integer getBrojNarudzbi() {
        return brojNarudzbi;
    }

    public Integer getDob() {
        return dob;
    }
}

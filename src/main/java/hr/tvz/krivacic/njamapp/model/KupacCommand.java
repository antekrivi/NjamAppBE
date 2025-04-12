package hr.tvz.krivacic.njamapp.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.security.SecureRandomParameters;
import java.util.Date;

public class KupacCommand {
    @NotNull(message = "ID ne smije biti null")
    private Long ID;
    @Future(message = "Datum isteka subskripcije mora biti u budućnosti")
    private Date datumIstekaSubskripcije;
    @Digits(integer = 3, fraction = 0, message = "Broj mobitela mora biti u formatu 123456789")
    private String brojMobitela;
    @Email
    private String email;

    public KupacCommand(Long ID, Date datumIstekaSubskripcije, String brojMobitela, String email) {
        this.ID = ID;
        this.datumIstekaSubskripcije = datumIstekaSubskripcije;
        this.brojMobitela = brojMobitela;
        this.email = email;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getDatumIstekaSubskripcije() {
        return datumIstekaSubskripcije;
    }

    public void setDatumIstekaSubskripcije(Date datumIstekaSubskripcije) {
        this.datumIstekaSubskripcije = datumIstekaSubskripcije;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
    }
}

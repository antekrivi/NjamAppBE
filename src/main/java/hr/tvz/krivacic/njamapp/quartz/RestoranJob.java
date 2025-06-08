package hr.tvz.krivacic.njamapp.quartz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.repository.RestoranJpaRepository;
import hr.tvz.krivacic.njamapp.repository.RestoranRepository;
import hr.tvz.krivacic.njamapp.service.RestoranServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RestoranJob extends QuartzJobBean {

    @Autowired
    private RestoranServiceImpl restoranService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LocalTime now = LocalTime.now();

        List<RestoranDTO> otvoreniRestorani = restoranService.findAll().stream()
                .filter(this::jeOtvoren)
                        .toList();

        System.out.println("Trenutno otvoreni restorani: ");
        for (RestoranDTO restoran : otvoreniRestorani) {
            System.out.println("Restoran: " + restoran.getImeRestorana() + ", Adresa: " + restoran.getAdresa());
        }
    }

    private boolean jeOtvoren(RestoranDTO restoran) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> radnoVrijemeMapa = mapper.readValue(restoran.getRadnoVrijeme(), new TypeReference<>() {});

            String danas = LocalDate.now()
                    .getDayOfWeek()
                    .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            String vrijemeRaspon = radnoVrijemeMapa.get(danas);
            if (vrijemeRaspon == null || !vrijemeRaspon.contains("-")) return false;

            String[] dijelovi = vrijemeRaspon.split("-");
            LocalTime pocetak = LocalTime.parse(dijelovi[0].trim());
            LocalTime kraj = LocalTime.parse(dijelovi[1].trim());
            LocalTime sada = LocalTime.now();

            return !sada.isBefore(pocetak) && !sada.isAfter(kraj);
        } catch (Exception e) {
            System.err.println("Greška pri parsiranju radnog vremena za restoran " + restoran.getImeRestorana());
            return false;
        }
    }

}

package hr.tvz.krivacic.njamapp.quartz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.service.RestoranServiceImpl;
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

@Component
public class NajpovoljnijiRestoranJob extends QuartzJobBean {

    @Autowired
    private RestoranServiceImpl restoranService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<RestoranDTO> top3 = restoranService.findAll().stream()
                .filter( restoran -> restoran.getMichelinZvijezdice() == 0 && restoran.getBrojStolova() > 5)
                .toList();

        System.out.println("Najpovoljniji restorani: ");
        for (RestoranDTO restoran : top3) {
            System.out.println("Restoran: " + restoran.getImeRestorana() + ", Adresa: " + restoran.getAdresa());
            restoranService.spremiNajpovoljnijiRestoran(restoran.getID());
        }
    }
}

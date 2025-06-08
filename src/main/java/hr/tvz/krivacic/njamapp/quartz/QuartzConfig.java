package hr.tvz.krivacic.njamapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail restoranJobDetail() {
        return JobBuilder.newJob(RestoranJob.class)
                .withIdentity("restoranJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger restoranJobTrigger(JobDetail restoranJobDetail) {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(restoranJobDetail)
                .withIdentity("restoranJobTrigger").withSchedule(scheduleBuilder).build();
    }
}

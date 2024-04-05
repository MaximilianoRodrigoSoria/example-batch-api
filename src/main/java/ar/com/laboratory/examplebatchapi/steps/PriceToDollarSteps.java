package ar.com.laboratory.examplebatchapi.steps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@Component
@Slf4j
public class PriceToDollarSteps {

    @Bean(name = "priceToDollarStep")
    protected Step listStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("priceToDollarStep", jobRepository)
                .allowStartIfComplete(true)
                .<String, String> chunk(10, transactionManager)
                .reader(new ListItemReader<>(Arrays.asList("Maximiliano", "Rodrigo", "Soria")))
                .writer(list -> list.forEach(log::error))
                .build();
    }

}

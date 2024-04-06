package ar.com.laboratory.examplebatchapi.batch.steps;

import ar.com.laboratory.examplebatchapi.batch.processors.ProductProcessor;
import ar.com.laboratory.examplebatchapi.batch.readers.DataBaseReader;
import ar.com.laboratory.examplebatchapi.models.entities.Product;
import ar.com.laboratory.examplebatchapi.services.PriceDollarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@Slf4j
@AllArgsConstructor
public class PriceToDollarSteps {

    private DataBaseReader dataBaseReader;
    private PriceDollarService priceDollarService;


    @Bean(name = "priceToDollarStep")
    Step listStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("priceToDollarStep", jobRepository)
                .allowStartIfComplete(true)
                .<Product,Product> chunk(10, transactionManager)
                .reader(dataBaseReader.reader())
                .processor(new ProductProcessor(priceDollarService))
                .writer(list -> list.forEach(product -> log.error(product.toString())))
                .build();
    }

}

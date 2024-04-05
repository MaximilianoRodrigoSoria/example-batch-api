package ar.com.laboratory.examplebatchapi.jobs;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@AllArgsConstructor
@Slf4j
@Component
public class ProductJob {



    @Bean(name = "firstBatchJob")
    public Job job(JobRepository jobRepository, @Qualifier("step1") Step step1) {
        return new JobBuilder("firstBatchJob", jobRepository)
                        .preventRestart()
                        .start(step1)
                        .build();
    }


    @Bean
    protected Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<String, String> chunk(10, transactionManager)
                .reader(new ListItemReader<>(Arrays.asList("Maximiliano", "Rodrigo", "Soria")))
                .writer(list -> list.forEach(log::info))
                .build();
    }
}

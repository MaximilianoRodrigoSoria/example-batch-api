package ar.com.laboratory.examplebatchapi.jobs;


import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductJob {

    @Bean(name = "firstBatchJob")
    public Job job(JobRepository jobRepository,  @Qualifier(value = "listStep") Step listStep) {
        return new JobBuilder("firstBatchJob", jobRepository)
                        .start(listStep)
                        .build();
    }



}

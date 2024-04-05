package ar.com.laboratory.examplebatchapi.api.controllers.impl;


import ar.com.laboratory.examplebatchapi.api.controllers.JobController;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
@AllArgsConstructor
public class JobControllerImpl implements JobController {

    JobLauncher jobLauncher;
    Job job;
    @Override
    @GetMapping("/product/run")
    public ResponseEntity<String> runJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(job, new JobParameters());
        return ResponseEntity.ok("OK");
    }
}

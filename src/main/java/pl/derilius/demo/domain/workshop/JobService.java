package pl.derilius.demo.domain.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository repository;

    @Autowired
    public JobService(JobRepository repository) {
        this.repository = repository;
    }

}

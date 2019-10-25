package pl.derilius.demo.domain.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.client.VehicleService;

@Service
public class WorkshopFacade {

    private final VehicleService vehicleService;
    private final OrderService orderService;
    private final JobService jobService;

    @Autowired
    public WorkshopFacade(VehicleService vehicleService, OrderService orderService, JobService jobService) {
        this.vehicleService = vehicleService;
        this.orderService = orderService;
        this.jobService = jobService;
    }

    public void addWorker() {

    }

    public void editWorker() {

    }

    public void createOrder() {

    }

    public void generateOrderFile() {

    }

    public void createJob() {

    }

    public void getJobs() {

    }

    public void deleteJob() {

    }

    public void addJobToOrder() {

    }

}

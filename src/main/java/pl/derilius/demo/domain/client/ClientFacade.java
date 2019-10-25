package pl.derilius.demo.domain.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientFacade {

    private final ClientService clientService;
    private final VehicleService vehicleService;

    @Autowired
    public ClientFacade(ClientService clientService, VehicleService vehicleService) {
        this.clientService = clientService;
        this.vehicleService = vehicleService;
    }

    public void createClient(){

    }

    public void editClient(){

    }

    public void addVehicleToClient(){

    }

    public void deleteVehicle(){

    }

}

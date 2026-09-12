package org.SmartWaste.service;
import org.SmartWaste.SensorData;
import org.SmartWaste.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    private final SensorDataRepository repository ;

    public SensorDataService(SensorDataRepository repository) {
        this.repository=repository;
    }

    public SensorData getData(){
        return repository.getLatestSensorData();
    }

}




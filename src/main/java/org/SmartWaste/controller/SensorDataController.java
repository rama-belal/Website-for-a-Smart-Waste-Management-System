package org.SmartWaste.controller;
import org.SmartWaste.service.SensorDataService;
import org.SmartWaste.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sensor-data")
@CrossOrigin(origins = "*")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping("/latest")
    public SensorData getLatestSensorData() {
        return sensorDataService.getData();
    }
}

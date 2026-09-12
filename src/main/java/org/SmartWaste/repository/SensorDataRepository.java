package org.SmartWaste.repository;
import com.google.firebase.database.*;
import jakarta.annotation.PostConstruct;
import org.SmartWaste.SensorData;
import org.SmartWaste.FirebaseInitializer;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDataRepository {

    private final DatabaseReference sensorRef;
    private volatile SensorData latestSensorData;

    public SensorDataRepository() {

        FirebaseDatabase database = FirebaseInitializer.getRealtimeDatabase();
        this.sensorRef = database.getReference("sensor_data");
    }

    @PostConstruct
    public void init() {
        listenToSensorData();
    }

    public void listenToSensorData() {
        sensorRef.orderByKey().limitToLast(1).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    SensorData data = child.getValue(SensorData.class);
                    if (data != null) {
                        latestSensorData = data;
                        System.out.println("Realtime update - latest sensor data: " + data.getDistance());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Realtime listener cancelled: " + error.getMessage());
            }
        });
    }
    public SensorData getLatestSensorData() {
        return latestSensorData;
    }
}


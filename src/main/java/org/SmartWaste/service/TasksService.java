package org.SmartWaste.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.SmartWaste.Tasks;
import org.SmartWaste.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TasksService {
    private final TasksRepository repository;

    public TasksService(TasksRepository repository) {
        this.repository = repository;
    }

    public String submitTask(Tasks task) throws ExecutionException, InterruptedException {
        return repository.submitTask(task);
    }

    public List<Tasks> getUnassigned() throws ExecutionException, InterruptedException {
        return repository.getUnassigned();
    }
}
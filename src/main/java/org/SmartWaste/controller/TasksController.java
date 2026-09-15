
package org.SmartWaste.controller;

import org.SmartWaste.Tasks;
import org.SmartWaste.service.TasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.concurrent.ExecutionException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TasksController
{
    private final TasksService service;

    public TasksController(TasksService service) {
        this.service = service;
    }


    /*@PostMapping("/submit")
    public ResponseEntity<String> submitTask(@RequestBody Tasks task) {
        try {
            String result = service.submitTask(task);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error publishing task " + e.getMessage());
        }
    }*/


    @PostMapping("/submit")
    public ResponseEntity<String> submitTask(@RequestHeader("Authorization") String authHeader, @RequestBody Tasks task) {
        try {
            String idToken = authHeader.replace("Bearer ", "");
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();

            DocumentSnapshot roleDoc = FirestoreClient.getFirestore()
                    .collection("userRoles").document(uid).get().get();

            if (!roleDoc.exists() || !("admin".equals(roleDoc.getString("role")) || "editor".equals(roleDoc.getString("role")))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authorized");
            }

            String result = service.submitTask(task);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing auth token");
        }
    }

/*
    @GetMapping("/unassigned")
    public ResponseEntity<List<Tasks>> getUnassignedTasks() {
        try {
            List<Tasks> tasks = service.getUnassigned();
            return ResponseEntity.ok(tasks);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

    @GetMapping("/unassigned")
    public ResponseEntity<List<Tasks>> getUnassignedTasks(@RequestHeader("Authorization") String authHeader) {
        try {
            String idToken = authHeader.replace("Bearer ", "");
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();

            DocumentSnapshot roleDoc = FirestoreClient.getFirestore()
                    .collection("userRoles").document(uid).get().get();

            if (!roleDoc.exists() || !("admin".equals(roleDoc.getString("role")) || "editor".equals(roleDoc.getString("role")))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            List<Tasks> tasks = service.getUnassigned();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}


package org.SmartWaste;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {

    public static void initialize() {
        try {
            // Initialize Firestore (default app)
            FileInputStream firestoreAccount = new FileInputStream("src/main/resources/firebase/firebase-service-account.json");
            FirebaseOptions firestoreOptions = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(firestoreAccount))
                    .build();
            FirebaseApp.initializeApp(firestoreOptions);
            System.out.println("✅ Firestore initialized");

            // nitialize Realtime Database
            FileInputStream rtdbAccount = new FileInputStream("src/main/resources/firebase/binova-service-account.json");
            FirebaseOptions rtdbOptions = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(rtdbAccount))
                    .setDatabaseUrl("https://binova-b8862-default-rtdb.firebaseio.com/") // 🔁 Replace with actual URL
                    .build();
            FirebaseApp.initializeApp(rtdbOptions, "binova");
            System.out.println("✅ Realtime Database (Binova) initialized");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("❌ Firebase initialization failed");
        }
    }

    // firestore access
    public static Firestore getFirestore() {
        return FirestoreClient.getFirestore(); // Uses default app
    }

    // Realtime Database access
    public static FirebaseDatabase getRealtimeDatabase() {
        FirebaseApp binovaApp = FirebaseApp.getInstance("binova");
        return FirebaseDatabase.getInstance(binovaApp);
    }
}



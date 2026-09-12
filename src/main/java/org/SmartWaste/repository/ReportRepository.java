package org.SmartWaste.repository;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ExecutionException;


@Repository
public class ReportRepository {

    private final Firestore firestore = FirestoreClient.getFirestore();
    private final CollectionReference reportsCollection = firestore.collection("reports");


    public String deleteByReportId(String reportId) throws ExecutionException, InterruptedException {
        try {
            WriteResult result = reportsCollection.document(reportId).delete().get();
            return "Report deleted successfully at: " + result.getUpdateTime();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting report with id: " + reportId;
        }
    }

    public String deleteWorkerReportById(String reportId) throws ExecutionException, InterruptedException {
        try {
            WriteResult result = firestore.collection("reportworker").document(reportId).delete().get();
            return "Worker report deleted successfully at: " + result.getUpdateTime();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting worker report with id: " + reportId;
        }
    }
}




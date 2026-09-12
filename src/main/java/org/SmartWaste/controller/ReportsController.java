package org.SmartWaste.controller;

import org.SmartWaste.service.ReportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "*")
public class ReportsController {

    private final ReportsService reportService;

    public ReportsController(ReportsService reportService) {
        this.reportService = reportService;
    }

    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable String reportId) throws ExecutionException, InterruptedException {
        String result = reportService.deleteReports(reportId);
        if (result.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete-worker/{reportId}")
    public ResponseEntity<String> deleteWorkerReport(@PathVariable String reportId) throws ExecutionException, InterruptedException {
        String result = reportService.deleteWorkerReport(reportId);
        if (result.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }
}
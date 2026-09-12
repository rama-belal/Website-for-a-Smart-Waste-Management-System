package org.SmartWaste.service;

import org.SmartWaste.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ReportsService {

    private final ReportRepository reportRepository;

    public ReportsService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


        public String deleteReports (String reportId) throws ExecutionException, InterruptedException {
            reportRepository.deleteByReportId(reportId);
            return reportId;
        }

    public String deleteWorkerReport(String reportId) throws ExecutionException, InterruptedException {
        return reportRepository.deleteWorkerReportById(reportId);
    }
    }


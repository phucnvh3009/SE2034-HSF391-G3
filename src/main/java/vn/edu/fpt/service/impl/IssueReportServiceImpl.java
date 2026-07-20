package vn.edu.fpt.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.fpt.dto.response.domstaff.ReportDTO;
import vn.edu.fpt.dto.response.domstaff.ReportDetailDTO;
import vn.edu.fpt.model.IssueReport;
import vn.edu.fpt.model.constant.ReportStatus;
import vn.edu.fpt.repository.IssueReportRepository;
import vn.edu.fpt.service.IssueReportService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class IssueReportServiceImpl implements IssueReportService {
    private IssueReportRepository issueReportRepository;

    @Override
    public List<ReportDTO> getAllIssueReports() {
        List<ReportDTO> reportDTOList = new ArrayList<>();
        List<IssueReport> issueReports = issueReportRepository.findAll();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                .withZone(java.time.ZoneId.systemDefault());

        for (IssueReport issueReport : issueReports) {
            String createdAt = issueReport.getCreatedAt() != null ? formatter.format(issueReport.getCreatedAt()) : "";
            
            reportDTOList.add(new ReportDTO(
                    issueReport.getId().toString(),
                    issueReport.getStudent().getLastName() + " " + issueReport.getStudent().getFirstName(),
                    issueReport.getCategory().name(),
                    issueReport.getStatus().name(),
                    createdAt
            ));
        }
        return reportDTOList;
    }

    @Override
    public ReportDetailDTO getIssueReportById(Long id) {
        IssueReport report = issueReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy yêu cầu"));
                
        String studentCode = "";
        if (report.getStudent().getStudentProfile() != null) {
            studentCode = report.getStudent().getStudentProfile().getStudentCode();
        }
        
        // Format ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                .withZone(java.time.ZoneId.systemDefault());
        String createdAt = report.getCreatedAt() != null ? formatter.format(report.getCreatedAt()) : "";
        
        return new ReportDetailDTO(
                report.getId().toString(),
                report.getStudent().getLastName() + " " + report.getStudent().getFirstName(),
                studentCode,
                createdAt,
                report.getCategory().name(),
                report.getTitle(),
                report.getDescription(),
                report.getStaffNote(),
                report.getStatus().name()
        );
    }

    @Override
    public void updateReportStatusAndNote(Long id, ReportStatus status, String staffNote) {
        IssueReport report = issueReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy yêu cầu"));
        
        report.setStatus(status);
        report.setStaffNote(staffNote);
        
        issueReportRepository.save(report);
    }
}

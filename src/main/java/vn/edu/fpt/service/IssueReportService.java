package vn.edu.fpt.service;

import vn.edu.fpt.dto.response.domstaff.ReportDTO;
import vn.edu.fpt.dto.response.domstaff.ReportDetailDTO;
import vn.edu.fpt.model.IssueReport;
import vn.edu.fpt.model.constant.ReportStatus;

import java.util.List;

public interface IssueReportService {
    List<ReportDTO> getAllIssueReports();
    ReportDetailDTO getIssueReportById(Long id);
    void updateReportStatusAndNote(Long id, ReportStatus status, String staffNote);
}

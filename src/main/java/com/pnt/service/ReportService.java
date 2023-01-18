package com.pnt.service;

import java.util.List;

import com.pnt.model.report.Report;

public interface ReportService {
	public Report addReport(Report report);
	public Report updateReport(Report report);
	public List<Report> getReportByUserCode(String userCode);
	public List<Report> getAllReport();
	public void deleteReport(Long id);
}

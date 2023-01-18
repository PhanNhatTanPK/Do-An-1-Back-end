package com.pnt.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.report.Report;
import com.pnt.repository.ReportRepo;
import com.pnt.service.ReportService;

@Service
public class ReportServiceImp implements ReportService {
	@Autowired
	private ReportRepo reportRepo;
	
	@Override
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		return this.reportRepo.save(report);
	}

	@Override
	public Report updateReport(Report report) {
		// TODO Auto-generated method stub
		return this.reportRepo.save(report);
	}

	@Override
	public List<Report> getAllReport() {
		// TODO Auto-generated method stub
		return this.reportRepo.findAll();
	}

	@Override
	public void deleteReport(Long id) {
		// TODO Auto-generated method stub
		this.reportRepo.delete(id);
	}

	@Override
	public List<Report> getReportByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return this.reportRepo.getReportByUserCode(userCode);
	}

}

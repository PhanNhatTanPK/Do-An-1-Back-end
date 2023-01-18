package com.pnt.service.implement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.dto.CompanyDto;
import com.pnt.model.dto.ResultDto;
import com.pnt.model.dto.UserDto;
import com.pnt.model.user.User;
import com.pnt.repository.CompanyRepo;
import com.pnt.repository.UserRepo;

@Service
public class StatisticServiceImp{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CompanyRepo companyRepo;
	
	// Xuất thông tin giảng viên ra file Excel
	public static ByteArrayInputStream teacherToExcel(List<User> teachers) throws IOException
	{
		String[] columns = {"Mã giảng viên","Họ và tên","Email","Số điện thoại", "Địa chỉ","Giới tính","Ngày sinh"};
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Teachers");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);		
			setStyle(headerCellStyle);
			
			CellStyle style = workbook.createCellStyle();
			setStyle(style);
			
			//Row cho title
			Row title = sheet.createRow(0);
			Cell cellTitle = title.createCell(0);
			cellTitle.setCellValue("DANH SÁCH GIẢNG VIÊN");
			sheet.addMergedRegion(new CellRangeAddress(
	                0, //hàng đầu tiên muốn gộp
	                0, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                6  //cột cuối cùng muốn gộp
	        ));
			cellTitle.setCellStyle(headerCellStyle);
			
			//Row cho Header-->
			Row headerRow = sheet.createRow(1);			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			int rowIdx =2;
			for(User teacher: teachers)
			{
				Row row = sheet.createRow(rowIdx++);			
				row.createCell(0).setCellValue(teacher.getUserCode());
				row.getCell(0).setCellStyle(style);
				row.createCell(1).setCellValue(teacher.getFullName());
				row.getCell(1).setCellStyle(style);
				row.createCell(2).setCellValue(teacher.getEmail());
				row.getCell(2).setCellStyle(style);
				row.createCell(3).setCellValue(teacher.getPhone());
				row.getCell(3).setCellStyle(style);
				row.createCell(4).setCellValue(teacher.getAddress());
				row.getCell(4).setCellStyle(style);
				row.createCell(5).setCellValue(teacher.getGender());
				row.getCell(5).setCellStyle(style);
				row.createCell(6).setCellValue(teacher.getBirthday());
				row.getCell(6).setCellStyle(style);				
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	// Xuất thông tin sinh viên ra file Excel
	public static ByteArrayInputStream studentToExcel(List<UserDto> students) throws IOException
	{
		String[] columns = {"Mã sinh viên","Họ và tên","Email","Số điện thoại", "Địa chỉ","Giới tính","Ngày sinh",
						"Lớp","Chuyên ngành","Điểm trung bình", "Lĩnh vực thực tập", "Cơ sở thực tập", 
						"Địa chỉ cơ sở thực tập", "Tên người hướng dẫn", "Vị trí người hướng dẫn", 
						"Email người hướng dẫn", "Số điện thoại người hướng dẫn"};
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Students");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			setStyle(headerCellStyle);
			
			CellStyle style = workbook.createCellStyle();
			setStyle(style);
			
			//Row cho title
			Row title = sheet.createRow(0);
			Cell cellTitle = title.createCell(0);
			cellTitle.setCellValue("DANH SÁCH SINH VIÊN");
			sheet.addMergedRegion(new CellRangeAddress(
	                0, //hàng đầu tiên muốn gộp
	                0, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                16  //cột cuối cùng muốn gộp
	        ));
			cellTitle.setCellStyle(headerCellStyle);
			
			//Row cho Header-->
			Row headerRow = sheet.createRow(1);			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			int rowIdx =2;
			for(UserDto stud: students)
			{
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(stud.getUserCode());
				row.getCell(0).setCellStyle(style);
				row.createCell(1).setCellValue(stud.getFullName());
				row.getCell(1).setCellStyle(style);
				row.createCell(2).setCellValue(stud.getEmail());
				row.getCell(2).setCellStyle(style);
				row.createCell(3).setCellValue(stud.getPhone());
				row.getCell(3).setCellStyle(style);
				row.createCell(4).setCellValue(stud.getAddress());
				row.getCell(4).setCellStyle(style);
				row.createCell(5).setCellValue(stud.getGender());
				row.getCell(5).setCellStyle(style);
				row.createCell(6).setCellValue(stud.getBirthday());
				row.getCell(6).setCellStyle(style);
				row.createCell(7).setCellValue(stud.getClassInfo());
				row.getCell(7).setCellStyle(style);
				row.createCell(8).setCellValue(stud.getMajor());
				row.getCell(8).setCellStyle(style);
				row.createCell(9).setCellValue(stud.getGpa());
				row.getCell(9).setCellStyle(style);
				row.createCell(10).setCellValue(stud.getFieldOfIntern());
				row.getCell(10).setCellStyle(style);
				row.createCell(11).setCellValue(stud.getCompany_name());
				row.getCell(11).setCellStyle(style);
				row.createCell(12).setCellValue(stud.getCompany_address());
				row.getCell(12).setCellStyle(style);
				row.createCell(13).setCellValue(stud.getInstructorName());
				row.getCell(13).setCellStyle(style);
				row.createCell(14).setCellValue(stud.getInstructorPosition());
				row.getCell(14).setCellStyle(style);
				row.createCell(15).setCellValue(stud.getInstructorEmail());
				row.getCell(15).setCellStyle(style);
				row.createCell(16).setCellValue(stud.getInstructorPhone());
				row.getCell(16).setCellStyle(style);
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	// Xuất thông tin công ty ra file Excel
	public static ByteArrayInputStream companyToExcel(List<CompanyDto> companies) throws IOException
	{
		String[] columns = {"Id","Cơ sở thực tập", "Địa chỉ", "Email", "Số điện thoại", "Số lượng sinh viên thực tập"};
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Companies");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			
			CellStyle style = workbook.createCellStyle();
			setStyle(style);
			
			//Row cho title
			Row title = sheet.createRow(0);
			Cell cellTitle = title.createCell(0);
			cellTitle.setCellValue("DANH SÁCH CÔNG TY");
			sheet.addMergedRegion(new CellRangeAddress(
	                0, //hàng đầu tiên muốn gộp
	                0, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                5  //cột cuối cùng muốn gộp
	        ));
			cellTitle.setCellStyle(headerCellStyle);
			
			//Row cho Header-->
			Row headerRow = sheet.createRow(1);			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			int rowIdx =2;
			for(CompanyDto company: companies)
			{
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(company.getCid());
				row.getCell(0).setCellStyle(style);
				row.createCell(1).setCellValue(company.getCompany_name());
				row.getCell(1).setCellStyle(style);
				row.createCell(2).setCellValue(company.getCompany_address());
				row.getCell(2).setCellStyle(style);
				row.createCell(3).setCellValue(company.getEmail());
				row.getCell(3).setCellStyle(style);
				row.createCell(4).setCellValue(company.getPhone());	
				row.getCell(4).setCellStyle(style);
				row.createCell(5).setCellValue(company.getNumber());
				row.getCell(5).setCellStyle(style);
			}
			
			Row total = sheet.createRow(rowIdx+=1);
			Cell cellTotalName = total.createCell(0);
			cellTotalName.setCellValue("Total");
			sheet.addMergedRegion(new CellRangeAddress(
					rowIdx, //hàng đầu tiên muốn gộp
					rowIdx, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                4  //cột cuối cùng muốn gộp
	        ));
			Cell cellTotal =total.createCell(5);
			cellTotal.setCellFormula("SUM(F3:F"+(rowIdx-=1)+")");
			
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	// Xuất thông tin kết quả thực tập ra file Excel
	public static ByteArrayInputStream resultToExcel(List<ResultDto> results) throws IOException
	{
		String[] columns = {"Họ và tên","Điểm"};			
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Results");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			
			CellStyle style = workbook.createCellStyle();
			setStyle(style);
			
			//Row cho title
			Row title = sheet.createRow(0);
			Cell cellTitle = title.createCell(0);
			cellTitle.setCellValue("DANH SÁCH KẾT QUẢ THỰC TẬP");
			sheet.addMergedRegion(new CellRangeAddress(
	                0, //hàng đầu tiên muốn gộp
	                0, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                1  //cột cuối cùng muốn gộp
	        ));
			cellTitle.setCellStyle(headerCellStyle);
			
			//Row cho Header-->
			Row headerRow = sheet.createRow(1);			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			int rowIdx =2;
			for(ResultDto result: results)
			{
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(result.getFullName());
				row.getCell(0).setCellStyle(style);
				row.createCell(1).setCellValue(result.getTotalPoint());
				row.getCell(1).setCellStyle(style);				
			}	
			
			
			Row tableStatistic = sheet.createRow(rowIdx++);
			tableStatistic.createCell(5).setCellValue("Điểm");
			tableStatistic.createCell(6).setCellValue("Phần trăm (%)");
			tableStatistic.createCell(7).setCellValue("Số lượng");
			
			Row point8 = sheet.createRow(rowIdx++);
			Row point68 = sheet.createRow(rowIdx++);
			Row point6 = sheet.createRow(rowIdx++);
			Row total = sheet.createRow(rowIdx++);
			
			point8.createCell(5).setCellValue("Điểm trên 8");
			point8.createCell(6).setCellFormula("H"+(rowIdx-=3)+"/H"+(rowIdx+=3)+"*100");
			point8.createCell(7).setCellFormula("COUNTIF(B3:B"+(rowIdx-=5)+", \">= 8\" )");			
						
			point68.createCell(5).setCellValue("Điểm từ 6 đến 8");
			point68.createCell(6).setCellFormula("H"+(rowIdx+=3)+"/H"+(rowIdx+=2)+"*100");
			point68.createCell(7).setCellFormula("COUNTIFS(B3:B"+(rowIdx-=5)+", \">= 6\", B3:B"+(rowIdx)+ ", \"< 8\")");
			
			
			point6.createCell(5).setCellValue("Điểm dưới 6");
			point6.createCell(6).setCellFormula("H"+(rowIdx+=4)+"/H"+(rowIdx+=1)+"*100");
			point6.createCell(7).setCellFormula("COUNTIF(B3:B"+(rowIdx-=5)+", \"< 6\" )");
			
			total.createCell(5).setCellValue("Total");
			total.createCell(7).setCellFormula("SUM(H"+(rowIdx+=2)+":H"+(rowIdx+=2)+")");
			
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	// Xuất file danh sách đăng ký thực tập
	public static ByteArrayInputStream internToExcel(List<UserDto> students) throws IOException
	{
		String[] columns = {"Xác nhận","Họ và tên","Email","Số điện thoại", "Địa chỉ","Giới tính","Ngày sinh",
						"Lớp","Chuyên ngành","Điểm trung bình", "Lĩnh vực thực tập", "Cơ sở thực tập", 
						"Địa chỉ cơ sở thực tập", "Tên người hướng dẫn", "Vị trí người hướng dẫn", 
						"Email người hướng dẫn", "Số điện thoại người hướng dẫn"};
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Students");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			setStyle(headerCellStyle);
			
			CellStyle style = workbook.createCellStyle();
			setStyle(style);
			
			//Row cho title
			Row title = sheet.createRow(0);
			Cell cellTitle = title.createCell(0);
			cellTitle.setCellValue("DANH SÁCH XÁC NHẬN ĐĂNG KÝ THỰC TẬP");
			sheet.addMergedRegion(new CellRangeAddress(
	                0, //hàng đầu tiên muốn gộp
	                0, //hàng cuối cùng muốn gộp
	                0, //cột đầu tiên muốn gộp
	                16  //cột cuối cùng muốn gộp
	        ));
			cellTitle.setCellStyle(headerCellStyle);
			
			//Row cho Header-->
			Row headerRow = sheet.createRow(1);			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			CellStyle styleOK = workbook.createCellStyle();
			setStyleOk(styleOK);
			
			CellStyle styleNO = workbook.createCellStyle();
			setStyleNo(styleNO);
			
			int rowIdx =2;
			for(UserDto stud: students)
			{
				Row row = sheet.createRow(rowIdx++);
				
				if(stud.isAccept()) {
					row.createCell(0).setCellValue("OK");
					row.getCell(0).setCellStyle(styleOK);
				}
				else {
					row.createCell(0).setCellValue(" ");
					row.getCell(0).setCellStyle(styleNO);
				}			
				
				row.createCell(1).setCellValue(stud.getFullName());
				row.getCell(1).setCellStyle(style);
				row.createCell(2).setCellValue(stud.getEmail());
				row.getCell(2).setCellStyle(style);
				row.createCell(3).setCellValue(stud.getPhone());
				row.getCell(3).setCellStyle(style);
				row.createCell(4).setCellValue(stud.getAddress());
				row.getCell(4).setCellStyle(style);
				row.createCell(5).setCellValue(stud.getGender());
				row.getCell(5).setCellStyle(style);
				row.createCell(6).setCellValue(stud.getBirthday());
				row.getCell(6).setCellStyle(style);
				row.createCell(7).setCellValue(stud.getClassInfo());
				row.getCell(7).setCellStyle(style);
				row.createCell(8).setCellValue(stud.getMajor());
				row.getCell(8).setCellStyle(style);
				row.createCell(9).setCellValue(stud.getGpa());
				row.getCell(9).setCellStyle(style);
				row.createCell(10).setCellValue(stud.getFieldOfIntern());
				row.getCell(10).setCellStyle(style);
				row.createCell(11).setCellValue(stud.getCompany_name());
				row.getCell(11).setCellStyle(style);
				row.createCell(12).setCellValue(stud.getCompany_address());
				row.getCell(12).setCellStyle(style);
				row.createCell(13).setCellValue(stud.getInstructorName());
				row.getCell(13).setCellStyle(style);
				row.createCell(14).setCellValue(stud.getInstructorPosition());
				row.getCell(14).setCellStyle(style);
				row.createCell(15).setCellValue(stud.getInstructorEmail());
				row.getCell(15).setCellStyle(style);
				row.createCell(16).setCellValue(stud.getInstructorPhone());
				row.getCell(16).setCellStyle(style);
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public int getNumberTeacher() {
		return this.userRepo.getNumberTeacher();
	}
	
	public int getNumberStudent() {
		return this.userRepo.getNumberStudent();
	}
	
	public int getNumberCompany() {
		return this.companyRepo.getNumberCompany();
	}
	
	public static void setStyle(CellStyle style) {
		style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	}
	
	public static void setStyleOk(CellStyle style) {
		setStyle(style);
        style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
	}
	
	public static void setStyleNo(CellStyle style) {
		setStyle(style);
        style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
	}
}

package com.mcs.pmay.controller;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcs.pmay.data.PmayReportDataForAdmins;
import com.mcs.pmay.service.PmaySurveyService;

@Controller
public class PmayReportController {

	@Resource
	private PmaySurveyService pmaySurveyService;


	/**
	 * Handle request to download an Excel document
	 */
	@RequestMapping(value = "/downloadSurveyForSuperUser", method = RequestMethod.GET)
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {

		OutputStream out = null;
		try
		{
			
			List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getSurveyReportForSuperUser();
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition",  "attachment; filename=SurveyReport.xls");

			HSSFWorkbook workbook =  setRecord(surveyReports);
			out = response.getOutputStream();

			workbook.write(out);
			out.flush();
			out.close();

		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	private HSSFWorkbook  setRecord(List<PmayReportDataForAdmins> surveyList) {
		HSSFWorkbook workbook =  new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("Survey Report");

		HSSFRow header = sheet.createRow(0);
		int cell=0;
		header.createCell(cell++).setCellValue("Sr No)");
		header.createCell(cell++).setCellValue("Surveyor RMN (Registerd Mobile No)");
		header.createCell(cell++).setCellValue("Unique ID");
		header.createCell(cell++).setCellValue("Aadhaar No");
		header.createCell(cell++).setCellValue("Name");
		header.createCell(cell++).setCellValue("Father's/Husband's Name");

		header.createCell(cell++).setCellValue("Gender");
		header.createCell(cell++).setCellValue("DOB");
		header.createCell(cell++).setCellValue("Slum/Non-SLum");

		header.createCell(cell++).setCellValue("ULB Name");
		header.createCell(cell++).setCellValue("Preffered Component of the Mission");
		header.createCell(cell++).setCellValue("Eligibe/Non-Eligible");
		header.createCell(cell++).setCellValue("Long - Lat");

		int counter = 1;
		for (PmayReportDataForAdmins sd : surveyList) {
			HSSFRow row = sheet.createRow(counter++);
			int col=0;
			row.createCell(col++).setCellValue(counter-1);
			row.createCell(col++).setCellValue(sd.getUserRMN());
			row.createCell(col++).setCellValue(sd.getIdNumber());
			row.createCell(col++).setCellValue(sd.getAadharCardNumber());
			row.createCell(col++).setCellValue(sd.getFamilyHead());
			row.createCell(col++).setCellValue(sd.getFatherOrHusbandName());
			row.createCell(col++).setCellValue(sd.getGenderName());
			row.createCell(col++).setCellValue(sd.getDob()); 
			row.createCell(col++).setCellValue(sd.getSlumNonSlumStatus());
			row.createCell(col++).setCellValue(sd.getUlbName());

			row.createCell(col++).setCellValue(sd.getHfaCategoryName()); 
			row.createCell(col++).setCellValue(sd.getEligibleStatus());
			
			if(sd.getGeoLongitude()!=null && sd.getGeoLatitude()!=null) {
				row.createCell(col++).setCellValue(sd.getGeoLongitude()+"-"+sd.getGeoLatitude());	
			}else {
				row.createCell(col++).setCellValue("");
			}
			
		}
		
		return workbook;
	}

}

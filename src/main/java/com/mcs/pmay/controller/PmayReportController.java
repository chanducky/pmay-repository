package com.mcs.pmay.controller;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcs.pmay.data.PmayReportDataForAdmins;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.exceptions.UnauthorizedAccessException;
import com.mcs.pmay.service.PmaySurveyService;

/**
 * @author chandrakumar
 *
 */
@Controller
public class PmayReportController {

	@Resource
	private PmaySurveyService pmaySurveyService;


	/**
	 * Handle request to download an Excel document
	 * @throws Exception 
	 */
	@RequestMapping(value = "/downloadSurvey", method = RequestMethod.GET)
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

		OutputStream out = null;
		try
		{
			PmayUserData userData= 	(PmayUserData) request.getSession().getAttribute("userDtls");
			if(userData==null) {
				throw new UnauthorizedAccessException("User not logged in or Unauthorized.");
			}
			
			List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getSurveyReportForSuperUser();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String excelFileName = "SurveyReport-" + formatter.format(LocalDateTime.now()) + ".xlsx";
	        
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=" + excelFileName);

			SXSSFWorkbook workbook =  setRecord(surveyReports);
			out = response.getOutputStream();

			workbook.write(out);
			out.flush();
			out.close();

		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	private SXSSFWorkbook  setRecord(List<PmayReportDataForAdmins> surveyList) {
		SXSSFWorkbook workbook =new SXSSFWorkbook(100);
		SXSSFSheet sheet = workbook.createSheet();
		createHeader(sheet);
		
		int counter = 0;
		int rowNo=0;
		for (PmayReportDataForAdmins sd : surveyList) {
			++counter;
			if(rowNo >1 && (counter % 50000)==1){
				sheet = workbook.createSheet();
				createHeader(sheet);
				rowNo=0;
				
			}
			
			SXSSFRow row = sheet.createRow(++rowNo);
			int col=0;
			row.createCell(col++).setCellValue(counter);
			row.createCell(col++).setCellValue(sd.getUserRMN());
			row.createCell(col++).setCellValue(sd.getUserSurveyId());
			row.createCell(col++).setCellValue(sd.getAadharCardNumber());
			row.createCell(col++).setCellValue(sd.getFamilyHead());
			row.createCell(col++).setCellValue(sd.getFatherOrHusbandName());
			row.createCell(col++).setCellValue(sd.getGenderName());
			row.createCell(col++).setCellValue(sd.getDob()); 
			row.createCell(col++).setCellValue(sd.getSlumNonSlumStatus());
			row.createCell(col++).setCellValue(sd.getUlbName());
			row.createCell(col++).setCellValue(sd.getWardId());

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
	
	private void createHeader(SXSSFSheet sheet){
		
		SXSSFRow header = sheet.createRow(0);
		int cell=0;
		header.createCell(cell++).setCellValue("Sr No.");
		header.createCell(cell++).setCellValue("Surveyor RMN (Registerd Mobile No)");
		header.createCell(cell++).setCellValue("Survey ID");
		header.createCell(cell++).setCellValue("Aadhaar No");
		header.createCell(cell++).setCellValue("Name");
		header.createCell(cell++).setCellValue("Father's/Husband's Name");

		header.createCell(cell++).setCellValue("Gender");
		header.createCell(cell++).setCellValue("DOB");
		header.createCell(cell++).setCellValue("Slum/Non-SLum");

		header.createCell(cell++).setCellValue("ULB Name");
		header.createCell(cell++).setCellValue("Ward No");
		header.createCell(cell++).setCellValue("Preffered Component of the Mission");
		
		header.createCell(cell++).setCellValue("Eligibe/Non-Eligible");
		header.createCell(cell++).setCellValue("Long - Lat");
	}

}

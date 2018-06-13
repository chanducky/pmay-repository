
package com.mcs.pmay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chandrakumar
 *
 */
@Controller
public class PmayIndexController {
	@RequestMapping("/")
	String login() {
		return "login";
	}

	@RequestMapping("/index")
	String index() {
		return "index";
	}

	@RequestMapping("/surveyuser")
	String surveyuser() {
		return "surveyuser";
	}

	@RequestMapping("/superuser")
	String superuser() {
		return "superuser";
	}

	@RequestMapping("/forgot-pwd")
	String forgotpwd() {
		return "forgot-pwd";
	}

	@RequestMapping("/admin")
	String admin() {
		return "admin";
	}

	@RequestMapping("/super-admin")
	String superadmin() {
		return "superadmin";
	}

	@RequestMapping("/userReportExcel")
	String superUserReportExcelDownload() {
		return "superuser_report_excel";
	}

	@RequestMapping("/adminReportExcel")
	String adminReportExcelDownload() {
		return "admin_report_excel";
	}

	@RequestMapping("/deletedReportExcel")
	String deletedReportExcelDownload() {
		return "deleted_report_excel";
	}

	@RequestMapping("/pendingReportExcel")
	String pendingReportExcelDownload() {
		return "pending_report_excel";
	}

	@RequestMapping("/superAdminReportExcel")
	String superAdminReportExcelDownload() {
		return "superadmin_report_excel";
	}

	@RequestMapping("/surveyUserReportExcel")
	String surveyUserReportExcelDownload() {
		return "user_report_excel";
	}

}

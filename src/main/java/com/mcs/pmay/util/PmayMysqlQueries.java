
package com.mcs.pmay.util;

/**
 * @author chandrakumar
 *
 */
public class PmayMysqlQueries {
	private PmayMysqlQueries() {

	}

	public static final String IS_USER_EXIST_QUERY = "select count(*) from p_user where ? in(mobile_number,email_id)";
	public static final String INSERT_OTP_QUERY = "insert into p_otp values(?,?,now())";
	public static final String GET_VALID_OTP_QUERY = "select otp_number from p_otp where user_phno=? and otp_creation_time > DATE_SUB(NOW(),INTERVAL 5 MINUTE)";
	public static final String GET_USER_DETAILS_FOR_PASS_GENERATE_QUERY = "select user_id,first_name,last_name from p_user where mobile_number=?";
	public static final String INSERT_PASS_QUERY = "update p_user_login set user_password=? where user_id=?";
	public static final String GET_USER_DETAILS_QUERY = "select usr.user_id,rol.role_id,usr.ulb_name,usr.ulb_no,usr.first_name,usr.middle_name,usr.last_name,usr.email_id,usr.mobile_number,usrlogin.user_password,rol.role_name,usr.login_approval,usr.user_status from p_user usr,p_user_login usrlogin,p_roles rol,p_user_role_map rolmap where ? in(usr.mobile_number,usr.email_id) and usr.user_id=usrlogin.user_id and usr.user_id=rolmap.user_id and rolmap.role_id=rol.role_id";

	public static final String GET_STATE_DETAILS_QUERY = "SELECT state_id,state_name FROM p_state ORDER BY state_name ASC";
	public static final String GET_CITY_DETAILS_QUERY = "SELECT city_id,city_name,state_id FROM p_city ORDER BY city_name ASC";

	public static final String QUERY_FOR_GET_SUPER_USER_REPORT = "select pus.user_survey_id,pus.user_id,pus.family_head_name,pus.father_husband_name,pg.gender_name,DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS age, pms.marital_status_name,prg.religion_name,pus.aadhar_card_no, pit.id_type_name, pus.id_number,pus.slum_nonslum,pu.mobile_number,pus.ward_id,pus.eligibility_for_scheme,pus.reason_for_non_eligibility,pus.geo_lat, pus.geo_lon,pus.photo_attachment_name,pus.signature_of_applicant,pun.ulb_name from p_user_survey pus left outer join p_gender pg on pus.gender_id = pg.gender_id left outer join p_marital_status pms on pus.marital_status_id = pms.marital_status_id left outer join p_religion prg on pus.religion_id = prg.religion_id left outer join p_id_type pit on pus.id_type_id = pit.id_type_id left outer join preferred_assistance_hfa_category pac on pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id left outer join p_city pec on pus.permanent_city_id = pec.city_id LEFT OUTER JOIN pmay.p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id where deleted_flag='N' ";
	public static final String QUERY_FOR_GET_SURVEY_USER_REPORT = "SELECT pus.user_survey_id, pus.user_id, pus.ward_id, pwd.ward_name, pus.slum_nonslum, pus.validation_pending_non_slum, pus.eligibility_for_scheme, pus.family_head_name, pus.father_husband_name, pus.photo_attachment_name, pus.aadhar_card_no, pus.reason_for_aadhar_not_available, pus.id_type_id, pit.id_type_name, pus.id_number, pus.id_attachment_name, pus.gender_id, pg.gender_name, DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS date_of_birth, YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pus.marital_status_id, pms.marital_status_name, pus.religion_id, prg.religion_name, pus.religion_if_others, pus.caste_id, pc.caste_name, pus.reason_for_non_eligibility, pus.no_of_yrs_of_stay_present, pus.present_house_flat_no, pus.present_name_of_street, pus.present_city_id, prc.city_name, pus.present_mobile_number, pus.permanent_same_as_present, pus.no_of_yrs_of_stay_permanent, pus.perm_house_flat_no, pus.perm_name_of_street, pus.permanent_city_id, pec.city_name, pus.perm_mobile_number, pus.photo_attachment_in_front_of_house, pus.house_ownership_id, pus.geo_lat, pus.geo_lon, pus.house_type_roof_id, htr.house_type_roof_name, pus.house_type_wall_id, htw.house_type_wall_name, pus.no_room_dwelling_exc_kitchen, pus.size_of_exist_dwell_unit_carpet_area, pus.family_own_house_in_india, pus.if_yes_location_details_attachment, pus.if_yes_land_in_sq_m, pus.land_attachment_name, pus.housing_category_id, pus.housing_requirement_name, pus.name_of_pattadars, pus.patta_number, pus.dag_number, pus.land_area_as_in_patta, pus.dimension_of_land_length, pus.dimesnsion_of_land_breadth, pus.land_attachment1, pus.land_attachment2, pus.employement_category_id, pct.employment_category_name, pus.if_other_name, pus.average_monthly_income, pus.income_proof_attachment, pus.family_have_bpl_card, pus.if_yes_bpl_card_number, pus.bpl_card_attachment, pus.family_have_ration_card, pus.if_yes_ration_card_number, pus.ration_card_attachment, pus.preferred_assistance_hfa_category_id, pac.preferred_assistance_hfa_category_name, pus.bank_account_number, pbd.bank_name, pus.branch_name, pus.branch_ifsc_code, pus.signature_of_applicant, pus.submitted_data, GROUP_CONCAT(sfd.name_of_family_member) AS name_of_family_member, GROUP_CONCAT(sfd.relationship_id) AS relationship_id, GROUP_CONCAT(pre.relationship_name) AS relationship_name, GROUP_CONCAT(sfd.gender_id) AS gender_id, GROUP_CONCAT(pgr.gender_name) AS family_member_gender_name, GROUP_CONCAT(sfd.age_of_family_member) AS age_of_family_member, GROUP_CONCAT(sfd.family_member_id_card_number) AS family_member_id_card_number, GROUP_CONCAT(sfd.survey_family_detail_id) AS survey_family_detail_id,pus.bank_id,pus.bank_name,pus.if_yes_land_address,pus.ulb_name_id,pun.ulb_name,pu.mobile_number FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  p_marital_status pms ON pus.marital_status_id = pms.marital_status_id  LEFT OUTER JOIN  p_religion prg ON pus.religion_id = prg.religion_id  LEFT OUTER JOIN  p_caste pc ON pus.caste_id = pc.caste_id  LEFT OUTER JOIN  p_id_type pit ON pus.id_type_id = pit.id_type_id  LEFT OUTER JOIN  p_city prc ON pus.present_city_id = prc.city_id  LEFT OUTER JOIN  p_city pec ON pus.permanent_city_id = pec.city_id  LEFT OUTER JOIN  p_house_ownership pho ON pus.house_ownership_id = pho.house_ownership_id  LEFT OUTER JOIN  p_house_type_on_roof htr ON pus.house_type_roof_id = htr.house_type_roof_id  LEFT OUTER JOIN  p_house_type_on_wall htw ON pus.house_type_wall_id = htw.house_type_wall_id  LEFT OUTER JOIN  p_employment_category pct ON pus.employement_category_id = pct.employement_category_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id  LEFT OUTER JOIN  p_housing_category phc ON pus.housing_category_id = phc.housing_category_id LEFT OUTER JOIN  p_bank_details pbd ON pus.bank_id = pbd.bank_id LEFT OUTER JOIN  p_survey_family_details sfd ON pus.user_survey_id = sfd.user_survey_id  LEFT OUTER JOIN  p_relationship pre ON sfd.relationship_id = pre.relationship_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id LEFT OUTER JOIN p_gender pgr ON sfd.gender_id = pgr.gender_id WHERE pus.deleted_flag = 'N' and pus.user_id=? GROUP BY pus.user_survey_id";
	//public static final String QUERY_FOR_GET_ADMINS_SURVEY_REPORT = "SELECT pus.user_survey_id, pus.user_id, pus.ward_id, pwd.ward_name, pus.slum_nonslum, pus.validation_pending_non_slum, pus.eligibility_for_scheme, pus.family_head_name, pus.father_husband_name, pus.photo_attachment_name, pus.aadhar_card_no, pus.reason_for_aadhar_not_available, pus.id_type_id, pit.id_type_name, pus.id_number, pus.id_attachment_name, pus.gender_id, pg.gender_name, DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS date_of_birth, YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pus.marital_status_id, pms.marital_status_name, pus.religion_id, prg.religion_name, pus.religion_if_others, pus.caste_id, pc.caste_name, pus.reason_for_non_eligibility, pus.no_of_yrs_of_stay_present, pus.present_house_flat_no, pus.present_name_of_street, pus.present_city_id, prc.city_name, pus.present_mobile_number, pus.permanent_same_as_present, pus.no_of_yrs_of_stay_permanent, pus.perm_house_flat_no, pus.perm_name_of_street, pus.permanent_city_id, pec.city_name, pus.perm_mobile_number, pus.photo_attachment_in_front_of_house, pus.house_ownership_id, pus.geo_lat, pus.geo_lon, pus.house_type_roof_id, htr.house_type_roof_name, pus.house_type_wall_id, htw.house_type_wall_name, pus.no_room_dwelling_exc_kitchen, pus.size_of_exist_dwell_unit_carpet_area, pus.family_own_house_in_india, pus.if_yes_location_details_attachment, pus.if_yes_land_in_sq_m, pus.land_attachment_name, pus.housing_category_id, pus.housing_requirement_name, pus.name_of_pattadars, pus.patta_number, pus.dag_number, pus.land_area_as_in_patta, pus.dimension_of_land_length, pus.dimesnsion_of_land_breadth, pus.land_attachment1, pus.land_attachment2, pus.employement_category_id, pct.employment_category_name, pus.if_other_name, pus.average_monthly_income, pus.income_proof_attachment, pus.family_have_bpl_card, pus.if_yes_bpl_card_number, pus.bpl_card_attachment, pus.family_have_ration_card, pus.if_yes_ration_card_number, pus.ration_card_attachment, pus.preferred_assistance_hfa_category_id, pac.preferred_assistance_hfa_category_name, pus.bank_account_number, pbd.bank_name, pus.branch_name, pus.branch_ifsc_code, pus.signature_of_applicant, pus.submitted_data, GROUP_CONCAT(sfd.name_of_family_member) AS name_of_family_member, GROUP_CONCAT(sfd.relationship_id) AS relationship_id, GROUP_CONCAT(pre.relationship_name) AS relationship_name, GROUP_CONCAT(sfd.gender_id) AS gender_id, GROUP_CONCAT(pgr.gender_name) AS family_member_gender_name, GROUP_CONCAT(sfd.age_of_family_member) AS age_of_family_member, GROUP_CONCAT(sfd.family_member_id_card_number) AS family_member_id_card_number, GROUP_CONCAT(sfd.survey_family_detail_id) AS survey_family_detail_id,pus.bank_id,pus.bank_name,pus.if_yes_land_address,pus.ulb_name_id,pun.ulb_name,pu.mobile_number,pus.created_on FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  p_marital_status pms ON pus.marital_status_id = pms.marital_status_id  LEFT OUTER JOIN  p_religion prg ON pus.religion_id = prg.religion_id  LEFT OUTER JOIN  p_caste pc ON pus.caste_id = pc.caste_id  LEFT OUTER JOIN  p_id_type pit ON pus.id_type_id = pit.id_type_id  LEFT OUTER JOIN  p_city prc ON pus.present_city_id = prc.city_id  LEFT OUTER JOIN  p_city pec ON pus.permanent_city_id = pec.city_id  LEFT OUTER JOIN  p_house_ownership pho ON pus.house_ownership_id = pho.house_ownership_id  LEFT OUTER JOIN  p_house_type_on_roof htr ON pus.house_type_roof_id = htr.house_type_roof_id  LEFT OUTER JOIN  p_house_type_on_wall htw ON pus.house_type_wall_id = htw.house_type_wall_id  LEFT OUTER JOIN  p_employment_category pct ON pus.employement_category_id = pct.employement_category_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id  LEFT OUTER JOIN  p_housing_category phc ON pus.housing_category_id = phc.housing_category_id LEFT OUTER JOIN  p_bank_details pbd ON pus.bank_id = pbd.bank_id LEFT OUTER JOIN  p_survey_family_details sfd ON pus.user_survey_id = sfd.user_survey_id  LEFT OUTER JOIN  p_relationship pre ON sfd.relationship_id = pre.relationship_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id LEFT OUTER JOIN p_gender pgr ON sfd.gender_id = pgr.gender_id WHERE pus.deleted_flag = 'N' ";
	public static final String QUERY_FOR_GET_ADMINS_SURVEY_REPORT = "SELECT pus.user_survey_id, pus.user_id, pwd.ward_name, pus.slum_nonslum, pus.validation_pending_non_slum, pus.eligibility_for_scheme,pus.family_head_name, pus.father_husband_name, pus.photo_attachment_name, pus.aadhar_card_no, pus.reason_for_aadhar_not_available,pg.gender_name,DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS date_of_birth, YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pus.reason_for_non_eligibility,  pus.photo_attachment_in_front_of_house, pus.geo_lat, pus.geo_lon, pac.preferred_assistance_hfa_category_name, pus.signature_of_applicant, pus.submitted_data,  pun.ulb_name,pu.mobile_number,DATE_FORMAT(pus.created_on, '%d/%m/%Y') AS created_on,pus.`ulb_name_id`,pus.`ward_id`,pus.`gender_id`,pus.`preferred_assistance_hfa_category_id`  FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id  LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id   LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id WHERE pus.deleted_flag = 'N' ";
	public static final String INSERT_USER_QUERY = "INSERT INTO  p_user ( user_id,first_name ,middle_name ,last_name ,email_id ,mobile_number ,login_approval,user_status ,created_by ,created_on) VALUES (?,?,?,?,?,?,?,'A',?,NOW())";
	public static final String INSERT_USER_LOGIN_QUERY = "insert into p_user_login(user_id,user_password,created_by,created_on) values(?,?,?,NOW())";
	public static final String DELETED_SURVEY_QUERY = "select pus.user_survey_id,pus.user_id,pus.family_head_name,pus.father_husband_name,pg.gender_name,YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pms.marital_status_name,prg.religion_name,pc.caste_name,pus.aadhar_card_no, pit.id_type_name, pus.id_number from p_user_survey pus left outer join p_gender pg on pus.gender_id = pg.gender_id left outer join p_marital_status pms on pus.marital_status_id = pms.marital_status_id left outer join p_religion prg on pus.religion_id = prg.religion_id left outer join p_caste pc on pus.caste_id = pc.caste_id left outer join p_id_type pit on pus.id_type_id = pit.id_type_id left outer join preferred_assistance_hfa_category pac on pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id left outer join p_city pec on pus.permanent_city_id = pec.city_id left outer join p_ward_details pwd on pus.ward_id = pwd.ward_id where deleted_flag='Y'";
	
	public static final String DELETE_SURVEY_QUERY = "delete from p_user_survey where user_survey_id=?";
	public static final String DELETE_FEOM_HOUSING_ENHANCEMENT = "delete from p_housing_enhancement where user_survey_id = ?";
	public static final String DELETE_FEOM_FAMILY_DETAILS = "delete from p_survey_family_details where user_survey_id = ?";
	
	public static final String PENDING_USER_QUERY = "SELECT user_id , ulb_name, ulb_no, first_name ,middle_name ,last_name ,email_id ,mobile_number,login_approval,user_status FROM p_user order by first_name";
	public static final String APPROVE_USER_QUERY = "update p_user set login_approval='1' where user_id=?";
	public static final String INSERT_USER_ROLE_QUERY = "insert into p_user_role_map(user_id,role_id,created_by,created_on) values (?,4,?,NOW())";
	public static final String IS_USER_APPROVE_QUERY = "select login_approval from p_user where mobile_number=?";
	public static final String REMOVE_SURVEY_QUERY = "update p_user_survey set deleted_flag='Y' where user_survey_id=?";
	public static final String GET_WARD_DETAILS_QUERY = "select ward_id,ward_name from p_ward_details";
	public static final String SURVEY_USER_REPORT_QUERY = "SELECT usr.user_id, concat(usr.first_name,' ',usr.last_name) as Username, ps.father_husband_name, pg.gender_name ,YEAR(CURDATE()) - YEAR(ps.date_of_birth) AS age, ms.marital_status_name,rel.religion_name, cst.caste_name, ps.aadhar_card_no, pid.id_type_name, ps.id_number,ps.user_survey_id from p_user usr, p_user_survey ps, p_gender pg, p_marital_status ms, p_religion rel, p_caste cst, p_id_type pid where ps.deleted_flag='N' and usr.user_id = ps.user_id and pg.gender_id = ps.gender_id and ms.marital_status_id = ps.marital_status_id and cst.caste_id = ps.caste_id and rel.religion_id = ps.religion_id and pid.id_type_id = ps.id_type_id";
	public static final String HOUSE_CATEGORY_DETAILS_QUERY = "select housing_category_id,housing_category_name from p_housing_category";
	/*
	 * All query declaration globally for DropDown Values
	 */
	public static final String GET_RELIGION_DATA = "select religion_id,religion_name  from p_religion";
	public static final String GET_CASTE_DATA = "select caste_id,caste_name from p_caste";
	public static final String GET_ID_DATA = "select id_type_id,id_type_name from p_id_type";
	public static final String GET_MARITAL_DATA = "select marital_status_id,marital_status_name from p_marital_status";
	public static final String GET_OWNERSHIP_DATA = "select house_ownership_id,house_ownership_name from p_house_ownership";
	public static final String GET_HOUSE_ROOF_DATA = "select house_type_roof_id,house_type_roof_name from p_house_type_on_roof";
	public static final String GET_HOUSE_WALL_DATA = "select house_type_wall_id,house_type_wall_name from p_house_type_on_wall";
	public static final String GET_REQUIREMENT_DATA = "select house_requirement_id,house_requirement_name from p_housing_requirement";
	public static final String GET_EMPLOYMENT_DATA = "select employement_category_id,employment_category_name from p_employment_category";
	public static final String GET_RELATIONSHIP_DATA = "select relationship_id,relationship_name from p_relationship";
	public static final String GET_GENDER_DATA = "select gender_id,gender_name from p_gender";
	public static final String GET_HFA_ASST_DATA = "select preferred_assistance_hfa_category_id,preferred_assistance_hfa_category_name from preferred_assistance_hfa_category";
	public static final String GET_BANK_DATA = "SELECT bank_id,bank_name FROM p_bank_details";
	public static final String GET_ULB_DATA = "SELECT ulb_name_id,ulb_name FROM p_ulb_name";
	
	/*
	 * Query declaration for saving survey
	 */
	public static final String SAVE_SURVEY_DATA = "insert into p_user_survey(user_survey_id, user_id, ward_id, slum_nonslum,validation_pending_non_slum,eligibility_for_scheme,family_head_name,father_husband_name,photo_attachment_name,aadhar_card_no,reason_for_aadhar_not_available,id_type_id,id_number,id_attachment_name,gender_id,date_of_birth,marital_status_id,religion_id,religion_if_others,caste_id,reason_for_non_eligibility,no_of_yrs_of_stay_present,present_house_flat_no,present_name_of_street,present_city_id,present_mobile_number,permanent_same_as_present,no_of_yrs_of_stay_permanent,perm_house_flat_no,perm_name_of_street,permanent_city_id,perm_mobile_number,photo_attachment_in_front_of_house,house_ownership_id,geo_lat,geo_lon,house_type_roof_id,house_type_wall_id,no_room_dwelling_exc_kitchen,size_of_exist_dwell_unit_carpet_area,family_own_house_in_india,if_yes_land_in_sq_m,land_attachment_name,housing_category_id,name_of_pattadars,patta_number,dag_number,land_area_as_in_patta,dimension_of_land_length,dimesnsion_of_land_breadth,land_attachment1,land_attachment2,employement_category_id,if_other_name,average_monthly_income,income_proof_attachment,family_have_bpl_card,if_yes_bpl_card_number,bpl_card_attachment,family_have_ration_card,if_yes_ration_card_number,ration_card_attachment,preferred_assistance_hfa_category_id,bank_account_number,bank_id,branch_name,branch_ifsc_code,signature_of_applicant,submitted_data,deleted_flag,created_by,created_on,bank_name,biometric_data,if_yes_land_address,ulb_name_id,housing_requirement_name)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,str_to_date(?,' %d/%m/%Y'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?,?)";
	public static final String SAVE_HOUSING_ENHANCEMENT_QUERY = "insert into p_housing_enhancement(housing_category_id,user_survey_id,created_by,created_on) values(?,?,?,NOW())";
	public static final String SAVE_FAMILY_RELATIONSHIP_QUERY = "insert into p_survey_family_details(user_survey_id,name_of_family_member,relationship_id,gender_id,age_of_family_member,family_member_id_card_number,created_by,created_on) values(?,?,?,?,?,?,?,now())";
	public static final String DELETE_FAMILY_RELATIONSHIP_QUERY = "delete from p_survey_family_details where user_survey_id = ?";
	
	/*
	 * Query declaration for updating survey
	*/
	public static final String UPDATE_SURVEY_DATA = "UPDATE p_user_survey SET user_id = ?, ward_id = ?,slum_nonslum = ?, validation_pending_non_slum = ?,eligibility_for_scheme = ?, family_head_name = ?,father_husband_name = ?, photo_attachment_name = ?,aadhar_card_no = ?, reason_for_aadhar_not_available = ?,id_type_id = ?, id_number = ?,id_attachment_name = ?, gender_id = ?, date_of_birth = str_to_date(?,' %d/%m/%Y'),marital_status_id = ?, religion_id = ?,religion_if_others = ?, caste_id = ?,reason_for_non_eligibility = ?, no_of_yrs_of_stay_present = ?,present_house_flat_no = ?, present_name_of_street = ?,present_city_id = ?, present_mobile_number = ?,permanent_same_as_present = ?, no_of_yrs_of_stay_permanent = ?,perm_house_flat_no = ?, perm_name_of_street = ?,permanent_city_id = ?, perm_mobile_number = ?,photo_attachment_in_front_of_house = ?, house_ownership_id = ?,geo_lat = ?, geo_lon = ?,house_type_roof_id = ?, house_type_wall_id = ?,no_room_dwelling_exc_kitchen = ?, size_of_exist_dwell_unit_carpet_area = ?,family_own_house_in_india = ?,if_yes_land_in_sq_m = ?, land_attachment_name = ?,housing_category_id = ?, name_of_pattadars = ?,patta_number = ?, dag_number = ?,land_area_as_in_patta = ?, dimension_of_land_length = ?,dimesnsion_of_land_breadth = ?, land_attachment1 = ?,land_attachment2 = ?, employement_category_id = ?,if_other_name = ?, average_monthly_income = ?,income_proof_attachment = ?, family_have_bpl_card = ?,if_yes_bpl_card_number = ?, bpl_card_attachment = ?,family_have_ration_card = ?, if_yes_ration_card_number = ?,ration_card_attachment = ?, preferred_assistance_hfa_category_id = ?, bank_account_number = ?,bank_id = ?, branch_name = ?,branch_ifsc_code = ?,signature_of_applicant = ?, submitted_data = ?,deleted_flag = ?, last_updated_by = ?,last_updated_on = NOW(), bank_name = ?,if_yes_land_address = ?,biometric_data=?,ulb_name_id=?,housing_requirement_name=?  where user_survey_id = ?";
	public static final String UPDATE_HOUSING_ENHANCEMENT_QUERY =  "update p_housing_enhancement set housing_category_id=?,created_by=?,created_on=NOW() where user_survey_id=?";
	public static final String UPDATE_FAMILY_RELATIONSHIP_QUERY = "update p_survey_family_details name_of_family_member=?,relationship_id=?,gender_id=?,age_of_family_member=?,family_member_id_card_number=?,last_updated_by=?,last_updated_on=now()";
	
	public static final String GET_USER_ID =  "select user_id from p_user where mobile_number=?";
	public static final String UPDATE_GENERATED_PASS =  "update p_user_login set user_password= ? where user_id =?";
	public static final String IS_MOBILENO_EXIST_QUERY = "select count(*) from p_otp where user_phno=?";
	public static final String UPDATE_OTP_QUERY = "update p_otp set otp_number = ?,otp_creation_time= now() where user_phno =? ";
	
	/*
	 * Query declaration for saving slum survey report
	*/
	
	public static final String SAVE_SLUM_SURVEY_REPORT = "insert into p_user_survey(user_survey_id,user_id,slum_nonslum,family_head_name,father_husband_name,aadhar_card_no,reason_for_aadhar_not_available,gender_id,no_of_yrs_of_stay_present,present_house_flat_no,present_name_of_street,present_city_id,present_mobile_number,permanent_same_as_present,no_of_yrs_of_stay_permanent,perm_house_flat_no,perm_name_of_street,permanent_city_id,perm_mobile_number,religion_id,caste_id,family_own_house_in_india,if_yes_land_in_sq_m,signature_of_applicant,land_attachment_name,eligibility_for_scheme,reason_for_non_eligibility,ward_id,family_have_bpl_card,family_have_ration_card,submitted_data,deleted_flag,created_by,created_on,biometric_data,if_yes_land_address,id_type_id,id_number,id_attachment_name,ulb_name_id,marital_status_id,religion_if_others,date_of_birth,geo_lon,geo_lat,photo_attachment_name)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?,?,?,?,?,str_to_date(?,' %d/%m/%Y'),?,?,?)";
	public static final String UPDATE_SLUM_SURVEY_REPORT = "update p_user_survey set user_id=?,slum_nonslum=?,family_head_name=?,father_husband_name=?,aadhar_card_no=?,reason_for_aadhar_not_available=?,gender_id=?,no_of_yrs_of_stay_present=?,present_house_flat_no=?,present_name_of_street=?,present_city_id=?,present_mobile_number=?,permanent_same_as_present=?,no_of_yrs_of_stay_permanent=?,perm_house_flat_no=?,perm_name_of_street=?,permanent_city_id=?,perm_mobile_number=?,religion_id=?,caste_id=?,family_own_house_in_india=?,if_yes_land_in_sq_m=?,signature_of_applicant=?,land_attachment_name=?,eligibility_for_scheme=?,reason_for_non_eligibility=?,ward_id=?,family_have_bpl_card=?,family_have_ration_card=?,submitted_data=?,deleted_flag=?,last_updated_by=?,if_yes_land_address = ?,last_updated_on=NOW(),id_type_id=?,id_number=?,id_attachment_name=?,ulb_name_id=?,marital_status_id =?,religion_if_others =?,date_of_birth = str_to_date(?,' %d/%m/%Y'),biometric_data=?,geo_lon=?,geo_lat=?,photo_attachment_name=? where user_survey_id = ? ";
	public static final String CHECK_USER_LOGIN_QUERY = "select count(*) from p_user_login where user_id=?";
	public static final String UPDATE_USER_LOGIN_QUERY = "update p_user_login set user_password=?,last_updated_by=?,last_updated_on=NOW() where user_id=?";
	public static final String IS_ADHAR_EXIST_QUERY = "select count(*) from p_user_survey where aadhar_card_no=?";
	public static final String GET_NO_OF_YEARS_PRESENT_DATA = "SELECT no_of_years_stay_id,no_of_years_stay FROM pmay.p_no_of_years_stay";
	public static final String DELETE_USER_ROLE_MAP_QUERY = "delete from p_user_role_map where user_id=?";
	public static final String DELETE_PENDING_USER_QUERY = "delete from p_user where user_id=?";
	public static final String IS_ID_PROOF_EXIST_QUERY = "select count(*) from p_user_survey where id_number=?";
	public static final String GET_TODAY_SLUM_NONSLUM_SURVEY_REPORT = "SELECT (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum = 'S' AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) slum, (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum = 'N' AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) nonslum, (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum in('S','N') AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) total";
	public static final String GET_TOTAL_SLUM_NONSLUM_SURVEY_REPORT = "SELECT (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'S' and deleted_flag='N'  and `ulb_name_id` is not null ) slum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'N' and deleted_flag='N'  and `ulb_name_id` is not null ) nonslum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum in('S','N')  and deleted_flag='N' and `ulb_name_id` is not null ) total";
	//12th April
	//public static final String GET_ULB_SLUM_NONSLUM_SURVEY_REPORT = "SELECT (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'S' AND ulb_name_id=?) slum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'N' AND ulb_name_id=?) nonslum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum in('S','N') ) total";	
	public static final String UPDATE_STATUS_TO_ACTIVE_INACTIVE = "update p_user set user_status=?,last_updated_by=?,last_updated_on=NOW() where user_id=?";
	public static final String GET_USER_DETAILS_REPORT = "select usr.user_id,rol.role_id,usr.ulb_name,usr.ulb_no,usr.first_name,usr.middle_name,usr.last_name,usr.email_id,usr.mobile_number,usrlogin.user_password,rol.role_name,usr.login_approval from p_user usr,p_user_login usrlogin,p_roles rol,p_user_role_map rolmap where usr.user_id=usrlogin.user_id and usr.user_id=rolmap.user_id and rolmap.role_id=rol.role_id and rolmap.role_id in(2,3)";
	public static final String GET_USER_DETAILS_FOR_SUPER_ADMIN_REPORT = "select usr.user_id,rol.role_id,usr.ulb_name,usr.ulb_no,usr.first_name,usr.middle_name,usr.last_name,usr.email_id,usr.mobile_number,usrlogin.user_password,rol.role_name,usr.login_approval from p_user usr,p_user_login usrlogin,p_roles rol,p_user_role_map rolmap where usr.user_id=usrlogin.user_id and usr.user_id=rolmap.user_id and rolmap.role_id=rol.role_id and rolmap.role_id in(1,2,3)";
	
	public static final String DELETE_MULTIPLE_FROM_SURVEY_REPORT = "UPDATE p_user_survey SET deleted_flag = 'Y' WHERE user_survey_id = ?";
	
//	public static final String QUERY_FOR_GET_SURVEY_SUPER_USER_REPORT = "SELECT pus.user_survey_id, pus.user_id, pus.ward_id, pwd.ward_name, pus.slum_nonslum, pus.validation_pending_non_slum, pus.eligibility_for_scheme, pus.family_head_name, pus.father_husband_name, pus.photo_attachment_name, pus.aadhar_card_no, pus.reason_for_aadhar_not_available, pus.id_type_id, pit.id_type_name, pus.id_number, pus.id_attachment_name, pus.gender_id, pg.gender_name, DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS date_of_birth, YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pus.marital_status_id, pms.marital_status_name, pus.religion_id, prg.religion_name, pus.religion_if_others, pus.caste_id, pc.caste_name, pus.reason_for_non_eligibility, pus.no_of_yrs_of_stay_present, pus.present_house_flat_no, pus.present_name_of_street, pus.present_city_id, prc.city_name, pus.present_mobile_number, pus.permanent_same_as_present, pus.no_of_yrs_of_stay_permanent, pus.perm_house_flat_no, pus.perm_name_of_street, pus.permanent_city_id, pec.city_name, pus.perm_mobile_number, pus.photo_attachment_in_front_of_house, pus.house_ownership_id, pus.geo_lat, pus.geo_lon, pus.house_type_roof_id, htr.house_type_roof_name, pus.house_type_wall_id, htw.house_type_wall_name, pus.no_room_dwelling_exc_kitchen, pus.size_of_exist_dwell_unit_carpet_area, pus.family_own_house_in_india, pus.if_yes_location_details_attachment, pus.if_yes_land_in_sq_m, pus.land_attachment_name, pus.housing_category_id, pus.housing_requirement_name, pus.name_of_pattadars, pus.patta_number, pus.dag_number, pus.land_area_as_in_patta, pus.dimension_of_land_length, pus.dimesnsion_of_land_breadth, pus.land_attachment1, pus.land_attachment2, pus.employement_category_id, pct.employment_category_name, pus.if_other_name, pus.average_monthly_income, pus.income_proof_attachment, pus.family_have_bpl_card, pus.if_yes_bpl_card_number, pus.bpl_card_attachment, pus.family_have_ration_card, pus.if_yes_ration_card_number, pus.ration_card_attachment, pus.preferred_assistance_hfa_category_id, pac.preferred_assistance_hfa_category_name, pus.bank_account_number, pbd.bank_name, pus.branch_name, pus.branch_ifsc_code, pus.signature_of_applicant, pus.submitted_data, GROUP_CONCAT(sfd.name_of_family_member) AS name_of_family_member, GROUP_CONCAT(sfd.relationship_id) AS relationship_id, GROUP_CONCAT(pre.relationship_name) AS relationship_name, GROUP_CONCAT(sfd.gender_id) AS gender_id, GROUP_CONCAT(pgr.gender_name) AS family_member_gender_name, GROUP_CONCAT(sfd.age_of_family_member) AS age_of_family_member, GROUP_CONCAT(sfd.family_member_id_card_number) AS family_member_id_card_number, GROUP_CONCAT(sfd.survey_family_detail_id) AS survey_family_detail_id,pus.bank_id,pus.bank_name,pus.if_yes_land_address,pus.ulb_name_id,pun.ulb_name,pu.mobile_number FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  p_marital_status pms ON pus.marital_status_id = pms.marital_status_id  LEFT OUTER JOIN  p_religion prg ON pus.religion_id = prg.religion_id  LEFT OUTER JOIN  p_caste pc ON pus.caste_id = pc.caste_id  LEFT OUTER JOIN  p_id_type pit ON pus.id_type_id = pit.id_type_id  LEFT OUTER JOIN  p_city prc ON pus.present_city_id = prc.city_id  LEFT OUTER JOIN  p_city pec ON pus.permanent_city_id = pec.city_id  LEFT OUTER JOIN  p_house_ownership pho ON pus.house_ownership_id = pho.house_ownership_id  LEFT OUTER JOIN  p_house_type_on_roof htr ON pus.house_type_roof_id = htr.house_type_roof_id  LEFT OUTER JOIN  p_house_type_on_wall htw ON pus.house_type_wall_id = htw.house_type_wall_id  LEFT OUTER JOIN  p_employment_category pct ON pus.employement_category_id = pct.employement_category_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id  LEFT OUTER JOIN  p_housing_category phc ON pus.housing_category_id = phc.housing_category_id LEFT OUTER JOIN  p_bank_details pbd ON pus.bank_id = pbd.bank_id LEFT OUTER JOIN  p_survey_family_details sfd ON pus.user_survey_id = sfd.user_survey_id  LEFT OUTER JOIN  p_relationship pre ON sfd.relationship_id = pre.relationship_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id LEFT OUTER JOIN p_gender pgr ON sfd.gender_id = pgr.gender_id WHERE pus.deleted_flag = 'N' GROUP BY pus.user_survey_id ";
	public static final String QUERY_FOR_GET_SURVEY_SUPER_USER_REPORT = "SELECT pus.user_survey_id, pus.user_id,  pus.slum_nonslum, pus.eligibility_for_scheme, pus.family_head_name,pus.father_husband_name, pus.aadhar_card_no, pg.gender_name,DATE_FORMAT(pus.date_of_birth, '%d/%m/%Y') AS date_of_birth, YEAR(CURDATE()) - YEAR(pus.date_of_birth) AS age, pus.present_mobile_number,pus.perm_mobile_number,pus.geo_lat, pus.geo_lon,pac.preferred_assistance_hfa_category_name,pun.ulb_name,pu.mobile_number,pus.`ward_id`   FROM  p_user_survey pus LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id   LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id   LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id  LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id  WHERE pus.deleted_flag = 'N' order by pus.user_survey_id ;";

	public static final String INSERT_LOGGEDIN_HISTORY = "insert into user_loggedin_history(user_id,ip_address,created_on) values(?,?,now())";
	
	public static final String GET_USERS_LOGGEDIN_HISTORY = "select usr.user_id,uh.ip_address,rol.role_id,usr.ulb_name,usr.first_name,usr.middle_name,usr.last_name,usr.email_id,usr.mobile_number,rol.role_name,DATE_FORMAT(uh.created_on, '%Y-%m-%d %h:%m:%s') as loggedat from user_loggedin_history uh  inner join p_user usr on uh.user_id=usr.user_id inner join p_user_role_map rolmap  on usr.user_id=rolmap.user_id inner join  p_roles rol on rolmap.role_id=rol.role_id;";

	//public static final String QUERY_FOR_TOTAL_ADMINS_SURVEY_REPORT = "SELECT COUNT(*) FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  p_marital_status pms ON pus.marital_status_id = pms.marital_status_id  LEFT OUTER JOIN  p_religion prg ON pus.religion_id = prg.religion_id  LEFT OUTER JOIN  p_caste pc ON pus.caste_id = pc.caste_id  LEFT OUTER JOIN  p_id_type pit ON pus.id_type_id = pit.id_type_id  LEFT OUTER JOIN  p_city prc ON pus.present_city_id = prc.city_id  LEFT OUTER JOIN  p_city pec ON pus.permanent_city_id = pec.city_id  LEFT OUTER JOIN  p_house_ownership pho ON pus.house_ownership_id = pho.house_ownership_id  LEFT OUTER JOIN  p_house_type_on_roof htr ON pus.house_type_roof_id = htr.house_type_roof_id  LEFT OUTER JOIN  p_house_type_on_wall htw ON pus.house_type_wall_id = htw.house_type_wall_id  LEFT OUTER JOIN  p_employment_category pct ON pus.employement_category_id = pct.employement_category_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id  LEFT OUTER JOIN  p_housing_category phc ON pus.housing_category_id = phc.housing_category_id LEFT OUTER JOIN  p_bank_details pbd ON pus.bank_id = pbd.bank_id LEFT OUTER JOIN  p_survey_family_details sfd ON pus.user_survey_id = sfd.user_survey_id  LEFT OUTER JOIN  p_relationship pre ON sfd.relationship_id = pre.relationship_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id LEFT OUTER JOIN p_gender pgr ON sfd.gender_id = pgr.gender_id WHERE pus.deleted_flag = 'N' ";
	public static final String QUERY_FOR_TOTAL_ADMINS_SURVEY_REPORT = "SELECT count(*)  FROM  p_user_survey pus LEFT OUTER JOIN p_user pu ON pus.user_id = pu.user_id  LEFT OUTER JOIN p_ward_details pwd ON pus.ward_id = pwd.ward_id  LEFT OUTER JOIN  p_gender pg ON pus.gender_id = pg.gender_id  LEFT OUTER JOIN  preferred_assistance_hfa_category pac ON pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id   LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id WHERE pus.deleted_flag = 'N' ";
	
	
	public static final String GET_SURVEY_DATA_FOR_GEOTAG = "select us.user_survey_id,us.photo_attachment_name,signature_of_applicant,us.photo_attachment_in_front_of_house,us.slum_nonslum from p_user_survey us  where us.`user_survey_id` not in (select user_survey_id from p_geotag gt where gt.user_survey_id > ?) and us.user_survey_id >? and (us.`geo_lat` is NULL OR us.`geo_lat` =0.0  OR us.`geo_lon` is NULL OR us.`geo_lon`=0.0 ) limit 100; ";
	
	public static final String INSERT_GEOTAG_QUERY = "INSERT INTO p_geotag VALUES (?,?,?,NOW())";

	public static final String TOTAL_COUNT_QUERY_FOR_GET_SUPER_USER_REPORT = "select count(*) from p_user_survey pus left outer join p_gender pg on pus.gender_id = pg.gender_id left outer join p_marital_status pms on pus.marital_status_id = pms.marital_status_id left outer join p_religion prg on pus.religion_id = prg.religion_id left outer join p_id_type pit on pus.id_type_id = pit.id_type_id left outer join preferred_assistance_hfa_category pac on pus.preferred_assistance_hfa_category_id = pac.preferred_assistance_hfa_category_id left outer join p_city pec on pus.permanent_city_id = pec.city_id LEFT OUTER JOIN pmay.p_user pu ON pus.user_id = pu.user_id LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id where deleted_flag='N'";

	public static final String QUERY_DISTWISE_SLUM_NONSLUM_STATS="select ulb.`dist_name`,s.`slum_nonslum`,count(*) from `p_user_survey` s left JOIN `p_ulb_name` ulb on s.`ulb_name_id` = ulb.`ulb_name_id` where dist_name is not null and s.deleted_flag='N' GROUP BY ulb.`dist_name`,s.`slum_nonslum`;";
	
	public static final String QUERY_PKGWISE_SLUM_NONSLUM_STATS="select ulb.`pkg_name`,s.`slum_nonslum`,count(*) from `p_user_survey` s left JOIN `p_ulb_name` ulb on s.`ulb_name_id` = ulb.`ulb_name_id` where dist_name is not null and s.deleted_flag='N' GROUP BY ulb.`pkg_name`,s.`slum_nonslum` ORDER BY `slum_nonslum` desc;";
	
	
}

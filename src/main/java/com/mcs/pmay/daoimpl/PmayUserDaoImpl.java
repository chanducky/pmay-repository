/**
 * Created By: SRIBATSA
 * Created On: Feb 22, 20188:45:25 PM
 * File Name : PmayUserDaoImpl.java
 * Last Modified By : Smruti Ranjan
 * Last Modified On :
 */
package com.mcs.pmay.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mcs.pmay.dao.PmayUserDao;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.util.PmayMysqlQueries;
import com.mcs.pmay.util.PmayUtil;

@Repository("pmayUserDao")
public class PmayUserDaoImpl implements PmayUserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private HttpSession httpSession;

	@Override
	public int isUesrExist(String mobileNo) {
		return jdbcTemplate.queryForObject(PmayMysqlQueries.IS_USER_EXIST_QUERY, Integer.class, mobileNo);
	}

	@Override
	public boolean insertOtp(String mobileNo, int otp) {
		int mobileNoCount = jdbcTemplate.queryForObject(PmayMysqlQueries.IS_MOBILENO_EXIST_QUERY, Integer.class,
				mobileNo);
		if (mobileNoCount > 0) {
			int status = jdbcTemplate.update(PmayMysqlQueries.UPDATE_OTP_QUERY, otp, mobileNo);
			return status == 1;
		} else {
			int status = jdbcTemplate.update(PmayMysqlQueries.INSERT_OTP_QUERY, mobileNo, otp);
			return status == 1;
		}
	}

	@Override
	public boolean isValidOtp(Map<String, String> otpData) {
		String fetchedOtp = jdbcTemplate.queryForObject(PmayMysqlQueries.GET_VALID_OTP_QUERY, String.class,
				otpData.get("mobileNo"));
		return fetchedOtp.equals(otpData.get("otp"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmayUserDao#generatePassword(java.lang.String)
	 */
	@Override
	public String generatePassword(String mobileNo) {
		String password = null;
		@SuppressWarnings("unchecked")
		PmayUserData pmayUserData = (PmayUserData) jdbcTemplate
				.queryForObject(PmayMysqlQueries.GET_USER_DETAILS_FOR_PASS_GENERATE_QUERY, new UserMapper(), mobileNo);

		password = generatePassword(pmayUserData);
		System.out.println("generated password>>>>>>>" + password);
		jdbcTemplate.update(PmayMysqlQueries.INSERT_PASS_QUERY, PmayUtil.encryptPassword(password),
				pmayUserData.getUserId());
		return password;
	}
	
	

	/**
	 * @param pmayUserData
	 * @return
	 */
	private String generatePassword(PmayUserData pmayUserData) {
		StringBuilder password = new StringBuilder();
		if (pmayUserData.getFirstName().length() > 3) {
			password.append(pmayUserData.getFirstName().substring(0, 2).toUpperCase());
		} else {
			password.append(getRandomStringForPassword(2).toUpperCase());
		}
		password.append("@");
		Random rnd = new Random();
		password.append(100 + rnd.nextInt(900));

		if (pmayUserData.getLastName().length() > 3) {
			password.append(pmayUserData.getLastName().substring(0, 2).toLowerCase());
		} else {
			password.append(getRandomStringForPassword(2).toLowerCase());
		}
		return password.toString();
	}
	
	/**
	 * @param length
	 * @return RandomString
	 */
	private String getRandomStringForPassword(int length) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	@SuppressWarnings("rawtypes")
	public class UserMapper implements RowMapper {
		public PmayUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
			PmayUserData pmayUserData = new PmayUserData();
			pmayUserData.setUserId(rs.getString(1));
			pmayUserData.setFirstName(rs.getString(2));
			pmayUserData.setLastName(rs.getString(3));
			return pmayUserData;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmayUserDao#checkUserExist(java.util.Map)
	 */
	@Override
	public boolean checkUserExist(Map<String, String> loginData) {
		int count = jdbcTemplate.queryForObject(PmayMysqlQueries.IS_USER_EXIST_QUERY, Integer.class,
				loginData.get("userId"));
		return count != 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mcs.pmay.dao.PmayUserDao#registerUser(com.mcs.pmay.data.PmayUserData)
	 */
	@Override
	public boolean registerUser(PmayUserData pmayUserData) {
		int insertuser = jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.INSERT_USER_QUERY);
			ps.setString(1, pmayUserData.getUserId());
			ps.setString(2, pmayUserData.getFirstName());
			ps.setString(3, pmayUserData.getMiddleName());
			ps.setString(4, pmayUserData.getLastName());
			ps.setString(5, pmayUserData.getEmailId());
			ps.setString(6, pmayUserData.getMobileNo());
			ps.setString(7, "0");
			ps.setString(8, pmayUserData.getUserId());

			return ps;
		});
		if (insertuser != 0) {
			jdbcTemplate.update(PmayMysqlQueries.INSERT_USER_ROLE_QUERY, pmayUserData.getUserId(),
					pmayUserData.getUserId());
		}
		return insertuser != 0;
	}

	@Override
	public String approveUser(PmayUserData userData) {
		int status = 0;
		String password = generatePassword(userData);
		System.out.println("generated password>>>>>>>" + password);

		int chkIsUserLoginExist = checkUserExistInUserLoginTable(userData.getUserId());
		if (chkIsUserLoginExist != 0) {
			status = jdbcTemplate.update(PmayMysqlQueries.UPDATE_USER_LOGIN_QUERY, PmayUtil.encryptPassword(password),
					userData.getUserId(), userData.getUserId());
		} else {
			status = jdbcTemplate.update(PmayMysqlQueries.INSERT_USER_LOGIN_QUERY, userData.getUserId(),
					PmayUtil.encryptPassword(password), userData.getUserId());
		}

		if (status != 0) {
			jdbcTemplate.update(PmayMysqlQueries.APPROVE_USER_QUERY, userData.getUserId());
		}
		return password;
	}

	/**
	 * @param userId
	 * @return
	 */
	private int checkUserExistInUserLoginTable(String userId) {
		return jdbcTemplate.queryForObject(PmayMysqlQueries.CHECK_USER_LOGIN_QUERY, Integer.class, userId);
	}

	@Override
	public PmayUserData checkApprove(Map<String, String> loginData) {
		System.out.println("loginData in User Dao impl for check approve>>>>>>" + loginData);
		int count = jdbcTemplate.queryForObject(PmayMysqlQueries.IS_USER_APPROVE_QUERY, Integer.class,
				loginData.get("userId"));

		System.out.println("count in User Dao impl for check approve>>>>>>" + count);
		if (count != 0) {
			PmayUserData pmayUserData = jdbcTemplate.queryForObject(PmayMysqlQueries.GET_USER_DETAILS_QUERY,
					new RowMapper<PmayUserData>() {

						@Override
						public PmayUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
							PmayUserData pmayUserData = new PmayUserData();
							pmayUserData.setUserId(rs.getString(1));
							pmayUserData.setRoleId(rs.getInt(2));
							pmayUserData.setUlbName(rs.getString(3));
							pmayUserData.setUlbNo(rs.getString(4));
							pmayUserData.setFirstName(rs.getString(5));
							pmayUserData.setMiddleName(rs.getString(6));
							pmayUserData.setLastName(rs.getString(7));
							pmayUserData.setEmailId(rs.getString(8));
							pmayUserData.setMobileNo(rs.getString(9));
							pmayUserData.setPassword(rs.getString(10));
							pmayUserData.setRoleName(rs.getString(11));
							pmayUserData.setApprovalStatus(rs.getInt(12) != 0);
							pmayUserData.setStatus(rs.getString(13));
							return pmayUserData;
						}
					}, loginData.get("userId"));
			if (PmayUtil.decryptPassword(pmayUserData.getPassword(), loginData.get("password"))) {
				pmayUserData.setPasswordStatus(true);
				return pmayUserData;
			} else {
				pmayUserData.setPasswordStatus(false);
				return pmayUserData;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mcs.pmay.dao.PmayUserDao#updateGeneratedPassword(java.lang.String,
	 * com.mcs.pmay.data.PmayUserData)
	 */
	@Override
	public void updateGeneratedPassword(String password, PmayUserData mobileNo) {
		int passUserId = jdbcTemplate.queryForObject(PmayMysqlQueries.GET_USER_ID, Integer.class,
				mobileNo.getMobileNo());
		jdbcTemplate.update(PmayMysqlQueries.UPDATE_GENERATED_PASS, PmayUtil.encryptPassword(password), passUserId);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.dao.PmayUserDao#denyUser(com.mcs.pmay.data.PmayUserData)
	 */
	@Override
	public boolean denyUser(PmayUserData userData) {
		int deletePendingUser = 0;
		int deleteUserRoleMap = jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.DELETE_USER_ROLE_MAP_QUERY);
			ps.setString(1, userData.getUserId());
			return ps;
		});
		if (deleteUserRoleMap != 0) {
			deletePendingUser = jdbcTemplate.update(PmayMysqlQueries.DELETE_PENDING_USER_QUERY, userData.getUserId());
		}
		return deletePendingUser != 0;
	}

	@Override
	public boolean updateUserStatus(PmayUserData userData, Object adminId) {
		int changeStatus = 0;
		if(userData.getStatus().equals("A")){
	    changeStatus = jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.UPDATE_STATUS_TO_ACTIVE_INACTIVE);
			ps.setString(1, "N");
			ps.setString(2, (String) adminId);
			ps.setString(3, userData.getUserId());

			return ps;
		});
		}else{
			changeStatus = jdbcTemplate.update(connection -> {

				PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.UPDATE_STATUS_TO_ACTIVE_INACTIVE);
				ps.setString(1, "A");
				ps.setString(2, (String) adminId);
				ps.setString(3, userData.getUserId());

				return ps;
			});
		}
		
		return changeStatus != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmayUserDao#getPmayUserData()
	 */
	@Override
	public List<PmayUserData> getPmayUserData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_USER_DETAILS_REPORT,new RowMapper<PmayUserData>() {

					@Override
					public PmayUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
						PmayUserData pmayUserData = new PmayUserData();
						pmayUserData.setUserId(rs.getString(1));
						pmayUserData.setRoleId(rs.getInt(2));
						pmayUserData.setUlbName(rs.getString(3));
						pmayUserData.setUlbNo(rs.getString(4));
						pmayUserData.setFirstName(rs.getString(5));
						pmayUserData.setMiddleName(rs.getString(6));
						pmayUserData.setLastName(rs.getString(7));
						pmayUserData.setEmailId(rs.getString(8));
						pmayUserData.setMobileNo(rs.getString(9));
						pmayUserData.setPassword(rs.getString(10));
						pmayUserData.setRoleName(rs.getString(11));
						pmayUserData.setApprovalStatus(rs.getInt(12) != 0);
						return pmayUserData;
					}
				});
		
	}

	@Override
	public List<PmayUserData> getPmayUserDataForSuperAdmin() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_USER_DETAILS_FOR_SUPER_ADMIN_REPORT,new RowMapper<PmayUserData>() {

			@Override
			public PmayUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayUserData pmayUserData = new PmayUserData();
				pmayUserData.setUserId(rs.getString(1));
				pmayUserData.setRoleId(rs.getInt(2));
				pmayUserData.setUlbName(rs.getString(3));
				pmayUserData.setUlbNo(rs.getString(4));
				pmayUserData.setFirstName(rs.getString(5));
				pmayUserData.setMiddleName(rs.getString(6));
				pmayUserData.setLastName(rs.getString(7));
				pmayUserData.setEmailId(rs.getString(8));
				pmayUserData.setMobileNo(rs.getString(9));
				pmayUserData.setPassword(rs.getString(10));
				pmayUserData.setRoleName(rs.getString(11));
				pmayUserData.setApprovalStatus(rs.getInt(12) != 0);
				return pmayUserData;
			}
		}); 
	}

	@Override
	public boolean saveLoggedinHistory(PmayUserData pmayUserData) {
			int status = jdbcTemplate.update(PmayMysqlQueries.INSERT_LOGGEDIN_HISTORY,pmayUserData.getUserId(),pmayUserData.getUsrIp());
			return status == 1;
	}
	
	@Override
	public List<PmayUserData> getUsersLoggedinHistory() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_USERS_LOGGEDIN_HISTORY,new RowMapper<PmayUserData>() {

			@Override
			public PmayUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayUserData pmayUserData = new PmayUserData();
				pmayUserData.setUserId(rs.getString(1));
				pmayUserData.setUsrIp(rs.getString(2));
				pmayUserData.setRoleId(rs.getInt(3));
				pmayUserData.setUlbName(rs.getString(4));
				pmayUserData.setFirstName(rs.getString(5));
				pmayUserData.setMiddleName(rs.getString(6));
				pmayUserData.setLastName(rs.getString(7));
				pmayUserData.setEmailId(rs.getString(8));
				pmayUserData.setMobileNo(rs.getString(9));
				pmayUserData.setRoleName(rs.getString(10));
				pmayUserData.setCreatedOn(rs.getString(11));
				return pmayUserData;
			}
		}); 
	}

}

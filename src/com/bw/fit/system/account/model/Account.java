package com.bw.fit.system.account.model;

import com.bw.fit.system.user.model.User;
/****
 * 账户模型
 * @author yangh
 *
 */
public class Account extends User{

	private String logName;
	private String logPwd;
	private String verificationCode;
	private String currentOrgId; /****归属组织id***/
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public String getCurrentOrgId() {
		return currentOrgId;
	}
	public void setCurrentOrgId(String currentOrgId) {
		this.currentOrgId = currentOrgId;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogPwd() {
		return logPwd;
	}
	public void setLogPwd(String logPwd) {
		this.logPwd = logPwd;
	}
	
	
	
}

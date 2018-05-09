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
	
	
	public String getVerificationCode() {
		return verificationCode;
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

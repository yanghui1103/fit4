package com.bw.fit.component.warn.service;

import com.bw.fit.system.common.model.RbackException;

public interface WarnService {
	/*****
	 * 接收来自各个模块的预警需求
	 * @param warningLevel 预警级别:值详见数据字典
	 * @param warningType 预警方式 1:短信 2:系统即时消息 3:邮件
	 * @param target_number 手机号码;用户ID;email邮箱名称
	 * @param message 消息数据
	 * @return
	 * @throws RbackException
	 */
	public void sendWarning(String warningLevel,String warningType ,String target_number,String subject,String message) throws RbackException;
}

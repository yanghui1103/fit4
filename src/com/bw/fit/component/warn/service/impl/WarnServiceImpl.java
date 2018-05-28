package com.bw.fit.component.warn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.component.warn.service.WarnService;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.MailTool;
import com.bw.fit.system.common.util.SmsSender;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

@Service
public class WarnServiceImpl implements WarnService {

	@Autowired
	private DictDao dictDao ;
	@Override
	public void sendWarning(String warningLevel, String warningType,
			String target_number, String subject, String message)
			throws RbackException {
		Dict dict = dictDao.getDictByValue("warnLevel");
		List<DataDict> ds = dictDao.getDictsByParentId(dict.getId());
		Optional<DataDict> t = ds.stream().filter(x->x.getDict_value().equalsIgnoreCase(warningLevel)).findFirst();
		
		message = "[" + t.get().getDict_name()+"]" +message ;		
		if("1".equals(warningType)){
			try {
				SmsSender.SendSMSString(target_number, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RbackException("1","预警短信发送异常,地址:"+target_number); 
			}
		}else if("3".equals(warningType)){ 
			StringBuilder sb = new StringBuilder(message);
			try {
				MailTool.send(subject, sb, new InternetAddress[] { new InternetAddress(target_number) });
			} catch (AddressException e) {
				// TODO Auto-generated catch block
			}
		}else if("2".equals(warningType)){
			/****
			 * 发送即时消息
			 */
		} else{
			throw new RbackException("1","预警方式错误"); 
		}
	}

}

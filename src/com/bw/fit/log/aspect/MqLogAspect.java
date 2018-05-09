package com.bw.fit.log.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static com.bw.fit.common.util.PubFun.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.common.dao.DaoTemplete;
import com.bw.fit.log.entity.TLogInfo;
import com.bw.fit.log.service.ILogService;

/*****
 * 消息队列产品发送数据/消费数据的日志切面
 * 
 * @author yangh
 *
 */
@Component
public class MqLogAspect implements Ordered {
	@Autowired
	private DaoTemplete daoTemplete;
	@Autowired
	private ILogService iLogService;

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

	public void aroundMethod(ProceedingJoinPoint pjd) {
		// 通过分析aop监听参数分析出request等信息
		List<Object> list = Arrays.asList(pjd.getArgs());
		Object obj = null;
		try {
			Signature sig = pjd.getSignature();
			MethodSignature msig = null;
			if (!(sig instanceof MethodSignature)) {
				throw new IllegalArgumentException("该注解只能用于方法");
			}
			msig = (MethodSignature) sig;
			Object target = pjd.getTarget();
			Method currentMethod = target.getClass().getMethod(msig.getName(),
					msig.getParameterTypes());

			obj = pjd.proceed(); // 执行
			TLogInfo t = new TLogInfo();
			t.setLog_type_id("62");		 // 消息队列操作日志，选自数据字典 
			t.setOperator_id("system_mq_server"); // 
			t.setId(getUUID());
			t.setIp("major_system");
			t.setOperate_function(currentMethod.getName()); 
			if ((obj instanceof JSONObject)) {
				JSONObject j = (JSONObject)obj;
				t.setRes(j.get("res").toString());
				t.setMsg(j.get("msg").toString());
			}
			iLogService.notice(t);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

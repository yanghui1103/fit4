package com.bw.fit.system.log.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static com.bw.fit.system.common.util.PubFun.*;

import org.apache.shiro.session.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.log.entity.TLogInfo;
import com.bw.fit.system.log.service.ILogService;
/*****
 * 定时任务日志切面
 * @author yangh
 *
 */
@Component
public class JobLogAspect implements  Ordered {
	@Autowired
	private DaoTemplete daoTemplete ;
	@Autowired
	private ILogService iLogService;

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 4;
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
				t.setLog_type_id("59");		 // 定时任务操作日志，选自数据字典 
				t.setOperator_id("system_job_runner"); // 
				t.setId(getUUID());
				t.setIp("major_system");
				t.setOperate_function(currentMethod.getName()); 
				if ((obj instanceof JSONObject)) {
					JSONObject j = (JSONObject)obj;
					t.setRes(j.get("res").toString());
					t.setMsg(j.get("msg").toString());
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} 
}

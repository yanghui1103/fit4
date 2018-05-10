package com.bw.fit.system.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.common.controller.BaseController;

import static com.bw.fit.system.common.util.PubFun.*;

import com.bw.fit.system.account.model.Account;

@RequestMapping("system")
@Controller
public class SystemController extends BaseController {

	/****
	 * 登录请求
	 * @param account
	 * @param result
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String normalLogin(@Valid @ModelAttribute Account account,
			BindingResult result, HttpServletRequest request, Model model) {  
			Session session = getCurrentSession();
			try {
				model.addAttribute("account", account);		
				if(account==null||account.getLogName()==null||account.getLogPwd()==null){
					model.addAttribute("errorMsg", "请填写账号密码");
					return "system/common/loginPage";
				}
				// 如果当前客户端有未登出用户则还是去主页
				Account us_first = getCurrentAccount();
				if(us_first!=null||(us_first!=null &&!"".equals(us_first.getId()))){
					return "system/common/indexPage";
				} 				
				if (result.hasErrors()) {
					FieldError error = result.getFieldError();
					model.addAttribute("errorMsg", error.getDefaultMessage());
					return "system/common/loginPage";
				}
				// 获取存放在session中的验证码
				// String code = (String)
				// request.getSession().getAttribute("verificationCode");
				// 获取页面提交的验证码
				// String inputCode = account.getVerificationCode();
				// if(!code.toLowerCase().equals(inputCode.toLowerCase())) { //
				// 验证码不区分大小写
				// model.addAttribute("errorMsg", "验证码错误");
				// return "common/loginPage";
				// }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("errorMsg", "登录失败");
				return "system/common/loginPage";
			}

			/**** 开始shiro登录 *****/
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(
						account.getLogName(), account.getLogPwd());
				Subject currentUser = SecurityUtils.getSubject();
				token.setRememberMe(true);
				currentUser.login(token);
				session = currentUser.getSession();
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("errorMsg", "登录失败,认证拦截:" + e.getMessage());
				return "system/common/loginPage";
			}

			Account uu  = null ;
			session.setAttribute("CurrentUser", uu);
			return "system/common/indexPage";
	}
	
	/*****
	 * 统一调整方法
	 * @param path1 jsp下第一层路径
	 * @param path2
	 * @param pageName 必须带Page
	 * @param param 参数
	 * @param model UI-Model
	 * @return
	 */
	@RequestMapping("gotoIframePage/{path1}/{path2}/{pageName}/{param}")
	public String gotoIframePage(@PathVariable(value="path1") String path1,@PathVariable(value="path2") String path2,
			@PathVariable(value="pageName") String pageName,@PathVariable(value="param") String param,Model model){
		
		return path1+"/"+path2+"/"+pageName  ;
	}
}

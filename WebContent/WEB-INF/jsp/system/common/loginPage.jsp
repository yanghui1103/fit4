<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include
	page="/common.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html> 
<html lang="en"> 
<body class="default">
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
			<span class="sys-name">协同平台</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<form>
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" name="username" placeholder="账号/邮箱">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" name="password" placeholder="请输入密码">
							</div>
							<div class="lg-check clearfix">
								<div class="input-item">
									<i class="iconfont">&#xe633;</i>
									<input type="text" placeholder="验证码">
								</div>
								<span class="check-code">XD34F</span>
							</div>
						<div class="alert alert-error">
			              <i class="iconfont">&#xe62e;</i>
			              <span>${errorMsg }</span>
			            </div>
							<div class="enter">
								<a href="javascript:;" class="purchaser" onClick="javascript:login();">登录</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
			</div>
			<div class="address">地址：内蒙古鄂尔多斯市东胜区天骄北路&nbsp;邮编：210019&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2015&nbsp;-&nbsp;2016&nbsp;&nbsp;版权所有</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			alert("sdfdf");
		});
	</script>
</body> 
</html>
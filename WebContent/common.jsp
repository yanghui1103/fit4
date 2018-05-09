<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/login/login.css" rel="stylesheet">
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
<link href="<%=basePath %>common/fit/v4/custom/green/uimaker/easyui.css"  rel="stylesheet" >
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
<!-- fit v3.0 start use -->
<style type="text/css">
	@media screen and (max-width: 1000px) {
		.fit_form_row {
			float:left;
			margin-bottom: 20px;
			width: 45%;
			margin-right:2%;
		}
		.fit_form_row input {
			width: 250px;
		}
	}
	@media screen and (min-width: 1000px) {
		.fit_form_row {
			float:left;
			margin-bottom: 20px;
			width: 24%;
			margin-right:1%;
		}
		.fit_form_row input {
			width: 250px;
		}
		.fit_form_row select {
			width: 250px;
		}
		
	}
</style>
<script  type="text/javascript">
$(function(){
	var $box_w = $(".fit_form_row").width();
	$("input").width($box_w - 85); 
	$("select").width($box_w - 85); 
})
</script>
</head> 
</html>
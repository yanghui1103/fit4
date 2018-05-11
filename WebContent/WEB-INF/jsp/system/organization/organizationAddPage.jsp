<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
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
</head>
<body>
	<div style="margin:20px 0;"></div>
	<form  class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<input class="easyui-textbox"  id="code1" style="width: 80%"
				data-options="label:'组织编码',required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<input class="easyui-textbox" name="role_name" id="123d" style="width: 80%"
				data-options="required:true,prompt:'请输入组织名称'">
		</div>
	<script type="text/javascript">
		$(function(){
			$('#code1').textbox({
				label:"组织编码",
				prompt: '请输入组织编码'
			});
		});
	</script>
	</form>	
</body>
</html>
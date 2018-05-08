<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.bw.fit.common.util.*" pageEncoding="UTF-8"%><jsp:include
	page="/common.jsp"></jsp:include>
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
<style> 
.div-a{ float:left;width:50%} 
.div-b{ float:left;width:50%} 
.div-c{ float:right;width:50%} 
</style> 
</head>
<body>

	<form 
		id="roleEditPageFm" class="easyui-form" method="post"
		data-options="novalidate:false">
	<div style="margin: 2px 0;">
		<input type="hidden" name="role_id" id="editRoleRoleId" data-options="required:true" value="${role.fdid }" />
		<input type="hidden"  id="editRoleParentRoleId"  value="${role.parent_id }" />
	</div>
	<div class="div-a">
	<div class="easyui-panel"
		data-options="region:'west',split:true,title:'父角色(${role.parent_role_name})之菜单栏'"
		style="padding: 5px;">
		<ul class="easyui-tree" id="editRolePageMenuTree"
			data-options="url:'<%=basePath%>system/getMenuAuthTreeJsonByRoleId/${role.parent_id}',method:'get',animate:true,dnd:true"></ul>
	</div>
	</div>
	<div class="div-b">
	<div class="easyui-panel " id="editRolePageMenuArea"
		style="height: 200px; padding: 10px;"   		
		data-options="region:'east',title:'菜单区域'""></div>
		</div>
	<div class="div-b">
	<div class="easyui-panel " id="editRolePageOperationArea"
		style="height: 220px; padding: 10px;"
		data-options="region:'east',title:'功能区域'""></div>
		</div>
	<div class="div-c">
	<div class="easyui-panel "
		style="height: 220px; padding: 10px;" id="editRolePageEleArea"
		data-options="region:'east',title:'其他元素区域'""></div>
		</div>
		
	<div style="position: fixed; right: 30px; bottom: 20px;">
		<button class="easyui-linkbutton" type=button onclick="roleEditSubmitFm()"
			style="width: 80px">保存</button>
	</div>
	</form>
</body>
<script type="text/javascript">
$(function(){	
	$("#editRolePageMenuTree").tree({
		onDblClick:function(node){
			var editRoleRoleId = (document.getElementById("editRoleRoleId").value);
			$("#editRolePageMenuArea").empty();
			$("#editRolePageOperationArea").empty();
			$("#editRolePageEleArea").empty();
			$.post(ctx+"system/getMenuArrayByRoleId/"+editRoleRoleId,function(data){
				
				if(data.length<1){// if data is null 
					var $input = $("<input type=checkbox id=editRole_menu_id name=menu_id onchange='editRolePageClk(this)' value='"+node.id+"'  /><label>"+node.text+"</label>  ");
					$("#editRolePageMenuArea").append($input);
				}else{
					var flag = false ; 
					for(var i=0;i<data.length;i++){
						if(data[i].fdid == node.id){
							flag = true ;
						} 
					}  
					if(flag){ 
							var $input = $("<input type=checkbox id=editRole_menu_id name=menu_id  onchange='editRolePageClk(this)' checked=checked value='"+node.id+"'  /><label>"+node.text+"</label>  ");
							$("#editRolePageMenuArea").append($input);
							editRolePageClk(document.getElementById("editRole_menu_id"));
						}else{
							var $input = $("<input type=checkbox id=editRole_menu_id name=menu_id  onchange='editRolePageClk(this)' value='"+node.id+"'  /><label>"+node.text+"</label>  ");
							$("#editRolePageMenuArea").append($input); 
					}
				}

			});
		}
	});
});
/****
 * 菜单区域，选中时候触发
 */
function editRolePageClk(obj){
	var editRoleRoleId = (document.getElementById("editRoleRoleId").value);
	var editRoleParentRoleId = (document.getElementById("editRoleParentRoleId").value);
	if(obj.checked){
		$.post(ctx+"system/getOperationsByMenuId/"+obj.value+"/"+editRoleRoleId+"/"+editRoleParentRoleId,function(data){
			if(data.res =="1")
				return ;
			var list = data.list ;
			$("#editRolePageOperationArea").empty();
			$.each(list,function(index){
				if(list[index].checked=="1"){
					$input = $("<input type=checkbox name=operation_id  value='"+list[index].fdid+"' checked=checked /><label>"+list[index].operate_name+"</label>  ");
				}else{
					$input = $("<input type=checkbox name=operation_id  value='"+list[index].fdid+"'   /><label>"+list[index].operate_name+"</label>  ");
				}
				$("#editRolePageOperationArea").append($input);
			});
		});

		$.post(ctx+"system/getElementsByMenuId/"+obj.value+"/"+editRoleRoleId+"/"+editRoleParentRoleId,function(data){
			if(data.res =="1")
				return ;
			var list = data.list ;
			$("#editRolePageEleArea").empty();
			$.each(list,function(index){
				if(list[index].checked=="1"){
					var $input = $("<input type=checkbox name=element_id  value='"+list[index].fdid+"' checked=checked  /><label>"+list[index].element_name+"</label>  ");
				}else{
					var $input = $("<input type=checkbox name=element_id  value='"+list[index].fdid+"'  /><label>"+list[index].element_name+"</label>  ");
				}
				$("#editRolePageEleArea").append($input);
			});
			
			
		});
	}else{
		$("#editRolePageOperationArea").empty();
		$("#editRolePageEleArea").empty();
	}
}


function roleEditSubmitFm() {
	if (!$("#roleEditPageFm").form('enableValidation')
			.form('validate')) {
		return;
	} 
 
    var FileController =  ctx + "system/updateRole"  ;                    
    // FormData 对象
    var form = new FormData();
    form.append("author", $("#editRoleRoleId").val());                        
    form.append("role_id", $("#editRoleRoleId").val());                      
    form.append("menu_id", $("#editRole_menu_id").val());    
    var operation_id = document.getElementsByName('operation_id');
    var value = new Array();
    for(var i = 0; i < operation_id.length; i++){
     if(operation_id[i].checked)
     	value.push(operation_id[i].value);
    } 
    form.append("operation_ids", value);  
    var element_id = document.getElementsByName('element_id');
    value = new Array();
    for(var i = 0; i < element_id.length; i++){
     if(element_id[i].checked)
     	value.push(element_id[i].value);
    } 
    form.append("element_ids", value);                       
    // XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();
    xhr.open("post", FileController, true); 
    xhr.send(form);
    xhr.onreadystatechange = function() {
        	  if(xhr.readyState == 4 && xhr.status == 200){
	        	  var data = JSON.parse(xhr.responseText) ;                   
      			  promptMessage(data.res,data.msg); 
         }
    }
}
</script>
</html>
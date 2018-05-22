/**
 * 
 */


$(function(){
	rolelistquery();
});


function rolelistquery(){    
	$('#roleListDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'role/roles' ,   
        queryParams:   serializeFormToJSON($("#rolelistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'name', title: '名称', width: '40%',fixed:true  },
                   { field: 'temp_str1', title: '正在使用人数', width: '20%' },
                   { field: 'creator', title: '创建者', width: '20%' }, 
                   { field: 'createTime', title: '创建日期', width: '20%' } 
               ]],
             fit: false ,    
             idField: "id",
             pagination: true,
             singleSelect:true,
             rownumbers: true, 
             fitColumns:true,
             pageNumber: 1,
             pageSize: 10,
             pageList: [ 10,20, 30, 40, 50],
             striped: true //奇偶行是否区分      
	});  
}




//增加查询参数，在页面加载时运行  
function roleReloadgrid() {  
	$('#roleListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#roleListDg').datagrid('options').queryParams= serializeFormToJSON($("#rolelistFM").serializeArray());  
	$("#roleListDg").datagrid('reload');
}  


function deleteRole(){	 
	var row = getSingleTreeGridSelectData($("#roleListDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认删除该角色？",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "role/role/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						roleReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}

	
	
}

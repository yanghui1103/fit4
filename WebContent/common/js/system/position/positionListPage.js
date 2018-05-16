/**
 * 
 */

$(function(){
	positionlistquery();
});


function positionlistquery(){    
	$('#positionLiDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'position/positions/' ,   
      //  queryParams:   serializeFormToJSON($("#userlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'code', title: '编码', width: '20%',fixed:true  },
                   { field: 'name', title: '名称', width: '30%' },
                   { field: 'simpleName', title: '简称', width: '20%' }, 
                   { field: 'name', title: '所属组织', width: '30%'  }
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
function positionReloadgrid() {  
	$('#positionLiDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
 // $('#positionLiDg').datagrid('options').queryParams= serializeFormToJSON($("#userlistFM").serializeArray());  
  $("#positionLiDg").datagrid('reload');
}  


/**
 * 
 */

$(function(){
	userlistquery();
});


function userlistquery(){    
	$('#userLiDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'user/users' ,   
        queryParams:   serializeFormToJSON($("#userlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'name', title: '名称', width: '20%',fixed:true  },
                   { field: 'name', title: '帐号', width: '20%' },
                   { field: 'name', title: '联系电话', width: '20%' }, 
                   { field: 'name', title: '岗位', width: '20%' }, 
                   { field: 'name', title: '所属公司', width: '20%',sortable:true }
               ]],
             fit: true,    
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

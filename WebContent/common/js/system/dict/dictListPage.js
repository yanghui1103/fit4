/**
 * 
 */



function deleteDict(){	 
	var row = getSingleTreeGridSelectData($("#dataDictTreeGd"));
	if(row !=null){			
		var url = ctx + "dict/dict/"+row.id ;
		$.get(url,function(data){
			if(data.canDel=="0"){
				promptMessage("1","不允许删除本节点");		
			}	else{
				promptMessageCallBack("3","是否确认删除该记录",function(){
					
					$.ajax({
						type : 'DELETE',
						url : ctx + "dict/dict/"+row.id,
						data : {},
						success : function(data) {
							promptMessage(data.res, data.msg );
						},
						dataType : "JSON"
					});
					
					
				});
			}	
		});
	}
}
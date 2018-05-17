/**
 * 
 */

function addNewPosition(){	 
	if (!$("#positionAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "dict/dict",
		data : serializeFormToJSON($("#positionAddFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				 $('#dataDictTreeGd').treegrid('reload');  
			} );
		},
		dataType : "JSON"
	});

	
}
/**
 * 
 */
$(function(){
		$(".address-select").textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					openAddress($("#_loadDialog_address"),$("input[name='temp_str1']"),$(".address-select"));
				}
			}]
		})
	});

function editPosition(){
	if (!$("#positionEditFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'post',
		url : ctx + "dict/dict",
		data : serializeFormToJSON($("#positionEditFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				 $('#dataDictTreeGd').treegrid('reload');  
			} );
		},
		dataType : "JSON"
	});
}
/**
 * add org
 */

function addOrg(){
	if (!$("#orgAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "org/organization",
		data : serializeFormToJSON($("#orgAddFm")
				.serializeArray()),
		success : function(data) {
			promptMessage(data.res, data.msg );
		},
		dataType : "JSON"
	});
}

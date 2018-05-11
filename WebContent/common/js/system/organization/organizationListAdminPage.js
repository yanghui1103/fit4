/**
 * org admin
 */
function printOrgDetailInfo(org){ 
	// alert(getDictNameByValue("depoartment"));
	$("#name1").text(org.name);
	$("#code").text(org.code);
	$("#simpleName").text(org.simpleName);
	$("#type").text(getDictNameByValue(org.type));
	$("#isVisible").text(org.isVisible);
	$("#adminer").text(org.adminer);
	$("#phone").text(org.phone);
	$("#address").text(org.address);
	$("#postCode").text(org.postCode);
	$("#summary").text(org.summary);
}
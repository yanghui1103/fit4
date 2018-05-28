/**
 * 
 */

function moveOption(e1, e2){
    try{ 
       for(var i=0;i<e1.options.length;i++){ 
    	   if(e1.options[i].selected){ 
    		   var e = e1.options[i];
    		   var flag = true;
    		   for(var j=0;j<e2.options.length;j++){
    			   if(e.value==e2.options[j].value){
    				   flag = false;
    				   break;
    			   }
    		   }
    		   if(flag){
    			   e2.options.add(new Option(e.text, e.value)); 
    		   }
    		   e1.remove(i);
	       } 
	    } 
       	document.myform.selectids.value=getvalue(document.myform.list2);
       	document.myform.selectnames.value=getname(document.myform.list2);
    } 
    catch(e){} 
} 

function getvalue(geto){ 
    var allvalue = ""; 
    for(var i=0;i<geto.options.length;i++){ 
       allvalue +=geto.options[i].value + ","; 
    } 
    return allvalue; 
 } 
function getname(geto){ 
    var allname = ""; 
    for(var i=0;i<geto.options.length;i++){ 
    	allname +=geto.options[i].text + ","; 
    } 
    return allname; 
 }

/****
 * 通用打开地址本
 * @param obj
 */
function openAddress(dlgObj,idsObj,namesObj){
	dlgObj.dialog({    
	    title: '地址本',    
	    width: 800,    
	    height: 400,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'address/openAddressPage/true/true/true/'+idsObj.val(),    
	    modal: true   ,
	    buttons:[{
			text:'确定',
			handler:function(){
				var selectids = $("#selectids").val();
				idsObj.val(  selectids);
				var selectNames = $("#selectnames").val();
				namesObj.textbox('setValue', selectNames);
				dlgObj.dialog("close");
			}
		}]
	});
}

function checkboxClick(){
	var orgId = $("#addr_org_id").val();
	changeConstraintTerm(orgId);
}

/******
 * 更改待选列表
 * @param orgId
 * @returns
 */
function changeConstraintTerm(orgId){
	var isOrg = $("#select_org").is(':checked');
	var isPosition = $("#select_position").is(':checked');
	var isAccount = $("#select_account").is(':checked');
	$.ajax({
		type : 'GET',
		url : ctx + "address/address/"+orgId+"/"+isOrg+"/"+isPosition+"/"+isAccount,
		data : {},
		success : function(data) {
			if(data.res=="2"){
				//console.info(data.addressMap);
				$("#dxlb_select").empty();
				$.each(data.addressMap, function(key,values){     
					var option = "<option value='"+key+"'>"+values+"</option>"
					$("#dxlb_select").append(option);
				 });
			}else{
				promptMessage(data.res,data.msg) ;
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert({
	            title: '提示信息',
	            ok: '确定',
	            icon: 'error',
	            cancel: '取消',
	            msg: errorThrown
	          });
		},
		dataType : "JSON"
	});
}
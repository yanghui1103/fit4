/**
 * 岗位管理JS
 */

var zNodes ='';

var setting = {
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType: { "Y": "", "N": "" }
			},
			data: {
				key: {
					title: "t"
				},
				simpleData: {
					enable: true
				}				
			}
		};


$(document).ready(function(){
	$.get(ctx+"org/organizations",function(data){ 
		if(data.res =="2"){ 
			zNodes = (data.list) ; 					
			$.fn.zTree.init($("#positionTree"), setting, zNodes);
			
		}
	});
	
});
		
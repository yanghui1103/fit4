/**
 * 岗位管理JS
 */

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
var zNodes =[
	{ id:1, pId:0, name:"随意勾选 1", open:true},
	{ id:11, pId:1, name:"随意勾选 1-1", open:true},
	{ id:111, pId:11, name:"随意勾选 1-1-1"},
	{ id:112, pId:11, name:"随意勾选 1-1-2"},
	{ id:12, pId:1, name:"随意勾选 1-2", open:true},
	{ id:121, pId:12, name:"随意勾选 1-2-1"},
	{ id:122, pId:12, name:"随意勾选 1-2-2"},
	{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
	{ id:21, pId:2, name:"随意勾选 2-1"},
	{ id:22, pId:2, name:"随意勾选 2-2", open:true},
	{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
	{ id:222, pId:22, name:"随意勾选 2-2-2"},
	{ id:23, pId:2, name:"随意勾选 2-3"}
];

var code;


function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

$(document).ready(function(){
	$.fn.zTree.init($("#positionTree"), setting, zNodes);
});
		
/**
 * 
 */

function moveOption(e1, e2){
    try{ 
       for(var i=0;i<e1.options.length;i++){ 
    	   if(e1.options[i].selected){ 
    		   var e = e1.options[i]; 
               e2.options.add(new Option(e.text, e.value)); 
               e1.remove(i); 
               ii=i-1 	
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
	    href: ctx+'address/openAddressPage/105/1/-1/-1',    
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
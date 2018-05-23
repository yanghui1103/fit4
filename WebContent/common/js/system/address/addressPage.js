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
       	document.myform.city.value=getvalue(document.myform.list2); 
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

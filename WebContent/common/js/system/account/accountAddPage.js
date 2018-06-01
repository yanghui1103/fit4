/**
 * 
 */


$(function(){
		$(".address-select-position").textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					openAddress($("#_loadDialog_address"),$("input[name='postionIds']"),$(".address-select-position"),"P",true);
				}
			}]
		})
	});



	var v=  $.noConflict();
v(document).ready(function(){
		 v('[rel=popover]').popover({
			    html:true,
			    placement:'bottom',
			    content:function(){
			        return $($(this).data('contentwrapper')).html();
			    }
			});
	});
	
	
	
	
	
	
	
	
	
	
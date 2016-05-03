<!doctype html>
<html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head><script src="http://d3js.org/d3.v3.min.js"></script>
  <script src="http://dimplejs.org/dist/dimple.v2.0.0.min.js"></script>
    <script src="js/jquery.js"></script>
    </head>
<body>
<div align="center">
<form  id="chart" name="chart" method="post" action="BarChart" >
<!-- action="BarChart" -->
<div class="row">
<div class="col-md-3">
<select class="form-control" name="name"
				id="iname">
				<s:iterator value="cname">
					<option value="<s:property/>"> <s:property/> </option>
				</s:iterator>
			</select>
</div>

<div class="col-md-3">
<select class="form-control" name="Time">
<option value="month" >monthly</option>
<option value="year" >Yearly</option>

</select>
</div>

<div class="col-md-3">
<select class="form-control" name="chart">
<option value="bar" >Bar</option>
<option value="pie" >Pie</option>
<option value="bubble">Bubble</option>
</select>
</div>


	<div class="col-md-2">
	<input class="form-control" type="submit" value="submit">
	
</div>
</div>
</form>
</div>
 
</body>


<!--  
<script>

function addfacultyscript(form)
{
	var xmlhttp;
	alert("form submit");
	if (window.XMLHttpRequest)
	  xmlhttp=new XMLHttpRequest();
	else
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		  {
		  alert("jnji");
		    document.getElementById("mychart").innerHTML=xmlhttp.responseText;
		  }    	  
		  };
	xmlhttp.open("POST","./BarChart",true);
   var formData = new FormData(form);
	xmlhttp.send(formData);
}

</script> -->


</html>
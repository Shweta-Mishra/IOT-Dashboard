<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"> 
		<script src="http://d3js.org/d3.v3.min.js"></script>
		<script src="http://dimplejs.org/dist/dimple.v2.1.2.min.js"></script>

		<script type="text/javascript">
			var svg = dimple.newSvg("#chartContainer", 590, 400);
				function draw(data)
				{
					var width = 1000 ,
						height = 1000 ;
					var svg = d3.select("body")
								.append("svg")
									.attr("width",1000)
									.attr("height",400)
								.append('g')
									.attr('class','chart');
					var myChart = new dimple.chart(svg,data);
								myChart.setBounds(20,20,460,360);
								myChart.addMeasureAxis("p", "result");
							  	myChart.addSeries("month", dimple.plot.pie);// how the chart should look like
							  	myChart.addLegend(500, 20, 90, 300, "left");
							  	myChart.draw();
				};
								
		  </script>
	</head>	
	
	<body>
		<div id="chartContainer">
		  <script src="/lib/d3.v3.4.8.js"></script>
		  <script src="http://dimplejs.org/dist/dimple.v2.1.2.min.js"></script>
		  
			<script type=text/javascript>
				d3.csv("users.csv",draw);
			</script>	
			
		</div>
	
</body>
</html>
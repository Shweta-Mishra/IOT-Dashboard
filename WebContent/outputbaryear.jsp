<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

  <script src="http://d3js.org/d3.v3.min.js"></script>
  <script src="http://dimplejs.org/dist/dimple.v2.0.0.min.js"></script>
    <script type="text/javascript">
      function draw(data)
		{
      
      /*
        D3.js setup code
      */

          "use strict";
          var margin = 80,
              width = 1500 ,
              height = 600 ;

          var svg = d3.select("body")
            .append("svg")
              .attr("width", width + margin)
              .attr("height", height + margin)
            .append('g')
                .attr('class','chart');

      /*
        Dimple.js Chart construction code
      */

          var myChart = new dimple.chart(svg,data);
          var x = myChart.addCategoryAxis("x", "year"); 
		  			x.addOrderRule("S.No.");
          myChart.addMeasureAxis("y", "result");
          myChart.addSeries(null, dimple.plot.bar);
          myChart.draw();
        };
      </script>
  </head>
<body>
  <script type="text/javascript">
  /*
    Use D3 (not dimple.js) to load the TSV file
    and pass the contents of it to the draw function
    */
	  
  d3.csv("users.csv", draw);
  </script>
</body>
</html>

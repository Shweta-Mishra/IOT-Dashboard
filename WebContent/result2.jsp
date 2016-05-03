<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>

body {
  font: 10px sans-serif;
}

.arc path {
  stroke: #fff;
}

</style>
<link rel="stylesheet" href="css/reset.css" type="text/css" />
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">



<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>

<script type="text/javascript" src="js/custom.js"></script>

<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />


</head>
<body >


<div id="container" class="width">

    <header> 
	<div class="width">

    		<h1><a href="/">Bangalore<strong>hospital</strong></a></h1>

		<nav>
	
    			<ul class="sf-menu dropdown">

			
        			<li class="selected"><a href="index.html"><i class="fa fa-home"></i> Home</a></li>

            		
            
				<li><a href="#"><i class="fa fa-phone"></i> Contact</a></li>
       			</ul>

		

    		</nav>
       	</div>

	<div class="clear"></div>

       
    </header>

</div>



<script src="http://d3js.org/d3.v3.min.js"></script>
<h3>Near Misses monthly wise</h3> 
<h4><a href="barchart.jsp">bar chart</a></h4>

<script>
var width = 700,
    height = 700,
    radius = 200;

var color = d3.scale.ordinal()
    .range(["#98abc5", "#8a89a6", "#7b6888", "#6b486b", "#a05d56", "#d0743c", "#ff8c00"]);

var arc = d3.svg.arc()
    .outerRadius(radius - 10)
    .innerRadius(0);

var pie = d3.layout.pie()
    .sort(null)
    .value(function(d) { return d.result; });

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
  .append("g")
    .attr("transform", "translate(" +width/2 + "," + height/2+ ")");

d3.csv(
"users.csv", function(error, data) {

	
  data.forEach(function(d) {
    d.result = +d.result;
  });

  var g = svg.selectAll(".arc")
      .data(pie(data))
    .enter().append("g")
      .attr("class", "arc");

  g.append("path")
      .attr("d", arc)
      .style("fill", function(d) { return color(d.data.month); });

  g.append("text")
      .attr("transform", function(d) { return "translate(" + arc.centroid(d) + ")"; })
      .attr("dy", ".35em")
      .style("text-anchor", "middle")
      .text(function(d) { return d.data.month ;
      
      
      });

  
  
});
console.log();
</script>

</html>
<!DOCTYPE html>
<meta charset="utf-8">

<head>
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

 <style>

 .axis {
   font: 10px sans-serif;
 }

 .axis path,
 .axis line {
   fill: none;
   stroke: #000;
   shape-rendering: crispEdges;
 }

 </style>
</head>

<body>
 
<script src="http://d3js.org/d3.v3.min.js"></script>

<script>

var margin = {top: 20, right: 20, bottom: 70, left: 40},
    width = 600 - margin.left - margin.right,
    height = 300 - margin.top - margin.bottom;

// Parse the date / time


var x = d3.scale.ordinal().rangeRoundBands([0, width], .05);

var y = d3.scale.linear().range([height, 0]);

var xAxis = d3.svg.axis()
    .scale(x)
    .orient("bottom");
    

var yAxis = d3.svg.axis()
    .scale(y)
    .orient("left");


var svg = d3.select("body").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform", 
          "translate(" + margin.left + "," + margin.top + ")");

d3.csv("bar-data.csv", function(error, data) {

    data.forEach(function(d) {
        d.result = +d.result;
    });
 
  x.domain(data.map(function(d) { return d.month; }));
  y.domain([0, d3.max(data, function(d) { return d.result; })]);

  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
    .selectAll("text")
      .style("text-anchor", "end")
      .attr("dx", "-.8em")
      .attr("dy", "-.55em")
      .attr("transform", "rotate(-90)" );

  svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
    .append("text")
      .attr("transform", "rotate(-90)")
      .attr("y", 6)
      .attr("dy", ".71em")
      .style("text-anchor", "end")
      .text("near misses (%)");

  svg.selectAll("bar")
      .data(data)
    .enter().append("rect")
      .style("fill", "black")
      .attr("x", function(d) { return x(d.month); })
      .attr("width", x.rangeBand())
      .attr("y", function(d) { return y(d.result); })
      .attr("height", function(d) { return height - y(d.result); });

});

</script>

</body>
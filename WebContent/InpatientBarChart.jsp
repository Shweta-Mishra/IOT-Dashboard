<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>D3 Page Template</title>
        <script type="text/javascript" src="D3/d3.js"></script>
<style type="text/css">   
        </style>
    </head>
    <body>
        <script type="text/javascript">
var w = 500;
var h = 100;
var barPadding = 2;

var dataset = [5, 10, 15, 20, 30]
d3.csv("csv.csv", function(data) {
   dataset = data.map(function(d) { return [ +d["episodes"], +d["seasons"] ]; });
});


var svg = d3.select("body")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
            svg.selectAll("rect")
   .data(dataset)
   .enter()
   .append("rect")
   .attr("x", 0)
   .attr("y", 0)
   .attr("width", 20)
   .attr("height", 100)




        </script>
    </body>
</html>

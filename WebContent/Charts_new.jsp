<html>
<head>
	<script type="text/javascript">
	window.onload = function () {

      var dps = [];   //dataPoints. 

      var chart = new CanvasJS.Chart("chartContainer",{
      	title :{
      		text: "Live Data"
      	},
      	axisX: {						
      		title: "Axis X Title"
      	},
      	axisY: {						
      		title: "Units"
      	},
      	data: [{
      		type: "line",
      		dataPoints : dps
      	}]
      });

      chart.render();
      var xVal = 1;
      var yVal = 15;	
      var updateInterval = 1500;

      var updateChart = function () {
      	  $.ajax({
              url: 'https://api.thingspeak.com/channels/37277/feeds/last?key=Y9W2LWNQELP4BBMA',
              type : 'get',
              success: function(result){
            	           	 
            	 console.log(result);
            	 result = JSON.parse(result);
            	 yVal = parseInt(result.field1);
            	 xVal = parseInt(result.entry_id);
            	 
            	console.log(xVal);
            	console.log(yVal);
            	dps.push({x: xVal,y: yVal});
            	
            	if (dps.length >  50)
     	      	{
     	      		dps.shift();				
     	      	}

     	      	chart.render();		
        
              }
              
    	    });
    	  
   };
  
setInterval(function(){updateChart()}, updateInterval); 
}
</script>
<script type="text/javascript" src="js/canvasjs.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;">
	</div>
</body>
</html>
  
	      	
        		                        	
        		                        	
        		              

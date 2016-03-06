<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Heart Decision | Live Data</title>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
<!-- Font Awesome  -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- Web Font  -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="js/jquery.min.js"></script>	
<script type="text/javascript" src="js/canvasjs.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="index.html"><i class="fa fa-sun-o"></i> Hale and Hearty</a> </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.html">Home</a></li>
        <li><a href="about.html">About us</a></li>
         <li><a href="EnterData.html">Take a test</a></li>
         <li class="active"><a href="Monitor.jsp">View Report</a></li>
        <li ><a href="services.html">Services</a></li>
        <li><a href="contact.html">Contact us</a></li>
      </ul>
    </div>
  </div>
</nav>
<div id="section_header">
  <div class="container">
    <h2><span>View</span>  Patient Report</h2>
  </div>
</div>
	<div id="chartContainer" style="height: 400px; width: 80%;">
	<form  id="monitor" align="center" action="rest/monitor/monitorstatus" method="post">
	Patient Name: <input type="text" id="patientid" name="patientid"/>
	<input type="submit" id="submit" class='btn' value="View Reports">
	</form>
	</div>
	
	<div id="footerwrap">
  <div class="container">
    <div class="row">
      <div class="col-md-8"> <span class="copyright">Copyright &copy; 2015 Hale and Hearty. Design by <a href="http://www.templategarden.com" rel="nofollow">TemplateGarden</a></span> </div>
      <div class="col-md-4">
        <ul class="list-inline social-buttons">
          <li><a href="#"><i class="fa fa-twitter"></i></a> </li>
          <li><a href="#"><i class="fa fa-facebook"></i></a> </li>
          <li><a href="#"><i class="fa fa-google-plus"></i></a> </li>
          <li><a href="#"><i class="fa fa-linkedin"></i></a> </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>


</html>
  
	      	
        		                        	
        		                        	
        		              

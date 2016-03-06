<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Heart Decision | Live Data</title>
<!-- Bootstrap -->
<link href="../../css/bootstrap.css" rel='stylesheet' type='text/css'/>
<!-- Font Awesome  -->
<link href="../../css/font-awesome.min.css" rel="stylesheet">
<!-- Web Font  -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
<!-- Custom CSS -->
<link href="../../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="../../js/jquery.min.js"></script>	
<script type="text/javascript" src="../../js/canvasjs.min.js"></script>
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
        <li><a href="../../index.html">Home</a></li>
        <li><a href="../../about.html">About us</a></li>
         <li><a href="../../EnterData.html">Take a test</a></li>
         <li class="active"><a href="../../Monitor.jsp">View Report</a></li>
        <li ><a href="../../services.html">Services</a></li>
        <li><a href="../../contact.html">Contact us</a></li>
      </ul>
    </div>
  </div>
</nav>
<div id="section_header">
  <div class="container">
    <h2><span>Heart Disease</span> Prediction</h2>
  </div>
</div>
<div id="chartContainer" style="height: 400px; width: 50%;" align="center">
<div id="heart-big" title="SRDCE">♥</div>
<div id="heart-small" title="SRDCE">♥</div><br/><br/>
<div style="border: 1px solid;border-radius: 25px;padding:10px;margin-left:200px;" align="center">
<form action="../../rest/monitor/notifyUser" id="report" method="post">
<b>Report for patient <%= session.getAttribute("patient").toString()%></b><br/>
	<img style="height:35px;width:35px;"<%if (session.getAttribute("prediction").toString()=="Yes") { %> src="../../images/caution.png"<%} else{%>src="../../images/green.png" <% } %>/><b>&nbsp;&nbsp;Prediction : </b><%= session.getAttribute("prediction").toString()%> <%if (session.getAttribute("prediction").toString()=="Yes") { %>Patient has heart disease &nbsp;&nbsp;<input type="submit" class="btn" id="notify" value="Notify Patient"/><% }else{%>Patient is hale and hearty<% }%>  
</form>	
</div>
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
</body>
</html>

<script>
document
.querySelectorAll('body')[0]
.style
.backgroundColor = 'whiteSmoke';

var report = document.getElementById("patientid").value;

$.ajax({
    url : 'rest/monitor/monitorstatus',
    type: 'POST',
    dataType: "text",
    data : report,
    processData: true,
    success: function(a,data)
    {
    	var prediction = eval('(' + JSON.stringify(a) + ')');
    	alert(prediction);
    	alert("Data added successfully!!");
    	
    	
    },
    error: function ()
    {
    	//alert("Error in post");
    	//alert(xhr.responseText);
    }
});


/*function sendSMS(){
	
	alert("Patient has been notified");
	var contact="+14084785222";
	$.ajax({
	    url : '../../rest/monitor/notifyUser',
	    type: 'POST',
	    dataType: "text",
	    data : contact,
	    processData: true,
	    success: function(a,data)
	    {
	    	alert("Patient has been notified");
	    	//alert(a);
	    	
	    },
	    error: function ()
	    {
	    	alert("Error in post");
	    	//alert(xhr.responseText);
	    }
	});
}*/
</script>
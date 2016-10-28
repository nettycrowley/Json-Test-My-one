<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Html5Form.jsp" method="get">

	<label for="firstName">First Name:</label>
	<input type="text" name="firstName" id="firstName"><br>
	
	<label for="email">Email:</label>
	<input type="email" name="email" id="email" ><br>
	
	<label for="date">Date:</label>
	<input type="date" name="date" id="date" ><br>
	
	<label for="month">Month:</label>
	<input type="month" name="month" id="month"><br>
	
	<label for="time">Time:</label>
	<input type="time" name="time" id="time"><br>
	
	<label for="range">Quantity:</label>
	<input type="range" name="range" id="range"><br>
	
	<label for="number">Enter a number:</label>
	<input type="number" name="number" id="number"><br>
	
	<label for="creditCard">Credit Card</label>
	<input type="text" name="creditCard" id="creditCard" pattern="^\d(4)-\d(4)-\d(4)-\d(4)$"><br>
	
	<label for="pps">PPS Number:(7 digits followed by one or two letters)</label>
	<input type="text" name="ppsNumber" id="ppsNumber" pattern="[0-9]{7}[A-Z a-z]{1,2}"><br>
		
	<input type="submit" name="submit" id="submit" value="submit">
</form>

</body>
</html>
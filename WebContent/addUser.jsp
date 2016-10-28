<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

boolean valid= true;

String lastNameStyle = "":
String dateOfBirthStyle = "";
String agreeTermsAndConditionsStyle = "";


if(request.getParameter("firstName") != null) {
	//form has been submitted
	
	//read the parameters
	firstName = request.getParameter("firstName");
	firstName = request.getParameter("firstName");
	registered = request.getParameter("registered")!= null;
	firstName = request.getParameter("firstName");
	agreeTermsAndConditions = request.getParameter("agreeTermsAndConditions") != null;
	
}

if (dateOfBirth == )

if (valid){
// the process the request

UserDb userDb = new UserDb();

User user = new User(-1, firstName, lastName, registered, dateOfBirth)
}




<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=validationMessage%>

<form action="addUser.jsp" method="get">

FirstName:<input type="text" name="firstName" id="firstName" value="<%firstName%>" class="<%firstNameStyle%>">*<br>
Lastname:<input type="text" name="lastName" id="lastName" value="<%=lastName%> ">*<br>



Registered:<input type="checkbox" name="registered" id="registered" <%=registered ? "checked" : ""%>"><br>
Date of Birth:<inpuut type="text" name="dateOfBirth"  id="dateOfBirth" value="<%=dateOfBirth%> " class="<%=dateOfBirthStyle%>">

<br>
<div class="<%=agreeTermsAndConditionsStyle%">
	I agree to the Terms And Conditions:<input type="checkbox" name="agreeTermsAndConditions" id="agreeTermsAndConditions">
</div>
<input type="submit" name="submit" id="submit" value="submit">
</form>
<% } else {%>
	<h1> User 
</body>
</html>
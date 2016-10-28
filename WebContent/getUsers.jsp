<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rc.customer.User, com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.databind.ObjectMapper"%>
<%
	User[] users = {
		
			new User(100, "Aidan", "Kileen", false, "13/01/1970"),
			new User(101, "Annette", "Keane", true, "09/01/1980"),
			new User(102, "Daryl", "Keane", false, "26/03/2016")
	};



	ObjectMapper objectMapper = new ObjectMapper();
	String json = objectMapper.writeValueAsString(users);
%>
<%=json%>
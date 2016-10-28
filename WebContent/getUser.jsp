<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rc.customer.User, com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.databind.ObjectMapper"%>
<%
	User user = new User(100, "Aidan", "Kileen", false, "13/01/1970");
	ObjectMapper objectMapper = new ObjectMapper();
	String json = objectMapper.writeValueAsString(user);
%>
<%=user.toJson()%>
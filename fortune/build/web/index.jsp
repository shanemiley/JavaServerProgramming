<%-- 
    Document   : index
    Created on : 11-Jan-2017, 10:21:08
    Author     : Shane
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="CookieJar" class="cookies.CookieJar" scope="application"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cookie of the day</h1>
        <pre>${CookieJar.cookie}</pre>
       
    </body>
</html>

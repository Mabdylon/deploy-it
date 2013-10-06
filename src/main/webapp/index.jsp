<%@page import="com.mabdylon.deployIt.dao.DaoConnect"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! (bis)</h1>
        <h2>Testing DB Access : </h2>
        <%            
            List<String> results = DaoConnect.INSTANCE.testRetrieve();
            request.setAttribute("results", results);
        %>

    <c:forEach var="item" items="${results}" >
        <c:out value="${item}"/><br/>
    </c:forEach>

</body>
</html>

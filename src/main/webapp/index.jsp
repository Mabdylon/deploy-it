<%@page import="java.util.Map"%>
<%@page import="com.mabdylon.wishlist.dao.DaoConnect"%>
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
            Map results = DaoConnect.INSTANCE.testRetrieve();
            out.print(results.keySet());
        %>

    <c:forEach var="item" items="results" >
        ${item.key} - ${item.value}<br/>
    </c:forEach>
    
</body>
</html>

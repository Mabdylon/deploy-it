<%@page import="com.mabdylon.deployIt.concept.User"%>
<%@page import="com.mabdylon.deployIt.concept.Article"%>
<%@page import="com.mabdylon.deployIt.dao.GenericDao"%>
<%@page import="com.mabdylon.deployIt.concept.CartoDossier"%>
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
        <h1>Hello World! dddd</h1>
        <h2>Testing DB Access : </h2>
        <%            
            List<Article> articles = GenericDao.newDao(Article.class).loadAll();
            request.setAttribute("articles", articles);
        %>

    <c:forEach var="item" items="${articles}" >
        <c:out value="${item}"/><br/>
    </c:forEach>

        <%            
            List<User> users = GenericDao.newDao(User.class).loadAll();
            request.setAttribute("users", users);
        %>

    <c:forEach var="item" items="${users}" >
        <c:out value="${item}"/><br/>
    </c:forEach>
        
</body>
</html>

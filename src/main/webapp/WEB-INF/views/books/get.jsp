<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book details</title>
</head>
<body>
<h1>Title: <c:out value="${book.title}"/></h1>
Author: <c:out value="${book.author}"/><br>
Type: <c:out value="${book.type}"/><br>
Isbn: <c:out value="${book.isbn}"/><br>
Publisher: <c:out value="${book.publisher}"/><br>

<a href="<c:url value="/admin/books/all"/>">Back to list</a>
</body>
</html>

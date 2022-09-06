<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>
<form:form method="post">
    <input type="hidden" name="id" value="${book.id}}">
    Title: <input type="text" name="title" value="${book.title}"/><br>
    Author: <input type="text" name="author" value="${book.author}"/><br>
    Type: <input type="text" name="type" value="${book.type}"/><br>
    Isbn: <input type="text" name="isbn" value="${book.isbn}"/><br>
    Publisher: <input type="text" name="publisher" value="${book.publisher}"/><br>
    <button type="submit">Edit</button>
</form:form>
<a href="<c:url value="/admin/books/all"/>">Back to list</a>
</body>
</html>

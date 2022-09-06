<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form:form method="post">
    Title: <input type="text" name="title"/><br>
    Author: <input type="text" name="author"/><br>
    Type: <input type="text" name="type"/><br>
    Isbn: <input type="text" name="isbn"/><br>
    Publisher: <input type="text" name="publisher"/><br>
    <button type="submit">Create</button>
</form:form>
<a href="<c:url value="/admin/books/all"/>">Back to list</a>
</body>
</html>

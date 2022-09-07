<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
    <style>
        .errors {
            color: red;
            font-weight: bold;
            padding-left: 3px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="book">
    Title: <form:input path="title"/><form:errors path="title" cssClass="errors"/><br>
    Author: <form:input path="author"/><form:errors path="author" cssClass="errors"/><br>
    Type: <form:input path="type"/><form:errors path="type" cssClass="errors"/><br>
    Isbn: <form:input path="isbn"/><form:errors path="isbn" cssClass="errors"/><br>
    Publisher: <form:input path="publisher"/><form:errors path="publisher" cssClass="errors"/><br>
    <button type="submit">Create</button>
</form:form>
<a href="<c:url value="/admin/books/all"/>">Back to list</a>
</body>
</html>

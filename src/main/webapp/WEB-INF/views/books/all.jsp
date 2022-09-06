<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Book List</title>
</head>
<body>
<div>
  <a href="<c:url value="/admin/books/add"/>">Add a new book</a>
</div>
<table border="1">
  <thead>
  <th>title</th>
  <th>type</th>
  <th>isbn</th>
  <th>author</th>
  <th>publisher</th>
  <th>actions</th>
  </thead>
  <tbody>
  <c:forEach items="${books}" var="book">
    <tr>
      <td><c:out value="${book.title}"/></td>
      <td><c:out value="${book.type}"/></td>
      <td><c:out value="${book.isbn}"/></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.publisher}"/></td>
      <td>
        <a href="<c:url value="/admin/books/get/${book.id}"/>">Details</a>
        <a href="<c:url value="/admin/books/update/${book.id}"/>">Edit</a>
        <a href="<c:url value="/admin/books/delete/${book.id}"/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>


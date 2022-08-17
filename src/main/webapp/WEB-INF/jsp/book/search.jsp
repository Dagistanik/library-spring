<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%--@elvariable id="books" type="java.util.List<com.danik.bookstore.model.BookWithAuthor>"--%>
<html>
<head>
    <title>Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h3 class="text-red text-center">Books</h3>
<div class="d-grid gap-2 col-8 mx-auto">
    <div class="d-grid col-4 ">
        <form action="search" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Search by title:</label>
                <input type="text" class="form-control" name="title" id="title"/>
            </div>
            <button type="submit" class="btn btn-success">Search</button>
        </form>
    </div>
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">TITLE</th>
            <th scope="col">AUTHOR</th>
            <th scope="col">YEAR</th>
            <th scope="col">PAGE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row">${book.id}</th>
                <td>${book.title}</td>
                <td>${book.authorId}</td>
                <td>${book.year}</td>
                <td>${book.numberOfPage}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="d-grid gap-2 col-2 mx-auto">
    <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
        <form action="add">
            <input type="submit" class="btn btn-outline-success" value="Add new book">
        </form>
        <form action="/library">
            <input type="submit" class="btn btn-outline-dark" value="Back">
        </form>
    </div>
</div>
</body>
</html>

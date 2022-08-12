<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.library.project.products.Book" %>
<%@ page import="com.library.project.Library" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Books</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-red text-center">Books</h3>
        <div class="d-grid gap-2 col-8 mx-auto">
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
                        <td>${book.author}</td>
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
        </div>?
    </body>
</html>

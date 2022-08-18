javax.xml.stream.util.StreamReaderDelegate
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%--@elvariable id="author" type="com.danik.bookstore.model.Author"--%>
<%--@elvariable id="books" type="java.util.List<com.danik.bookstore.model.Book>"--%>
<html>
<head>
    <title>Author</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h3 class="text-red text-center">
    #${author.id} ${author.name}
</h3>

<div>
    Birth Year: <c:if test="${author.birthDate!=null}">${author.birthDate.year}</c:if>
</div>
<div>
    Country: ${author.countryCode}
</div>

<h4>Books:</h4>
<div class="d-grid gap-2 col-8 mx-auto">
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">TITLE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row">${book.id}</th>
                <td>${book.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="d-grid gap-2 col-2 mx-auto">
    <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
        <form action="/library/books/">
            <input type="submit" class="btn btn-outline-dark" value="Back">
        </form>
    </div>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <title>Dvds</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-red text-center">Dvd</h3>
        <div class="d-grid gap-2 col-8 mx-auto">
            <table class="table table-hover">
                <thead class="table-light">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">TITLE</th>
                        <th scope="col">size</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dvds}" var="dvd">
                        <tr>
                            <th scope="col">${dvd.id}</th>
                            <td>${dvd.title}</td>
                            <td>${dvd.sizeMegabytes}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="d-grid gap-2 col-2 mx-auto">
            <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                    <form action="add">
                        <input type="submit" class="btn btn-outline-success" value="Add new dvd">
                    </form>
                    <form action="/library">
                        <input type="submit" class="btn btn-outline-dark" value="back">
                    </form>
                </div>
            </div>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <title>Periodicals</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-red text-center">Periodicals</h3>
        <div class="d-grid gap-2 col-8 mx-auto">
            <table class="table table-hover">
                <thead class="table-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">TYPE</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">MONTH</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${periodicals}" var="periodical">
                        <tr>
                            <th scope="col">${periodical.id}</th>
                            <td>${periodical.getClass().getSimpleName()}</td>
                            <td>${periodical.title}</td>
                            <td>${periodical.month}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="d-grid gap-2 col-2 mx-auto">
            <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                <form action="add">
                    <input type="submit" class="btn btn-outline-success" value="Add new periodical">
                </form>
                <form action="/library">
                    <input type="submit" class="btn btn-outline-dark" value="back">
                </form>
            </div>
        </div>
    </body>
</html>

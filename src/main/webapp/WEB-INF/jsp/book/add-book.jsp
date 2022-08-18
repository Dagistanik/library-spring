<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add book</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-red text-center">Adding a new book</h3>
        <div class="d-grid gap-2 col-8 mx-auto">
            <form action="add" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">ID:</label>
                    <input type="text" class="form-control" name="id" id="id"/>
                </div>
                <div class="mb-3">
                    <label for="title" class="form-label">Title:</label>
                    <input type="text" class="form-control" name="title" id="title"/>
                </div>
                <div class="mb-3">
                    <label for="author_id" class="form-label">Author:</label>
                    <input type="text" class="form-control" name="author_id" id="author_id"/>
                </div>
                <div class="mb-3">
                    <label for="year" class="form-label">Year:</label>
                    <input type="text" class="form-control" name="year" id="year"/>
                </div>
                <div class="mb-3">
                    <label for="pages" class="form-label">Pages:</label>
                    <input type="text" class="form-control" name="pages" id="pages"/>
                </div>
                <button type="submit" class="btn btn-success">Create</button>
            </form>
        </div>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add periodical</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-red text-center">Adding a new periodical</h3>
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
                    <label for="month" class="form-label">Month:</label>
                    <input type="text" class="form-control" name="month" id="month"/><br>
                </div>
                <button type="submit" class="btn btn-success">Create</button>
            </form>
        </div>
    </body>
</html>

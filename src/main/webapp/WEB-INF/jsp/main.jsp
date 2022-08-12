<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Menu</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
    <div class="d-grid gap-2 col-3 mx-auto">
            <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                <form action="book/list">
                    <input type="submit" class="btn btn-outline-primary" value="Book">
                </form>
                <form action="periodical/list">
                    <input type="submit" class="btn btn-outline-primary" value="Periodical">
                </form>
                <form action="dvd/list">
                    <input type="submit" class="btn btn-outline-primary" value="DVD">
                </form>
                <form action="sqlbook/list">
                    <input type="submit" class="btn btn-outline-primary" value="SQL-Book">
                </form>
            </div>

        </div>
    </body>
</html>
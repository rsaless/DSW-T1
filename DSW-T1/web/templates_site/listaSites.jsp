<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Lista de Sites</h1>
        <div align="center">
            <table border="1" cellpadding="5">
                
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>URL</th>
                    <th>Telefone</th>
                </tr>

                <c:forEach var="site" items="${requestScope.sites}">
                    <tr>
                        <td><c:out value="${site.id}" /></td>
                        <td><c:out value="${site.nome}" /></td>
                        <td><c:out value="${site.url}" /></td>
                        <td><c:out value="${site.telefone}" /></td>
                    </tr>
                </c:forEach
                
            </table>
        </div>	
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
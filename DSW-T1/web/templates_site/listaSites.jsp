<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <title>Lista de Sites</title>
    </head>
    <body>
        <center>
            <h1>SITES</h1>
            <h2>
                <a href="cadastro">Adicionar novo Site </a>|
                <a href="../site/">Lista de Sites</a>
            </h2>
        </center><h1 align="center">SITES</h1>
        <div align="center">
            <h2>Lista de Teatros</h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>URL</th>
                    <th>Telefone</th>
                    <th>Acões</th>
                </tr>
                <c:forEach var="site" items="${requestScope.listaSites}">
                    <tr>
                        <td><c:out value="${site.id}" /></td>
                        <td><c:out value="${site.nome}" /></td>
                        <td><c:out value="${site.email}" /></td>
                        <td><c:out value="${site.senha}" /></td>
                        <td><c:out value="${site.url}" /></td>
                        <td><c:out value="${site.telefone}" /></td>
                        <td>
                            <a href="/DSW-T1/site/edicao?id=<c:out value='${site.id}' />">Edição</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/DSW-T1/site/remocao?id=<c:out value='${site.id}' />" 
                               onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                                Remoção
                            </a>                    	
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
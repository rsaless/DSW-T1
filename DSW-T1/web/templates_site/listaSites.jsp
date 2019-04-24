<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/DSW-T1/css/bootstrap.css">
        <title><f:message key="listaSites.title" /></title>
    </head>
    <body>
        <center>
            <h1><f:message key="listaSites.bigTitle" /></h1>
            <h2>
                <a href="/DSW-T1/site/cadastro"><f:message key="listaSites.goToAdd" /></a>|
                <a href="/DSW-T1/site"><f:message key="listaSites.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <h2><f:message key="listaTeatros.pageTitle" /></h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th><f:message key="listaSites.table.id" /></th>
                    <th><f:message key="listaSites.table.nome" /></th>
                    <th><f:message key="listaSites.table.email" /></th>
                    <th><f:message key="listaSites.table.senha" /></th>
                    <th><f:message key="listaSites.table.url" /></th>
                    <th><f:message key="listaSites.table.telefone" /></th>
                    <th><f:message key="listaSites.table.acoes" /></th>
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
                            <a href="/DSW-T1/site/edicao?id=<c:out value='${site.id}' />"><f:message key="listaSites.table.acoes.editar" /></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/DSW-T1/site/remocao?id=<c:out value='${site.id}' />" 
                               onclick="return confirm('<f:message key="remover.confirm" />');">
                                <f:message key="listaSites.table.acoes.remover" />
                            </a>  
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/DSW-T1/site/detalhes?id=<c:out value='${site.id}' />">Detalhes</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>
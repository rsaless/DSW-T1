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
        <title><f:message key="listaPromocoes.title" /></title>
    </head>
    <body>
        <center>
            <h1><f:message key="listaPromocoes.bigTitle" /></h1>
            <h2>
                <a href="/DSW-T1/promocao/cadastro"><f:message key="listaPromocoes.goToAdd" /></a>|
                <a href="/DSW-T1/promocao"><f:message key="listaPromocoes.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <h2><f:message key="listaPromocoes.pageTitle" /></h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th><f:message key="listaPromocoes.table.id" /></th>
                    <th><f:message key="listaPromocoes.table.site" /></th>
                    <th><f:message key="listaPromocoes.table.peca" /></th>
                    <th><f:message key="listaPromocoes.table.data" /></th>
                    <th><f:message key="listaPromocoes.table.hora" /></th>
                    <th><f:message key="listaPromocoes.table.preco" /></th>
                    <th><f:message key="listaPromocoes.table.cnpj" /></th>
                    <th><f:message key="listaPromocoes.table.acoes" /></th>
                </tr>
                <c:forEach var="promocao" items="${requestScope.listaPromocoes}">
                    <tr>
                        <td><c:out value="${promocao.id}" /></td>
                        <td><c:out value="${promocao.url}" /></td>
                        <td><c:out value="${promocao.nome_peca}" /></td>
                        <td><c:out value="${promocao.dia}" /></td>
                        <td><c:out value="${promocao.hora}" /></td>
                        <td><c:out value="${promocao.preco}" /></td>
                        <td><c:out value="${promocao.cnpj}" /></td>
                        <td>
                            <a href="/DSW-T1/promocao/edicao?id=<c:out value='${promocao.id}' />"><f:message key="listaPromocoes.table.acoes.editar" /></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/DSW-T1/promocao/remocao?id=<c:out value='${promocao.id}' />" 
                               onclick="return confirm('<f:message key="remover.confirm" />');">
                                <f:message key="listaPromocoes.table.acoes.remover" />
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
</f:bundle>

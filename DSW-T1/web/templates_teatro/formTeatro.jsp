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
        <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
        <title><f:message key="formTeatro.title" /></title
    </head>
    <style>
        body{
            font-family: 'Questrial', sans-serif;
        }
        .table {
            margin: 0px auto !important;
            width: 50%; 
        }
    </style>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a href="/DSW-T1" class="btn btn-default btn-lg"><f:message key="index.pageTitle" /></a>
                        <a href="/DSW-T1/promocao" class="btn btn-default btn-lg"><f:message key="index.promocoes" /></a>
                        <a href="/DSW-T1/site" class="btn btn-default btn-lg"><f:message key="index.sites" /> </a>
                        <a href="/DSW-T1/teatro" class="btn btn-default btn-lg"><f:message key="index.teatros" /></a>
                    </div>
                </div>
            </nav>
        </div>
        <center>
            <h1><f:message key="formTeatro.bigTitle" /></h1>
            <h2>
                <a href="cadastro"><f:message key="formTeatro.goToAdd" /></a>|
                <a href="../teatro/"><f:message key="formTeatro.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <c:if test="${teatro != null}"><form action="atualizacao" method="post"></c:if>
            <c:if test="${teatro == null}"><form action="insercao" method="post"></c:if>
                <h2>
                    <c:if test="${teatro != null}"><f:message key="formTeatro.smallTitle.editar" /></c:if>
                    <c:if test="${teatro == null}"><f:message key="formTeatro.smallTitle.cadastrar" /></c:if>
                </h2>
                <table border="1" cellpadding="5">   
                    <c:if test="${teatro != null}">
                        <input type="hidden" name="id" value="<c:out value='${teatro.id}' />" />
                    </c:if>            
                    <tr>
                        <th><f:message key="formTeatro.form.email" /></th>
                        <td><input type="email" name="email" size="50" required value="<c:out value='${teatro.email}' />" /></td>
                    </tr>
                    <tr>
                        <th><f:message key="formTeatro.form.senha" /></th>
                        <td><input type="password" name="senha" size="50" required value="<c:out value='${teatro.senha}' />"/></td>
                    </tr>
                    <tr>
                        <th><f:message key="formTeatro.form.cidade" /></th>
                        <td><input type="text" name="cidade" size="50" required value="<c:out value='${teatro.cidade}' />"/></td>
                    </tr>
                    <tr>
                        <th><f:message key="formTeatro.form.nome" /></th>
                        <td><input type="text" name="nome" size="50" required value="<c:out value='${teatro.nome}' />"/></td>
                    </tr>
                    <tr>
                        <th><f:message key="formTeatro.form.cnpj" /></th>
                        <td><input type="number" name="cnpj" size="50" required value="<c:out value='${teatro.cnpj}' />"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="<f:message key="formTeatro.form.submit" />" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

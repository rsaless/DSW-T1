<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
        <title><f:message key="formPromocao.title" /></title>
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
                            <a href="/DSW-T1/promocao/lista" class="btn btn-default btn-lg"><f:message key="index.promocoes" /></a>
                            <a href="/DSW-T1/site/lista" class="btn btn-default btn-lg"><f:message key="index.sites" /> </a>
                            <a href="/DSW-T1/teatro/lista" class="btn btn-default btn-lg"><f:message key="index.teatros" /></a>
                        </div>
                    </div>
                </nav>
        </div>
        <center>
            <h1><f:message key="formPromocao.bigTitle" /></h1>
            <h2>
                <a href="cadastro" class="btn btn-default btn-lg"><f:message key="formPromocao.goToAdd" /></a>
                <a href="../promocao/lista" class="btn btn-default btn-lg"><f:message key="formPromocao.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <c:if test="${promocao != null}"><form action="atualizacao" method="post"></c:if>
            <c:if test="${promocao == null}"><form action="insercao" method="post"></c:if>
                <h2>
                    <c:if test="${promocao != null}"><f:message key="formPromocao.smallTitle.editar" /></c:if>
                    <c:if test="${promocao == null}"><f:message key="formPromocao.smallTitle.cadastrar" /></c:if>
                </h2>
                <div class="container">
                    <div class="row">
                        <div class="col-form-label-md">
                            <table class="table table-borderless">   
                                <c:if test="${promocao != null}">
                                    <input type="hidden" name="id" value="<c:out value='${promocao.id}' />" />
                                </c:if>      
                                <tr>
                                    <th><f:message key="formPromocao.form.url" /></th>
                                    <td><input type="text" name="url" size="50" required value="<c:out value='${promocao.url}' />"/></td>
                                </tr>
                                <tr>
                                    <th><f:message key="formPromocao.form.nome" /></th>
                                    <td><input type="text" name="nome_peca" size="50" required value="<c:out value='${promocao.nome_peca}' />"/></td>
                                </tr>
                                <tr>
                                    <th><f:message key="formPromocao.form.data" /> </th>
                                    <td><input type="date" name="dia" size="50" required value="<c:out value='${promocao.dia}' />" /></td>
                                </tr>
                                <tr>
                                    <th><f:message key="formPromocao.form.hora" /> </th>
                                    <td><input type="text" name="hora" size="50" required value="<c:out value='${promocao.hora}' />"/></td>
                                </tr>
                                <tr>
                                    <th><f:message key="formPromocao.form.preco" /> </th>
                                    <td><input type="number" name="preco" size="50" step="0.1" required value="<c:out value='${promocao.preco}' />"/></td>
                                </tr>
                                <tr>
                                    <th><f:message key="formPromocao.form.cnpj" /> </th>
                                    <td><input type="number" name="cnpj" size="50" required value="<c:out value='${promocao.cnpj}' />"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="<f:message key="formPromocao.form.submit" />" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
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

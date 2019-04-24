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
        <title><f:message key="detalhesSite.title" /></title>
    </head>
    <style>
        body{
            font-family: 'Questrial', sans-serif;
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
            <h1><f:message key="detalhesSite.bigTitle" /></h1>
            <h2>
                <a href="/DSW-T1/promocao/cadastro" class="btn btn-default btn-lg"><f:message key="detalhesSite.goToAdd" /></a>
                <a href="/DSW-T1/site" class="btn btn-default btn-lg"><f:message key="detalhesSite.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <h2>Detalhes do Site</h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th><f:message key="detalhesSite.table.id" /></th>
                    <th><f:message key="detalhesSite.table.nome" /></th>
                    <th><f:message key="detalhesSite.table.email" /></th>
                    <th><f:message key="detalhesSite.table.senha" /></th>
                    <th><f:message key="detalhesSite.table.url" /></th>
                    <th><f:message key="detalhesSite.table.telefone" /></th>
                    <!--<th><//f:message key="detalhesSite.table.acoes" /></th>-->
                </tr>
                <tr>
                    <td><c:out value="${site.id}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.senha}" /></td>
                    <td><c:out value="${site.url}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <!-- <td>
                        <a href="/DSW-T1/site/edicao?id=<//c:out value='${site.id}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/DSW-T1/site/remocao?id=<//c:out value='${site.id}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td> -->
                </tr>
            </table>
                           
            <br/>
            
            <h2><f:message key="detalhesSite.active" /></h2>
            <c:if test="${!listaPromocoes.isEmpty()}">
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
                                <a href="/DSW-T1/promocao/edicao?id=<c:out value='${promocao.id}' />"><f:message key="detalhesSite.table.acoes.editar" /></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/DSW-T1/promocao/remocao?id=<c:out value='${promocao.id}' />" 
                                   onclick="return confirm('<f:message key="remover.confirm" />');">
                                    <f:message key="detalhesSite.table.acoes.remover" />
                                </a>                    	
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${listaPromocoes.isEmpty()}">
                <p><f:message key="detalhesSite.not.active" /></p>
            </c:if>
            
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>
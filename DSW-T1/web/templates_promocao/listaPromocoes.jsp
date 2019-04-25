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
        <title><f:message key="listaPromocoes.title" /></title>
        <script src="/DSW-T1/js/ListaTeatroAJAX.js"></script>
    </head>
    <style>body{font-family: 'Questrial', sans-serif;}</style>
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
            <h1><f:message key="listaPromocoes.bigTitle" /></h1>
            <h2>
                <a href="/DSW-T1/promocao/cadastro" class="btn btn-default btn-lg"><f:message key="listaPromocoes.goToAdd" /></a>
                <a href="/DSW-T1/promocao/lista" class="btn btn-default btn-lg"><f:message key="listaPromocoes.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <h2><f:message key="listaPromocoes.pageTitle" /></h2>
            <input class="mb-4" type="number" name="busca" placeholder="<f:message key="listaPromocoes.busca" />" oninput='buscarPromocoes(this.value)'/>
            </br>
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-6">
                        <table class="table table-bordered table-striped table-hover">
                            <tr class="col-md-2">
                                <th class="text-center"><f:message key="listaPromocoes.table.id" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.site" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.peca" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.data" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.hora" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.preco" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.cnpj" /></th>
                                <th class="text-center"><f:message key="listaPromocoes.table.acoes" /></th>
                            </tr>
                            <tbody id="tbodyresposta">
                                <c:forEach var="promocao" items="${requestScope.listaPromocoes}">
                                    <tr>
                                        <td class="text-center"><c:out value="${promocao.id}" /></td>
                                        <td class="text-center"><c:out value="${promocao.url}" /></td>
                                        <td class="text-center"><c:out value="${promocao.nome_peca}" /></td>
                                        <td class="text-center"><c:out value="${promocao.dia}" /></td>
                                        <td class="text-center"><c:out value="${promocao.hora}" /></td>
                                        <td class="text-center"><c:out value="${promocao.preco}" /></td>
                                        <td class="text-center"><c:out value="${promocao.cnpj}" /></td>
                                        <td class="text-center">
                                            <a href="/DSW-T1/promocao/edicao?id=<c:out value='${promocao.id}' />"><f:message key="listaPromocoes.table.acoes.editar" /></a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="/DSW-T1/promocao/remocao?id=<c:out value='${promocao.id}' />" 
                                               onclick="return confirm('<f:message key="remover.confirm" />');">
                                                <f:message key="listaPromocoes.table.acoes.remover" />
                                            </a>                    	
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>]
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/DSW-T1/css/bootstrap.css">
        <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/DSW-T1/css/glyphicon.css"> <!-- adicionado pra usar ícones-->
        <title><f:message key="detalhesSite.title" /></title>
    </head>
    <style>
        .bg{
            background-color: #8E2DE2;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to bottom, #7700e0, #8E2DE2);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to bottom, #7700e0, #8E2DE2); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        }
        body{
            font-family: 'Questrial', sans-serif;
            color: white;
            height: 100%;
            margin: 0;
            padding: 0;
            background-color: #8E2DE2;
        }
        h1{
            font-size: 2.8em;
        }
        h2{
            font-size: 2.3em;
        }
    </style>
    <body>
        <div class="bg">
            <div class="container-fullwidth">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a href="/DSW-T1" class="btn btn-default btn-lg"><f:message key="index.pageTitle" /></a>
                            <a href="/DSW-T1/promocao/lista" class="btn btn-default btn-lg"><f:message key="index.promocoes" /></a>
                            <a href="/DSW-T1/site/lista" class="btn btn-default btn-lg"><f:message key="index.sites" /> </a>
                            <a href="/DSW-T1/teatro/lista" class="btn btn-default btn-lg"><f:message key="index.teatros" /></a>
                            <sec:authorize access="hasAnyRole('ADMIN', 'SITE', 'TEATRO')">
                                <a href="/DSW-T1/logout" class="btn btn-default btn-lg">Logout</a>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <a href="/DSW-T1/login" class="btn btn-default btn-lg">Login</a>
                            </sec:authorize>
                        </div>
                    </div>
                </nav>
            </div>
            </br>
            <center>
                <h1><f:message key="detalhesSite.bigTitle" /></h1>
                </br> </br>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <h2>
                                <a href="/DSW-T1/site/lista" class="btn btn-light btn-lg"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp;&nbsp;&nbsp;<f:message key="detalhesSite.goToList" /></a>
                            </h2>
                        </div>
                        <div class="col-lg-6">
                            <h2>
                                <a href="/DSW-T1/promocao/cadastro" class="btn btn-success btn-lg"><f:message key="detalhesSite.goToAdd" />&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-plus-sign"></span></a>
                            </h2>
                        </div>
                    </div>
                </div>
            </center>
            </br> </br> </br>
            <div align="center">
                <h2>Detalhes do Site</h2>
                <br/>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-md-offset-6">
                            <table class="table table-light table-bordered table-striped table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th><f:message key="detalhesSite.table.id" /></th>
                                        <th><f:message key="detalhesSite.table.nome" /></th>
                                        <th><f:message key="detalhesSite.table.email" /></th>
                                        <!--<th><//f:message key="detalhesSite.table.senha" /></th>-->
                                        <th><f:message key="detalhesSite.table.url" /></th>
                                        <th><f:message key="detalhesSite.table.telefone" /></th>
                                        <!--<th><//f:message key="detalhesSite.table.acoes" /></th>-->
                                    </tr>
                                    <tr>
                                        <td><c:out value="${site.id}" /></td>
                                        <td><c:out value="${site.nome}" /></td>
                                        <td><c:out value="${site.email}" /></td>
                                        <!--<td><//c:out value="${site.senha}" /></td>-->
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
                                </thead>
                            </table>
                        </div>
                    </div>
                </div> 
                <br/> <br/>

                <h2><f:message key="detalhesSite.active" /></h2>
                <br/>
                <c:if test="${!listaPromocoes.isEmpty()}">
                    <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-md-offset-6">
                            <table class="table table-light table-bordered table-striped table-hover">
                                <thead class="thead-dark">
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
                                                <a href="/DSW-T1/promocao/edicao?id=<c:out value='${promocao.id}' />"><span class="glyphicon glyphicon-pencil"></span></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="/DSW-T1/promocao/remocao?id=<c:out value='${promocao.id}' />" 
                                                   onclick="return confirm('<f:message key="remover.confirm" />');">
                                                    <span class="glyphicon glyphicon-trash" style="color:red"></span>
                                                </a>                    	
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
                </c:if>
                <c:if test="${listaPromocoes.isEmpty()}">
                    <p><f:message key="detalhesSite.not.active" /></p>
                </c:if>
            </div>
        </div>        
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>
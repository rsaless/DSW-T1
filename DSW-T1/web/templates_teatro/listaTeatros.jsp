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
        <link rel="stylesheet" type="text/css" href="/DSW-T1/css/glyphicon.css"> <!-- adicionado pra usar ícones-->
        <title><f:message key="listaTeatros.title" /></title>
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
            <h1><f:message key="listaTeatros.bigTitle" /></h1>
            <h2>
                <a href="/DSW-T1/teatro/cadastro" class="btn btn-default btn-lg"><f:message key="listaTeatros.goToAdd" /></a>
                <a href="/DSW-T1/teatro" class="btn btn-default btn-lg"><f:message key="listaTeatros.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <h2><f:message key="listaTeatros.pageTitle" /></h2>
            </br>
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-6">
                        <table class="table table-bordered table-striped table-hover">
                            <tr class="col-md-2">
                                <th class="text-center"><f:message key="listaTeatros.table.id" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.nome" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.email" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.senha" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.cidade" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.cnpj" /></th>
                                <th class="text-center"><f:message key="listaTeatros.table.acoes" /></th>
                            </tr>
                            <c:forEach var="teatro" items="${requestScope.listaTeatros}">
                                <tr>
                                    <td class="text-center"><c:out value="${teatro.id}" /></td>
                                    <td class="text-center"><c:out value="${teatro.nome}" /></td>
                                    <td class="text-center"><c:out value="${teatro.email}" /></td>
                                    <td class="text-center"><c:out value="${teatro.senha}" /></td>
                                    <td class="text-center"><c:out value="${teatro.cidade}" /></td>
                                    <td class="text-center"><c:out value="${teatro.cnpj}" /></td>
                                    <td class="text-center">
                                        <a href="/DSW-T1/teatro/edicao?id=<c:out value='${teatro.id}' />"><span class="glyphicon glyphicon-pencil"></span></a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/DSW-T1/teatro/remocao?id=<c:out value='${teatro.id}' />" 
                                           onclick="return confirm('<f:message key="remover.confirm" />');">
                                           <span class="glyphicon glyphicon-trash"></span>
                                        </a>                    	
                                    </td>
                                </tr>
                            </c:forEach>
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

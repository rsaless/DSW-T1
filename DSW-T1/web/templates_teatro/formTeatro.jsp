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
        
        <script src="../js/jquery-3.3.1.min.js"></script>
        <script src="../js/jquery.mask.min.js"></script>
        
        <script>
            $(document).ready(function(){
                $('.cnpj').mask('00.000.000/0000-00')
            })
        </script>
        
        <title><f:message key="formTeatro.title" /></title
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
        p{
            padding-left: 30px;
            color: #f7f7f7;
            font-size: 1.5em;
        }
        .dat-div{
            border: 2px solid red;
        }
        .center_div{
            width: 50%;
            margin: 0px auto;
        }
        tr{
            width: 50%;
            color: white;
        }
        th{
            margin: 0px auto;
            width: 10%;
        }
    </style>
    <body>
        <div class="bg">
            <div class="container-fullwidth">
                <nav class="navbar navbar-expand-lg bg-light navbar-light">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a href="/DSW-T1" class="btn btn-light btn-lg"><f:message key="index.pageTitle" /></a>
                            <a href="/DSW-T1/promocao/lista" class="btn btn-light btn-lg"><f:message key="index.promocoes" /></a>
                            <a href="/DSW-T1/site/lista" class="btn btn-light btn-lg"><f:message key="index.sites" /> </a>
                            <a href="/DSW-T1/teatro/lista" class="btn btn-light btn-lg"><f:message key="index.teatros" /></a>
                        </div>
                    </div>
                </nav>
            </div>
            </br>
            <center>
                <h1><f:message key="formTeatro.bigTitle" /></h1>
                </br> </br>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <p> Cadastre seu teatro aqui. É fácil e rápido. </p>
                        </div>
                        <div class="col-lg-6">
                            <h2>
                                <a href="../teatro/lista" class="btn btn-light btn-lg"><f:message key="formTeatro.goToList" />&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-list"></span></a>
                            </h2>
                        </div>
                    </div>
                </div>
            </center>
            </br> </br> </br>                         
            <div align="center">
                <c:if test="${site != null}"><form action="atualizacao" method="post"></c:if>
                <c:if test="${site == null}"><form action="insercao" method="post"></c:if>
                    <h2>
                        <c:if test="${teatro != null}"><f:message key="formTeatro.smallTitle.editar" /></c:if>
                        <c:if test="${teatro == null}"><f:message key="formTeatro.smallTitle.cadastrar" /></c:if>
                    </h2>
                    <div class="container">
                        <div class="row">
                            <div class="center_div">
                                <div class="col-lg-12">
                                    <table class="table table-borderless">
                                        <div class="form-group row">
                                            <c:if test="${site != null}">
                                                <input type="hidden" name="id" value="<c:out value='${site.id}' />" />
                                            </c:if>            
                                            <tr>
                                                <th><f:message key="formTeatro.form.email" /></th>
                                                <td><input class="form-control col-sm-10" type="email" name="email" required value="<c:out value='${teatro.email}' />" /></td>
                                            </tr>
                                            <tr>
                                                <th><f:message key="formTeatro.form.senha" /></th>
                                                <td><input class="form-control col-sm-10" type="password" name="senha" required value="<c:out value='${teatro.senha}' />"/></td>
                                            </tr>
                                            <tr>
                                                <th><f:message key="formTeatro.form.cidade" /></th>
                                                <td><input class="form-control col-sm-10" type="text" name="cidade" required value="<c:out value='${teatro.cidade}' />"/></td>
                                            </tr>
                                            <tr>
                                                <th><f:message key="formTeatro.form.nome" /></th>
                                                <td><input class="form-control col-sm-10" type="text" name="nome" required value="<c:out value='${teatro.nome}' />"/></td>
                                            </tr>
                                            <tr>
                                                <th><f:message key="formTeatro.form.cnpj" /></th>
                                                <td><input class="form-control col-sm-10 cnpj" type="text" name="cnpj" required value="<c:out value='${teatro.cnpj}' />"/></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center">
                                                    <input class="btn btn-lg btn-outline-light" type="submit" value="<f:message key="formTeatro.form.submit"/>" />
                                                </td>
                                            </tr>
                                        </div>
                                    </table>
                                </div>
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
        </div>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

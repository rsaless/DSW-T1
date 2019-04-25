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
        <link rel="stylesheet" type="text/css" href="/DSW-T1/css/glyphicon.css"> <!-- adicionado pra usar ícones-->
        <title><f:message key="formPromocao.title" /></title>
    </head>
    <style>
        body{
            font-family: 'Questrial', sans-serif;
        }
        h1{
            font-size: 2.5em;
        }
        p{
            padding-left: 30px;
            color: gray;
            font-size: 1.5em;
        }
        .dat_div{
            border: 2px solid red;
        }
        .center_div{
            width: 50%;
            margin: 0px auto;
        }
        tr{
            width: 50%;
        }
        th{
            margin: 0px auto;
            width: 10%;
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
        </br>
        <center>
            <h1><f:message key="formPromocao.bigTitle" /></h1>
            </br> </br>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <p> Cadastre sua promoção aqui. É fácil e rápido. </p>
                    </div>
                    <div class="col-lg-6">
                        <h2>
                            <a href="../promocao/lista" class="btn btn-primary btn-lg"><f:message key="formPromocao.goToList" />&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-list"></span></a>
                        </h2>
                    </div>
                </div>
            </div>
        </center>
        </br> </br> </br>
        <div align="center">
            <c:if test="${promocao != null}"><form action="atualizacao" method="post"></c:if>
            <c:if test="${promocao == null}"><form action="insercao" method="post"></c:if>
                <h2>
                    <c:if test="${promocao != null}"><f:message key="formPromocao.smallTitle.editar" /></c:if>
                    <c:if test="${promocao == null}"><f:message key="formPromocao.smallTitle.cadastrar" /></c:if>
                </h2>
                <div class="container">
                    <div class="row">
                        <div class="center_div">
                            <div class="col-lg-12">
                                <table class="table table-borderless">
                                    <div class="form-group row">  
                                    <c:if test="${promocao != null}">
                                        <input type="hidden" name="id" value="<c:out value='${promocao.id}' />" />
                                    </c:if>      
                                    <tr>
                                        <th><f:message key="formPromocao.form.url" /></th>
                                        <td><input class="col-sm-10" type="text" name="url" required value="<c:out value='${promocao.url}' />"/></td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="formPromocao.form.nome" /></th>
                                        <td><input class="col-sm-10" type="text" name="nome_peca" required value="<c:out value='${promocao.nome_peca}' />"/></td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="formPromocao.form.data" /> </th>
                                        <td><input class="col-sm-10" type="date" name="dia" required value="<c:out value='${promocao.dia}' />" /></td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="formPromocao.form.hora" /> </th>
                                        <td><input class="col-sm-10" type="text" name="hora" required value="<c:out value='${promocao.hora}' />"/></td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="formPromocao.form.preco" /> </th>
                                        <td><input class="col-sm-10" type="number" name="preco" step="0.1" required value="<c:out value='${promocao.preco}' />"/></td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="formPromocao.form.cnpj" /> </th>
                                        <td><input class="col-sm-10" type="number" name="cnpj" required value="<c:out value='${promocao.cnpj}' />"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <input class="btn btn-lg btn-outline-primary" type="submit" value="<f:message key="formPromocao.form.submit" />" />
                                        </td>
                                    </tr>
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
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/DSW-T1/css/glyphicon.css"> <!-- adicionado pra usar ícones-->
        <link rel="stylesheet" href="../css/datepicker.min.css" type="text/css">
        <link rel="stylesheet" href="../css/jquery-clockpicker.min.css" type="text/css">
        
        <script src="../js/jquery-3.3.1.min.js"></script>
        
        <script src="../js/datepicker.min.js"></script>
        <script src="../js/datepicker_i18n/datepicker.en.js"></script>
        <script src="../js/datepicker_i18n/datepicker.pt-BR.js"></script>
        <script src="../js/jquery.mask.min.js"></script>
        <script src="../js/jquery-clockpicker.min.js"></script>
        <script src="../js/jquery.maskMoney.min.js"></script>
        
        <script>
            $(document).ready(function(){
                $('.data').mask('00/00/0000')
                $(".cnpj").mask('00.000.000/0000-00')
                $('.horario').mask('00:00:00')
                $('.data').datepicker({autoClose: true})
                $('.horario').clockpicker({
                    placement: 'bottom',
                    align: 'right',
                    autoclose: true,
                    'default': '00:00'
                });
                $('.preco').maskMoney({
                    prefix:'R$ ', 
                    allowNegative: false, 
                    thousands:'.', 
                    decimal:','
                })
            })
        </script>
        
        <title><f:message key="formPromocao.title" /></title>
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
        .dat_div{
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
                <h1><f:message key="formPromocao.bigTitle" /></h1>
                </br> </br>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <p> Cadastre sua promoção aqui. É fácil e rápido. </p>
                        </div>
                        <div class="col-lg-6">
                            <h2>
                                <a href="../promocao/lista" class="btn btn-light btn-lg"><f:message key="formPromocao.goToList" />&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-list"></span></a>
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
                                            <td>
                                                <input type="text" 
                                                       name="url" 
                                                       size="50" 
                                                       required 
                                                       value="<c:out value='${promocao.url}' />"
                                                                                       class="form-control col-sm-10"
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><f:message key="formPromocao.form.nome" /></th>
                                            <td>
                                                <input type="text" 
                                                       name="nome_peca" 
                                                       size="50" 
                                                       required 
                                                       value="<c:out value='${promocao.nome_peca}' />"
                                                                                       class="form-control col-sm-10"
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><f:message key="formPromocao.form.data" /> </th>
                                            <td>
                                                <input type="text" 
                                                       data-language="pt-BR"
                                                       name="dia"
                                                       class="datepicker-here data form-control col-sm-10" 
                                                       required
                                                       size="10"
                                                       value="<c:out value='${promocao.dia}' />"
                                                       autoClose="true"
                                                       placeholder="DD/MM/AAAA"
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><f:message key="formPromocao.form.hora" /> </th>
                                            <td>
                                                <input type="text" 
                                                       class="horario form-control col-sm-10" 
                                                       name="hora" 
                                                       size="8" 
                                                       required 
                                                       value="<c:out value='${promocao.hora}' />" 
                                                       placeholder="HH:MM"
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><f:message key="formPromocao.form.preco" /> </th>
                                            <td>
                                                <input type="text" 
                                                       class="preco form-control col-sm-10"
                                                       name="preco" 
                                                       size="50" 
                                                       step="0.1" 
                                                       required 
                                                       value="<c:out value='${promocao.preco}' />"
                                                       placeholder="R$ "
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><f:message key="formPromocao.form.cnpj" /> </th>
                                            <td>
                                                <input type="text" 
                                                       name="cnpj" 
                                                       size="18" 
                                                       required 
                                                       value="<c:out value='${promocao.cnpj}' />" 
                                                       class="cnpj form-control col-sm-10"
                                                />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <input class="btn btn-lg btn-outline-light" type="submit" value="<f:message key="formPromocao.form.submit" />" />
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
        </div>                                    
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

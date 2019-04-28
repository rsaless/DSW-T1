<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/bootstrap.css">
            <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
            <title><f:message key="index.title" /></title>
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
            p{
                padding-left: 100px;
                color: #f7f7f7;
                font-size: 1.5em;
                text-align: center;
            }
        </style>
        </head>
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
                        <h1><f:message key="index.pageTitle" /></h1>
                        </br> </br>
                        <div class="container">
                            </br>
                            <div class="row">
                                <p>
                                   Bem-vindo ao Sistema WEB desenvolvido para a disciplina de Desenvolvimento WEB.
                                </p>
                            </div>
                        </div>
                </center>
            </div>
        </body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    </html>
</f:bundle>

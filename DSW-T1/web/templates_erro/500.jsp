<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.sistema">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/DSW-T1/css/bootstrap.css">
            <link rel="stylesheet" href="/DSW-T1/css/style.css">
            <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
            <title><f:message key="500.title" /></title>
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
                            </div>
                        </div>
                    </nav>
                </div>
                <center>
                    <div class="container">
                        <div class="page-header pb-5">
                            <h1><f:message key="500.pageTitle" /></h1>
                            <h3><f:message key="500.pageSubTitle" /></h3>
                        </div>
                        <div class="page-content">
                            <div class="pb-5">
                                <h4><f:message key="500.suggestions" /></h4>
                            <ul  class="list-unstyled">
                                <li>•<f:message key="500.suggestions.1" /></li>
                                <li>•<f:message key="500.suggestions.2" /></li>
                                <li>•<f:message key="500.suggestions.3" /></li>
                            </ul>
                            </div>
                            <div class="pb-5">
                                <h4><f:message key="500.causes" /></h4>
                                <ul  class="list-unstyled">
                                    <li>•<f:message key="500.causes.1" /></li>
                                    <li>•<f:message key="500.causes.2" /></li>
                                </ul>
                            </div>
                        </div>    
                    </div>
                </center>
            </div>
        </body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    </html>
</f:bundle>
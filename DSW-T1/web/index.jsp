<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.sistema">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/bootstrap.css">
            <link href="https://fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
            <title><f:message key="index.title" /></title>
            <style>
                body{
                    font-family: 'Questrial', sans-serif;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a href="/DSW-T1/promocao" class="btn btn-default btn-lg"><f:message key="index.promocoes" /></a>
                            <a href="/DSW-T1/site" class="btn btn-default btn-lg"><f:message key="index.sites" /> </a>
                            <a href="/DSW-T1/teatro" class="btn btn-default btn-lg"><f:message key="index.teatros" /></a>
                        </div>
                    </div>
                </nav>
            </div>
            <center>
                <div class="container">
                    <div class="page-header">
                        <h1><f:message key="index.pageTitle" /></h1>
                    </div>
                    <div>
                        <p>
                            Alguma info
                        </p>
                    </div>
                </div>
            </center>
        </body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    </html>
</f:bundle>

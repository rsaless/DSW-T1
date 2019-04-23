<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<f:bundle basename="i18n.sistema">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/bootstrap.css">
            <title><f:message key="index.title" /></title>
        </head>
        <body>
            <center>
                    <h1><f:message key="index.pageTitle" /></h1>
                    <h2>
                        <a href="/DSW-T1/site"><f:message key="index.sites" /> </a>|
                        <a href="/DSW-T1/teatro"><f:message key="index.teatros" /></a> |
                        <a href="/DSW-T1/promocao"><f:message key="index.promocoes" /></a>
                    </h2>
            </center>
        </body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    </html>
</f:bundle>

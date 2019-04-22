<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <title>Formulário Promoção</title>
    </head>
    <body>
        <center>
            <h1>PROMOÇÕES</h1>
            <h2>
                <a href="cadastro">Adicionar nova Promoção </a>|
                <a href="../promocao/">Lista de Promoções</a>
            </h2>
        </center>
        <div align="center">
            <c:if test="${promocao != null}"><form action="atualizacao" method="post"></c:if>
            <c:if test="${promocao == null}"><form action="insercao" method="post"></c:if>
                <h2>
                    <c:if test="${promocao != null}">Edição</c:if>
                    <c:if test="${promocao == null}">Cadastro</c:if>
                </h2>
                <table border="1" cellpadding="5">   
                    <c:if test="${promocao != null}">
                        <input type="hidden" name="id" value="<c:out value='${promocao.id}' />" />
                    </c:if>      
                    <tr>
                        <th>Site: </th>
                        <td><input type="text" name="url" size="50" required value="<c:out value='${promocao.url}' />"/></td>
                    </tr>
                    <tr>
                        <th>Peça: </th>
                        <td><input type="text" name="nome_peca" size="50" required value="<c:out value='${promocao.nome_peca}' />"/></td>
                    </tr>
                    <tr>
                        <th>Data: </th>
                        <td><input type="date" name="dia" size="50" required value="<c:out value='${promocao.dia}' />" /></td>
                    </tr>
                    <tr>
                        <th>Horário: </th>
                        <td><input type="text" name="hora" size="50" required value="<c:out value='${promocao.hora}' />"/></td>
                    </tr>
                    <tr>
                        <th>Preço: </th>
                        <td><input type="number" name="preco" size="50" step="0.1" required value="<c:out value='${promocao.preco}' />"/></td>
                    </tr>
                    <tr>
                        <th>CNPJ: </th>
                        <td><input type="number" name="cnpj" size="50" required value="<c:out value='${promocao.cnpj}' />"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" />
                        </td>
                    </tr>
                </table>
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

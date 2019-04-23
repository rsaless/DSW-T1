<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/DSW-T1/css/bootstrap.css">
        <title>Detalhes do Site</title>
    </head>
    <body>
        <center>
            <h1>DETALHES</h1>
            <h2>
                <a href="/DSW-T1/promocao/cadastro">Adicionar nova Promoção </a>|
                <a href="/DSW-T1/site">Voltar</a>
            </h2>
        </center>
        <div align="center">
            <h2>Detalhes do Site</h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>URL</th>
                    <th>Telefone</th>
                    <!--<th>Acões</th>-->
                </tr>
                <tr>
                    <td><c:out value="${site.id}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.senha}" /></td>
                    <td><c:out value="${site.url}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <!-- <td>
                        <a href="/DSW-T1/site/edicao?id=<c:out value='${site.id}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/DSW-T1/site/remocao?id=<c:out value='${site.id}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td> -->
                </tr>
            </table>
                           
            <br/>
            
            <h2>Promoções ativas para este site</h2>
            <c:if test="${!listaPromocoes.isEmpty()}">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>ID</th>
                        <th>Site</th>
                        <th>Peça</th>
                        <th>Data</th>
                        <th>Horário</th>
                        <th>Preço</th>
                        <th>CNPJ</th>
                        <th>Acões</th>
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
                                <a href="/DSW-T1/promocao/edicao?id=<c:out value='${promocao.id}' />">Edição</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/DSW-T1/promocao/remocao?id=<c:out value='${promocao.id}' />" 
                                   onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                                    Remoção
                                </a>                    	
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${listaPromocoes.isEmpty()}">
                <p>Não existem promoções ativas para este site</p>
            </c:if>
            
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
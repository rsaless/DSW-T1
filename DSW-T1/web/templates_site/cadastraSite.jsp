<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>

        <h1 align="center">Cadastre o site</h1>
        
        <div align="center">
            <form method="POST">
                <table>
                    <tr>
                        <td> Nome: </td>
                        <td> <input type="text"
                                    name="nome"
                                    required value="<c:out value='${site.nome}'/>"
                             />
                        </td>
                    </tr>
                    <tr>
                        <td> Email: </td>
                        <td> <input type="text"
                                    name="email"
                                    required value="<c:out value='${site.email}' />"
                             />
                        </td>
                    </tr>  
                    <tr>
                        <td> URL da página: </td>
                        <td> <input type="text"
                                    name="url
                                    required value="<c:out value='${site.url}' />"
                             />
                        </td>
                    </tr>  
                    <tr>
                        <td> Senha: </td>
                        <td> <input type="password"
                                    name="senha"
                                    required value="<c:out value='${site.senha}' />"
                             />
                        </td>
                    </tr>  
                    <tr>
                        <td> Telefone: </td>
                        <td> <input type="number"
                                    name="telefone"
                                    required value="<c:out value='${site.telefone}' />"
                             />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <input type="submit" value="Cadastrar" /> </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
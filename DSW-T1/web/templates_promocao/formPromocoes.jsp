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
    <body>
        <center>
            <h1><f:message key="formPromocao.bigTitle" /></h1>
            <h2>
                <a href="cadastro"><f:message key="formPromocao.goToAdd" /></a>|
                <a href="../promocao/"><f:message key="formPromocao.goToList" /></a>
            </h2>
        </center>
        <div align="center">
            <c:if test="${promocao != null}"><form action="atualizacao" method="post"></c:if>
            <c:if test="${promocao == null}"><form action="insercao" method="post"></c:if>
                <h2>
                    <c:if test="${promocao != null}"><f:message key="formPromocao.smallTitle.editar" /></c:if>
                    <c:if test="${promocao == null}"><f:message key="formPromocao.smallTitle.cadastrar" /></c:if>
                </h2>
                <table border="1" cellpadding="5">   
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
                            />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="formPromocao.form.data" /> </th>
                        <td>
                            <input type="text" 
                                   data-language="pt-BR"
                                   name="dia"
                                   class="datepicker-here data" 
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
                                   class="horario" 
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
                                   class="preco"
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
                                   class="cnpj"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" 
                                   value="<f:message key="formPromocao.form.submit" />" 
                            />
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>
</f:bundle>

package server


import grails.rest.*

@Resource(uri = '/promocoes', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    // Site site
    // Teatro teatro
    String url
    String nome_peca
    Float preco
    Date dia_hora
    String cnpj
}
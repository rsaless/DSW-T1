package server


import grails.rest.*

@Resource(uri = '/sites', readOnly = false, formats = ['json', 'xml'])
class Site {
    String email
    String senha
    String url
    String nome
    Long telefone
    List<Promocao> promocoes
}
package server


import grails.rest.*

@Resource(uri = '/usuarios', readOnly = false, formats = ['json', 'xml'])
class Usuario {
    String email
    String senha
    Boolean ativo
    List<Papel> papeis

    def List<Site> list() {
        return Site.all
    }
}
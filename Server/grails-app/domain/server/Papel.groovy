package server


import grails.rest.*

@Resource(uri = '/papeis', readOnly = false, formats = ['json', 'xml'])
class Papel {
    String nome
    List<Usuario> usuarios

    def List<Site> list() {
        return Site.all
    }
}
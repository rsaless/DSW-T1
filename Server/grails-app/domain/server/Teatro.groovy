package server


import grails.rest.*

@Resource(uri = '/teatros', readOnly = false, formats = ['json', 'xml'])
class Teatro {
    String email
    String senha
    String cidade
    String nome
    String cnpj
    List<Promocao> promocoes_teatro

    def List<Teatro> list() {
        return Teatro.all
    }
}
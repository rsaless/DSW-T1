package server


import grails.rest.*

@Resource(uri = '/teatros', readOnly = false, formats = ['json', 'xml'])
class Teatro {

    static constraints = {
        cidade blank: false
        email blank: false
        senha blank: false
        cnpj blank: false
        nome blank: false

        cidade unique: false
        email unique: true
        senha unique: false
        cnpj unique: true
        nome unique: false
    }

    String email
    String senha
    String cidade
    String nome
    String cnpj

    def List<Teatro> list() {
        return Teatro.all
    }
}
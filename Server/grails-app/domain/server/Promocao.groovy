package server

import grails.rest.*

@Resource(uri = '/promocoes', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    static constraints = {
        //nome_site blank: false
        //nome_site unique: false

        //cnpj blank: false
        //cnpj unique: false

        dia_hora blank: false
        dia_hora unique: false

        nome_peca blank: false
        nome_peca unique: false
        
        preco blank: false
        preco unique: false
        preco min: new Float(0.01)

        site nullable: false
        site unique: false
        
        teatro nullable: false
        teatro unique: false
    }

    String nome_peca
    Float preco
    //String cnpj
    Date dia_hora
    //String nome_site
    Site site
    Teatro teatro

    def List<Promocao> list() {
        return Promocao.all
    }
}
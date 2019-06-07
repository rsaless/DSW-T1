package server


import grails.rest.*
import grails.converters.*

class PromocaoController extends RestfulController {
    static responseFormats = ['json', 'xml']
    PromocaoController() {
        super(Promocao)
    }

    def List<Promocao> index() {
        respond Promocao.list(), view: 'index'
    }
}

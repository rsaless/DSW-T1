package server


import grails.rest.*
import grails.converters.*

class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }

    def List<Teatro> index() {
        respond Teatro.list(), view: 'index'
    }
}

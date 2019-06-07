package server


import grails.rest.*
import grails.converters.*

class PapelController extends RestfulController {
    static responseFormats = ['json', 'xml']
    PapelController() {
        super(Papel)
    }

    def List<Papel> index() {
        respond Papel.list(), view: 'index'
    }
}

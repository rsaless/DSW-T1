package server

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }

    def List<Teatro> index() {
        if (params.cidade){respond Teatro.findAllByCidade(params.cidade), view: 'index'} 
        else {respond Teatro.list(), view: 'index'}
    }
}

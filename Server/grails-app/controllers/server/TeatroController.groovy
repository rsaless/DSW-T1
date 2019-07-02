package server

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_SITE','ROLE_TEATRO'])
class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }

    def List<Teatro> index() {
        if (params.cidade){respond Teatro.findAllByCidadeLike("%" + params.cidade + "%"), view: 'index'} 
        else {respond Teatro.list(), view: 'index'}
    }

}


/*

HTTP Method	    URI	                Controller Action   Return Value
GET             /books              index               java.lang.Object
GET             /books/create       create              java.lang.Object
POST            /books              save    	        java.lang.Object
GET             /books/${id}        show                java.lang.Object
GET             /books/${id}/edit   edit                java.lang.Object
PUT             /books/${id}        update              java.lang.Object
DELETE          /books/${id}        delete              java.lang.Object

*/
package server

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.transaction.annotation.*
import auth.UserRole
import auth.Role

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

    @Transactional
    def Teatro delete(Teatro teatro){

        //Apagar papel do teatro
        Role papel_teatro = Role.findByAuthority('ROLE_TEATRO')
        println('papel = ' + papel_teatro)

        //Apagar promocoes do teatro
        let promocoes = Promocao.findAllByTeatro(teatro)
        promocoes.delete()

        //Apagar teatro
        UserRole.remove(teatro,papel_teatro)
        teatro.delete(flush: true);

        println 'saindo do delete'
        respond teatro, view: 'delete'
    }

    def Teatro save(Teatro teatro){
        super.save(teatro)
        Role papel_teatro = Role.findByAuthority('ROLE_TEATRO')
        UserRole.create(teatro, papel_teatro, true)
        respond teatro, view: 'save'
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
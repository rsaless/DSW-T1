package server

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_SITE','ROLE_TEATRO'])
class PromocaoController extends RestfulController {
    static responseFormats = ['json', 'xml']
    PromocaoController() {
        super(Promocao)
    }

    def List<Promocao> index() {
        if (params.cnpj){
            def teatro = Teatro.findByCnpjLike("%" + params.cnpj + "%")
            respond Promocao.findAllByTeatro(teatro), view: 'index'
        } else if (params.url){
            def site = Site.findByNomeLike("%" + params.url + "%")
            respond Promocao.findAllBySite(site), view: 'index'
        } else {
            respond Promocao.list(), view: 'index'
        }
    }
}
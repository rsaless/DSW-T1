package server

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_SITE','ROLE_TEATRO'])
class SiteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SiteController() {
        super(Site)
    }

    def List<Site> index() {
        respond Site.list(), view: 'index'
    }
}

package server


import grails.rest.*
import grails.converters.*

class SiteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SiteController() {
        super(Site)
    }

    def List<Site> index() {
        respond Site.list(), view: 'index'
    }
}

package server


import grails.rest.*
import grails.converters.*

class UsuarioController extends RestfulController {
    static responseFormats = ['json', 'xml']
    UsuarioController() {
        super(Usuario)
    }

    def List<Usuario> index() {
        respond Usuario.list(), view: 'index'
    }
}

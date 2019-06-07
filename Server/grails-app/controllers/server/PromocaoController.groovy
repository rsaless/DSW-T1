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

    def List<Promocao> getByCnpj(params) {
        respond Promocao.findAllByCnpj(params.cnpj), view: 'index'
    }

    def List<Promocao> getByNomeSite(params) {
        respond Promocao.findAllByNome_site(params.nome_site), view: 'index'
    }
}

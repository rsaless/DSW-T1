package server

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        "/teatros"(resources:"teatro")
        "/sites"(resources:"site")
        "/promocoes"(resources:"promocao")
        "/usuarios"(resources:"usuario")
        "/papeis"(resources:"papel")

        "/teatros/cidade/$cidade"(controller: 'teatro', action: 'getByCidade')
        "/promocoes/teatro/$cnpj"(controller: 'promocao', action: 'getByCnpj')
        "/promocoes/site/$nome_site"(controller: 'promocao', action: 'getByNomeSite')
    }
}

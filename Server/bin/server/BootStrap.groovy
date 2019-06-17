package server

import server.*

class BootStrap {

    def init = { servletContext ->

        // Criando os papeis
        /*
        def papel_admin = new Papel(nome: "ROLE_ADMIN", usuarios: [])
        def papel_teatro = new Papel(nome: "ROLE_TEATRO", usuarios: [])
        def papel_site = new Papel(nome: "ROLE_SITE", usuarios: [])
        papel_admin.save flush: true
        papel_teatro.save flush: true
        papel_site.save flush: true
        */

        // Criando Admins
        /*
        for(int i = 1; i <= 5; i++){
            def usuario_admin = new Usuario(
                email: "admin" + i + "@gmail.com",
                senha: "admin" + i + "_pass",
                ativo: true,
                papeis: []
            )
            usuario_admin.papeis.push(papel_admin)
            usuario_admin.save flush: true
        }*/

        def teatros = new Teatro[12];
        def sites = new Site[12];
        def promocoes = new Promocao[12];

        // Criando Teatros
        for(int i = 0; i < 12; i++){
            teatros[i] = new Teatro(
                email: "teatro" + i + "@gmail.com",
                senha: "teatro" + i + "_pass",
                cidade: "Cidade " + i,
                nome: "Teatro da Cidade" + i,
                cnpj: "111000000" + i
            )
            teatros[i].save flush: true
            /*
            def usuario_teatro = new Usuario(
                    email: "teatro" + i + "@gmail.com",
                    senha: "teatro" + i + "_pass",
                    ativo: true,
                    papeis: []
            )
            usuario_teatro.papeis.push(papel_teatro)
            usuario_teatro.save flush: true
            */
        }

        // Criando Sites
        for(int i = 0; i < 12; i++){
            sites[i] = new Site(
                    email: "site" + i + "@gmail.com",
                    senha: "site" + i + "_pass",
                    url: "https://www.site" + i + ".com.br",
                    nome: "Site" + i,
                    telefone: 33330000L + i
            )
            sites[i].save flush: true
            /*
            def usuario_site = new Usuario(
                    email: "site" + i + "@gmail.com",
                    senha: "site" + i + "_pass",
                    ativo: true,
                    papeis: []
            )
            usuario_site.papeis.push(papel_site)
            usuario_site.save flush: true
            */
        }

        // Criando Promocoes
        for(int i = 0; i < 12; i++){
            def date = Date.parse("dd/MM/yyyy hh:mm", "20/05/200" + i +" 23:0" + i)
            promocoes[i] = new Promocao(
                nome_site: sites[i].nome,
                nome_peca: "promocao" + i,
                preco: 20+i*0.1f,
                dia_hora: date,
                cnpj: teatros[i].cnpj,
                teatro: teatros[i],
                site: sites[i]
            )
            promocoes[i].save flush: true
        }
    }
    
    def destroy = {
    }
}

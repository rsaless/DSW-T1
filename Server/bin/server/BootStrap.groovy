package server

import server.*
import auth.User
import auth.UserRole
import auth.Role

class BootStrap {

    def init = { servletContext ->

        // Criando os papeis
        Role papel_admin = new Role(authority: 'ROLE_ADMIN').save()
        Role papel_teatro = new Role(authority: 'ROLE_TEATRO').save()
        Role papel_site = new Role(authority: 'ROLE_SITE').save()
        

        // Criando Admins
        for(int i = 1; i <= 5; i++){
            User usuario_admin = new User(
                username: "admin" + i + "@gmail.com", 
                password: "admin" + i + "_pass"
            ).save()
            UserRole.create(usuario_admin, papel_admin, true)
        }

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

            User usuario_teatro = new User(
                username: "teatro" + i + "@gmail.com", 
                password: "teatro" + i + "_pass"
            ).save()
            UserRole.create(usuario_teatro, papel_teatro, true)
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
            
            User usuario_site = new User(
                username: "site" + i + "@gmail.com", 
                password: "site" + i + "_pass"
            ).save()
            UserRole.create(usuario_site, papel_site, true)
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

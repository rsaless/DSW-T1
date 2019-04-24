package Tests;

import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.TeatroDAO;
import DAO.UsuarioDAO;

import Models.Site;
import java.util.List;

public class DAOTester {
    public static void main(String[] args){
        PromocaoDAO promocaoDao = new PromocaoDAO();
        SiteDAO siteDao = new SiteDAO();
        TeatroDAO teatroDao = new TeatroDAO();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        Site site = new Site("site6@email.com", "site6_pass", "https://www.site6.com.br", "site6", 33330006L,6);
        siteDao.inserir(site);
        System.out.println(siteDao.listar().toString());
        site.setNome("FUNCIONOU");
        siteDao.atualizar(site);
        System.out.println(siteDao.listar());
        siteDao.deletar(site);
        System.out.println(siteDao.listar());
    }
}
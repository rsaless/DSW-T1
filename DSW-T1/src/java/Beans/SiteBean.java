package Beans;

import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.UsuarioDAO;
import Models.Promocao;
import Models.Site;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {
    private Site site;
    private List<Promocao> promocoes;
    
    public String lista() {
        return "/templates_site/listaSites.xhtml";
    }
    
    public String apresentaFormCadastro(){
        site = new Site();
        return "/templates_site/formSite.xhtml";
    }
    
    public String apresentaFormEdicao(int id){
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "/templates_site/formSite.xhtml";
    }
    
    public String salva(){
        SiteDAO dao = new SiteDAO();
        UsuarioDAO udao = new UsuarioDAO();
        if (site.getId() == null){
            dao.inserir(site);
            // ao cadastrar um site, criar o login pro usuário site
            // udao.inserir(site);
        } else {
            dao.atualizar(site);
            // ao atualizar um site, atializar o login pro usuário site
            // udao.atualizar(site);
        }
        return "/templates_site/listaSites.xhtml";
    }
    
    public String remove(Site site){
        SiteDAO dao = new SiteDAO();
        dao.deletar(site);
        return "/templates_site/listaSites.xhtml";
    }
    
    public String detalhes(int id){
        SiteDAO dao = new SiteDAO();
        PromocaoDAO pdao = new PromocaoDAO();
        site = dao.get(id);
        promocoes = pdao.listar_site(site.getUrl());
        return "/templates_site/detalheSite.xhtml";
    }
    
    public String erro(){
        return "/templates_erro/404.xhtml";
    }
    
    public String home() {
        return "/index.xhtml?faces-redirect=true";
    }
}
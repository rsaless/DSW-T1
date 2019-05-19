package Beans;

import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.UsuarioDAO;
import Models.Promocao;
import Models.Site;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {
    private Site site;
    private List<Promocao> promocoes;
    private String form_title;
    
    public String lista() {
        return "/site/index.xhtml";
    }
    
    public String apresentaFormCadastro(){
        site = new Site();
        form_title = "formSite.smallTitle.cadastrar";
        return "/site/form.xhtml";
    }
    
    public String apresentaFormEdicao(int id){
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        form_title = "formSite.smallTitle.editar";
        return "/site/form.xhtml";
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
        return "index.xhtml";
    }
    
    public String remove(Site site){
        SiteDAO dao = new SiteDAO();
        dao.deletar(site);
        return "/site/index.xhtml";
    }
    
    public String detalhes(int id){
        SiteDAO dao = new SiteDAO();
        PromocaoDAO pdao = new PromocaoDAO();
        site = dao.get(id);
        promocoes = pdao.listar_site(site.getUrl());
        return "/site/detalhes.xhtml";
    }
    
    public String erro(){
        return "/erro/404.xhtml";
    }
    
    public String home() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.listar();
    }
    
    public Site getSite() {
        return site;
    }
    
    public String getForm_title() {
        return form_title;
    }
    
}
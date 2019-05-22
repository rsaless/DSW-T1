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
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {
    private Site site;
    private List<Promocao> promocoes;
    private String form_title;
    private String currentUserEmail;
    private String currentRole;
    
    public String lista() {
        currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        currentRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        currentRole = currentRole.substring(currentRole.indexOf("[") + 1);
        currentRole = currentRole.substring(0, currentRole.indexOf("]"));
        System.out.println("\n\nEmail atual: " + currentUserEmail + "\n");
        System.out.println("Principal: " + currentRole + "\n\n");
        return "/site/index.xhtml?faces-redirect=true";
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
        return "/site/form.xhtml?faces-redirect=true";
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
        return "index.xhtml?faces-redirect=true";
    }
    
    public String remove(Site site){
        SiteDAO dao = new SiteDAO();
        dao.deletar(site);
        return "/site/index.xhtml?faces-redirect=true";
    }
    
    public String detalhes(int id){
        SiteDAO dao = new SiteDAO();
        PromocaoDAO pdao = new PromocaoDAO();
        site = dao.get(id);
        promocoes = pdao.listar_site(site.getUrl());
        return "/site/detalhes.xhtml?faces-redirect=true";
    }
    
    public String home() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.listar();
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listar_site(site.getUrl());
    }    
    
    public Site getSite() {
        return site;
    }
    
    public String getForm_title() {
        return form_title;
    }

    public String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public String getCurrentRole() {
        return currentRole;
    }
    
    
    
}
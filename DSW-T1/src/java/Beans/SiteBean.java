package Beans;

import DAO.PapelDAO;
import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.UsuarioDAO;
import Models.Papel;
import Models.Promocao;
import Models.Site;
import Models.Teatro;
import Models.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {
    private Site site;
    private List<Promocao> promocoes;
    private String form_title;
    private String currentUserEmail;
    private String currentRole;
    private Site site_em_edicao;
    
    public String lista() {
        currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        currentRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        currentRole = currentRole.substring(currentRole.indexOf("[") + 1);
        currentRole = currentRole.substring(0, currentRole.indexOf("]"));
        // System.out.println("\n\nEmail atual: " + currentUserEmail + "\n");
        // System.out.println("Principal: " + currentRole + "\n\n");
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
        site_em_edicao = dao.get(id);
        form_title = "formSite.smallTitle.editar";
        return "/site/form.xhtml?faces-redirect=true";
    }
    
    public String salva(){
        SiteDAO dao = new SiteDAO();
        UsuarioDAO udao = new UsuarioDAO();
        if (site.getId() == null){
            dao.inserir(site);
            criaUsuarioSite(site);
        } else {
            dao.atualizar(site);
            atualizaUsuarioSite(site_em_edicao, site);
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
    
    private void criaUsuarioSite(Site site){
        UsuarioDAO udao = new UsuarioDAO();
        PapelDAO pdao = new PapelDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        System.out.println(site.toString());
        Usuario usuario_site = new Usuario();
        usuario_site.setEmail(site.getEmail());
        usuario_site.setSenha(encoder.encode(site.getSenha()));
        usuario_site.setAtivo(true);
        udao.inserir(usuario_site);

        Papel papel_site = pdao.get_role("ROLE_SITE");
        usuario_site.getPapel().add(papel_site);
        System.out.println(usuario_site.toString());
        udao.atualizar(usuario_site);
    }
    private void atualizaUsuarioSite(Site site_antigo, Site site_novo){
        UsuarioDAO udao = new UsuarioDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario_site = udao.get_usuario(site_antigo.getEmail());
        usuario_site.setEmail(site_novo.getEmail());
        usuario_site.setSenha(encoder.encode(site_novo.getSenha()));
        udao.atualizar(usuario_site);
    }
    
}
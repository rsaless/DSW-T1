package Beans;

import DAO.PapelDAO;
import DAO.TeatroDAO;
import DAO.UsuarioDAO;
import Models.Papel;
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
public class TeatroBean implements Serializable{
    private Teatro teatro;
    private Teatro teatro_em_edicao;
    private String form_title;
    private String currentUserEmail;
    private String currentRole;
    
    public String lista() {
        currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        currentRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        currentRole = currentRole.substring(currentRole.indexOf("[") + 1);
        currentRole = currentRole.substring(0, currentRole.indexOf("]"));
        // System.out.println("\n\nEmail atual: " + currentUserEmail + "\n");
        // System.out.println("Principal: " + currentRole + "\n\n");
        return "/teatro/index.xhtml?faces-redirect=true";
    }
    
    public String apresentaFormCadastro() {
        teatro = new Teatro();
        form_title = "formTeatro.smallTitle.cadastrar";
        return "/teatro/form.xhtml?faces-redirect=true";
    }
    
    public String apresentaFormEdicao(int id){
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        teatro_em_edicao = dao.get(id);
        form_title = "formTeatro.smallTitle.editar";
        return "/teatro/form.xhtml?faces-redirect=true";
    }
    
    public String salva(){
        TeatroDAO dao = new TeatroDAO();
        if (teatro.getId() == null){
            dao.inserir(teatro);
            System.out.println(teatro.toString());
            criaUsuarioTeatro(teatro);
        } else {
            dao.atualizar(teatro);
            atualizaUsuarioTeatro(teatro_em_edicao, teatro);
        }
        return "/teatro/index.xhtml?faces-redirect=true";
    }
    
    public String remove(Teatro teatro){
        TeatroDAO dao = new TeatroDAO();
        dao.deletar(teatro);
        return "/teatro/index.xhtml?faces-redirect=true";
    }

    public String home() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Teatro> buscarPorCidade(String cidade_desejada_s) {
        List<Teatro> resultados;
        TeatroDAO dao = new TeatroDAO();
        if(cidade_desejada_s != ""){
            resultados = dao.listar_cidade(cidade_desejada_s);
        } else {
            resultados = dao.listar();
        }
        return resultados;
    }
    
    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.listar();
    }
    
    public Teatro getTeatro() {
        return teatro;
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
    
    private void criaUsuarioTeatro(Teatro teatro){
        UsuarioDAO udao = new UsuarioDAO();
        PapelDAO pdao = new PapelDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        System.out.println(teatro.toString());
        Usuario usuario_teatro = new Usuario();
        usuario_teatro.setEmail(teatro.getEmail());
        usuario_teatro.setSenha(encoder.encode(teatro.getSenha()));
        usuario_teatro.setAtivo(true);
        udao.inserir(usuario_teatro);

        Papel papel_teatro = pdao.get_role("ROLE_TEATRO");
        usuario_teatro.getPapel().add(papel_teatro);
        System.out.println(usuario_teatro.toString());
        udao.atualizar(usuario_teatro);
    }
    private void atualizaUsuarioTeatro(Teatro teatro_antigo, Teatro teatro_novo){
        UsuarioDAO udao = new UsuarioDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario_teatro = udao.get_usuario(teatro_antigo.getEmail());
        usuario_teatro.setEmail(teatro_novo.getEmail());
        usuario_teatro.setSenha(encoder.encode(teatro_novo.getSenha()));
        udao.atualizar(usuario_teatro);
    }
    
}

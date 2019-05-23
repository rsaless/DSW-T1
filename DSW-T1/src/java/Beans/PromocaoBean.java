package Beans;

import DAO.PromocaoDAO;
import DAO.TeatroDAO;
import Models.Promocao;
import Models.Teatro;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable{
    private Promocao promocao;
    private String form_title;
    private String currentUserEmail;
    private String currentRole;
    private String currentUserCNPJ;
    
    public String lista() {
        currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        currentRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        currentRole = currentRole.substring(currentRole.indexOf("[") + 1);
        currentRole = currentRole.substring(0, currentRole.indexOf("]"));
        currentUserCNPJ = new TeatroDAO().get_email(currentUserEmail).getCnpj();
        // System.out.println("\n\nEmail atual: " + currentUserEmail + "\n");
        //System.out.println("Principal: " + currentRole + "\n\n");
        return "/promocao/index.xhtml?faces-redirect=true";
    }
    
    public String apresentaFormCadastro() {
        promocao = new Promocao();
        form_title = "formPromocao.smallTitle.cadastrar";
        return "/promocao/form.xhtml?faces-redirect=true";
    }
    
    public String apresentaFormEdicao(int id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        form_title = "formPromocao.smallTitle.editar";
        return "/promocao/form.xhtml?faces-redirect=true";
    }
    
    public String salva(){
        PromocaoDAO dao = new PromocaoDAO();
        TeatroDAO tdao = new TeatroDAO();
        
        if (promocao.getId() == null){
            dao.inserir(promocao);
        } else {
            dao.atualizar(promocao);
        }
        return "/promocao/index.xhtml?faces-redirect=true";
    }
    
    public String remove(Promocao promocao){
        PromocaoDAO dao = new PromocaoDAO();
        dao.deletar(promocao);
        return "/promocao/index.xhtml?faces-redirect=true";
    }
    
    public String home() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Promocao> buscarPorTeatro(String cnpj_desejado){
        List<Promocao> resultados;
        PromocaoDAO dao = new PromocaoDAO();
        
        if(cnpj_desejado != ""){
            resultados = dao.listar_teatro(cnpj_desejado);
        } else {
            resultados = dao.listar();
        }
        
        return resultados;
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listar();
    }
    
    public Promocao getPromocao() {
        return promocao;
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

    public String getCurrentUserCNPJ() {
        return currentUserCNPJ;
    }
    
}
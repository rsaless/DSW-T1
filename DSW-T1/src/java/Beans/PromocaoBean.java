package Beans;

import DAO.PromocaoDAO;
import DAO.TeatroDAO;
import Models.Promocao;
import Models.Teatro;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable{
    private Promocao promocao;
    
    public String lista() {
        return "/templates_promocao/listaPromocoes.xhtml";
    }
    
    public String apresentaFormCadastro() {
        promocao = new Promocao();
        return "/templates_promocao/formPromocao.xhtml";
    }
    
    public String apresentaFormEdicao(int id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "/templates_promocao/formPromocao.xhtml";
    }
    
    public String salva(){
        PromocaoDAO dao = new PromocaoDAO();
        TeatroDAO tdao = new TeatroDAO();
        
        if (promocao.getId() == null){
            dao.inserir(promocao);
        } else {
            dao.atualizar(promocao);
        }
        return "/templates_promocao/listaPromocoes.xhtml";
    }
    
    public String remove(Promocao promocao){
        PromocaoDAO dao = new PromocaoDAO();
        dao.deletar(promocao);
        return "/templates_promocao/listaPromocoes.xhtml";
    }
    
    public String erro(){
        return "/templates_erro/404.xhtml";
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
    
}
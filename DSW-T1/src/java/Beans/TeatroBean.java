package Beans;

import DAO.TeatroDAO;
import DAO.UsuarioDAO;
import Models.Teatro;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TeatroBean implements Serializable{
    private Teatro teatro;
    
    public String lista() {
        return "templates_teatro/listaTeatros.xhtml";
    }
    
    public String apresentaFormCadastro() {
        teatro = new Teatro();
        return "templates_teatro/formTeatro.xhtml";
    }
    
    public String apresentaFormEdicao(int id){
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "templates_teatro/formTeatro.xhtml";
    }
    
    public String salva(){
        TeatroDAO dao = new TeatroDAO();
        UsuarioDAO udao = new UsuarioDAO();
        if (teatro.getId() == null){
            dao.inserir(teatro);
            // ao cadastrar um site, criar o login pro usuário site
            // udao.inserir(site);
        } else {
            dao.atualizar(teatro);
            // ao atualizar um site, atializar o login pro usuário site
            // udao.atualizar(site);
        }
        return "templates_teatro/listaTeatros.xhtml";
    }
    
    public String remove(Teatro teatro){
        TeatroDAO dao = new TeatroDAO();
        dao.deletar(teatro);
        return "templates_teatro/listaTeatros.xhtml";
    }
    
    public String erro(){
        return "/templates_erro/404.xhtml";
    }
    
    private List<Teatro> buscarPorCidade(String cidade_desejada_s) {
        List<Teatro> resultados;
        TeatroDAO dao = new TeatroDAO();
        if(cidade_desejada_s != ""){
            resultados = dao.listar_cidade(cidade_desejada_s);
        } else {
            resultados = dao.listar();
        }
        return resultados;
    }
}

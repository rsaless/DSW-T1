package Controllers;

import DAO.PromocaoDAO;
import Models.Promocao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/promocao/*")
public class PromocaoServlet extends HttpServlet {
    
    private PromocaoDAO dao;
    
    @Override
    public void init() {
        dao = new PromocaoDAO();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getPathInfo();
        if(action == null) action = "";
        try {
            switch (action){
                case "/cadastro": 
                    apresentaFormCadastro(request, response); 
                    break;
                case "/insercao": 
                    insere(request, response); 
                    break;
                case "/remocao": 
                    remove(request, response); 
                    break;
                case "/edicao": 
                    apresentaFormEdicao(request, response); 
                    break;
                case "/atualizacao": 
                    atualize(request, response); 
                    break;
                default: 
                    lista(request, response); 
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = dao.listar();
        request.setAttribute("listaPromocoes", promocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_promocao/listaPromocoes.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_promocao/formPromocoes.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Promocao promocao = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_promocao/formPromocoes.jsp");
        request.setAttribute("promocao", promocao);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String nome_peca = request.getParameter("nome_peca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        LocalDate dia = LocalDate.parse(request.getParameter("dia"));//"2017-02-05"
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));//"10:15:30"
        Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));

        Promocao promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj);
        dao.inserir(promocao);
        response.sendRedirect("/DSW-T1/promocao");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String nome_peca = request.getParameter("nome_peca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        LocalDate dia = LocalDate.parse(request.getParameter("dia"));//"2017-02-05"
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));//"10:15:30"
        Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));

        Promocao promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj, id);
        dao.atualizar(promocao);
        response.sendRedirect("/DSW-T1/promocao");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Promocao promocao = new Promocao(id);
        dao.deletar(promocao);
        response.sendRedirect("/DSW-T1/promocao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        processRequest(request, response);
    }
}

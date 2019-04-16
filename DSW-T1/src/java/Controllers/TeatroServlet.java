package Controllers;

import DAO.TeatroDAO;
import Models.Teatro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/teatro")
public class TeatroServlet extends HttpServlet {
    private TeatroDAO dao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action){
                case "/cadastro": apresentaFormCadastro(request, response); break;
                // case "/insercao": insere(request, response); break;
                case "/remocao": remove(request, response); break;
                case "/edicao": apresentaFormEdicao(request, response); break;
                // case "/atualizacao": atualize(request, response); break;
                default: lista(request, response); break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teatro> teatros = dao.listar();
        request.setAttribute("listaTeatros", teatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/listaTeatros.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/formTeatro.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Teatro teatro = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/formTeatro.jsp");
        request.setAttribute("teatro", teatro);
        dispatcher.forward(request, response);
    }
    
    /*
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));

        Livro livro = new Livro(titulo, autor, ano, preco);
        dao.insert(livro);
        response.sendRedirect("lista");
    }
    */
    /*
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));

        Livro livro = new Livro(id, titulo, autor, ano, preco);
        dao.update(livro);
        response.sendRedirect("lista");
    }
    */

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Teatro teatro = new Teatro(id);
        dao.deletar(teatro);
        response.sendRedirect("lista");
    }
    
    @Override
    public void init() {
        dao = new TeatroDAO();
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

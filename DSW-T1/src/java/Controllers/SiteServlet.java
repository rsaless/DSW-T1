package Controllers;

import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.UsuarioDAO;
import Models.Papel;
import Models.Promocao;
import Models.Site;
import Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/site/*")
public class SiteServlet extends HttpServlet {
    
    private SiteDAO siteDao;
    private PromocaoDAO promocaoDao;
    private UsuarioDAO usuarioDAO;
    
    @Override
    public void init() {
        siteDao = new SiteDAO();
        promocaoDao = new PromocaoDAO();
        usuarioDAO = new UsuarioDAO();
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
                case "/detalhes": 
                    detalhes(request, response); 
                    break;
                case "/lista": 
                    lista(request, response);
                    break;
                default: 
                    erro(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/templates_erro/500.jsp").forward(request, response);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Site> sites = siteDao.listar();
        request.setAttribute("listaSites", sites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_site/listaSites.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_site/formSite.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Site site = siteDao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_site/formSite.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }
    
    private void detalhes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Site site = siteDao.get(id);
        System.out.println(id);
        System.out.println(site.getUrl());
        List<Promocao> promocoes = promocaoDao.listar_site(site.getUrl());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_site/detalheSite.jsp");
        request.setAttribute("site", site);
        request.setAttribute("listaPromocoes", promocoes);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        Long telefone = Long.parseLong(request.getParameter("telefone"));

        Site site = new Site(email, senha, url, nome, telefone);
        siteDao.inserir(site);
        usuarioDAO.inserir_usuario(new Usuario(email, senha));
        usuarioDAO.inserir_role(new Papel(email, "USER_SITE"));
        response.sendRedirect("/DSW-T1/site");
    }
    
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        Long telefone = Long.parseLong(request.getParameter("telefone"));

        Site site = new Site(email, senha, url, nome, telefone, id);
        siteDao.atualizar(site);
        response.sendRedirect("/DSW-T1/site");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Site site = new Site(id);
        siteDao.deletar(site);
        response.sendRedirect("/DSW-T1/site");
    }
    
    private void erro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_erro/404.jsp");
        dispatcher.forward(request, response);
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

package Controllers;

import DAO.PromocaoDAO;
import Models.Promocao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
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
                case "/lista": 
                    lista(request, response);
                    break;
                case "/ajax":
                    buscarPorTeatro(request,response);
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
        response.sendRedirect("/DSW-T1/promocao/lista");
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
        response.sendRedirect("/DSW-T1/promocao/lista");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Promocao promocao = new Promocao(id);
        dao.deletar(promocao);
        response.sendRedirect("/DSW-T1/promocao/lista");
    }
    
    private void erro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates_erro/404.jsp");
        dispatcher.forward(request, response);
    }
    
    private void buscarPorTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cnpj_desejado_s = request.getParameter("cnpj");
        List<Promocao> resultados;
        if(cnpj_desejado_s != ""){
            resultados = dao.listar_teatro(Integer.parseInt(cnpj_desejado_s));
        } else {
            resultados = dao.listar();
        }
        Locale currentLocale = request.getLocale();
        Properties prop = new Properties();
        String resposta = "";
        
        String filename = "/WEB-INF/properties/sistema_"+ currentLocale.getLanguage() +"_"+ currentLocale.getCountry() +".properties";    
        prop.load(getServletContext().getResourceAsStream(filename));
        
        for(Promocao promocao : resultados){
            resposta += 
                "<tr>"+
                    "<td class=\"text-center\">" + promocao.getId() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getUrl() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getNome_peca() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getDia() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getHora() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getPreco() + "</td>" +
                    "<td class=\"text-center\">" + promocao.getCnpj() + "</td>" +
                    "<td class=\"text-center\">" +
                        "<a href=\"/DSW-T1/promocao/edicao?id=" + promocao.getId() +"\">" + prop.getProperty("listaPromocoes.table.acoes.editar") + "</a>" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;"+
                        "<a href=\"/DSW-T1/promocao/remocao?id="+ promocao.getId() + "\" onclick=\"return confirm('" + prop.getProperty("remover.confirm") + "');\">" + prop.getProperty("listaPromocoes.table.acoes.remover") + "</a></td>" +
                "</tr>";
        }
        response.getWriter().println(resposta);
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

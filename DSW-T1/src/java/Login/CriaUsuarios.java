package Login;

import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.TeatroDAO;
import DAO.UsuarioDAO;
import Models.Papel;
import Models.Promocao;
import Models.Site;
import Models.Teatro;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {
    public static void main(String[] args) throws ClassNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            TeatroDAO teatroDAO = new TeatroDAO();
            SiteDAO siteDAO = new SiteDAO();
            PromocaoDAO promocaoDAO = new PromocaoDAO();

            // insere admins
            for(int i = 1; i <= 5; i++){
                Usuario usuario_admin = new Usuario();
                Papel papel = new Papel();
                
                usuario_admin.setEmail("admin" + i + "@gmail.com");
                usuario_admin.setSenha("admin" + i + "_pass");
                usuario_admin.setAtivo(true);
                
                papel.setEmail(usuario_admin.getEmail());
                papel.setNome("ROLE_ADMIN");
                
                usuarioDAO.inserir(usuario_admin);
                usuarioDAO.inserir_role(papel);
            }

            // insere teatros
            for(int i = 1; i <= 5; i++){
                Teatro teatro = new Teatro();
                Usuario usuario_teatro = new Usuario();
                Papel papel = new Papel();
                
                teatro.setEmail("teatro" + i + "@gmail.com");
                teatro.setSenha("teatro" + i + "_pass");
                teatro.setCidade("Cidade" + i);
                teatro.setNome("Teatro da Cidade" + i);
                teatro.setCnpj("111000000" + i);
                
                usuario_teatro.setEmail(teatro.getEmail());
                usuario_teatro.setSenha(encoder.encode(teatro.getSenha()));
                usuario_teatro.setAtivo(true);
                
                papel.setEmail(teatro.getEmail());
                papel.setNome("ROLE_TEATRO");
                
                teatroDAO.inserir(teatro);
                usuarioDAO.inserir(usuario_teatro);
                usuarioDAO.inserir_role(papel);
            }
            
            // insere sites
            for(int i = 1; i <= 5; i++){
                Site site = new Site();
                Usuario usuario_site = new Usuario();
                Papel papel = new Papel();
                
                site.setEmail("site" + i + "@gmail.com");
                site.setSenha("site" + i + "_pass");
                site.setUrl("https://www.site" + i + ".com.br");
                site.setNome("Site" + i);
                site.setTelefone(33330000L + i);
                
                
                usuario_site.setEmail(site.getEmail());
                usuario_site.setSenha(encoder.encode(site.getSenha()));
                usuario_site.setAtivo(true);
                
                papel.setEmail(site.getEmail());
                papel.setNome("ROLE_SITE");
                
                siteDAO.inserir(site);
                usuarioDAO.inserir(usuario_site);
                usuarioDAO.inserir_role(papel);
            }

            // insere promocoes
            for(int i = 1; i <= 5; i++){
                Promocao promocao = new Promocao();
                
                promocao.setUrl("https://www.site" + i + ".com.br");
                promocao.setNome_peca("promocao" + i);
                promocao.setPreco(20+i*0.1f);
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm") ;
                promocao.setDia_hora(df.parse("20/05/200" + i + " 23:0" + i));
                promocao.setCnpj("111000000" + i);
                
                promocaoDAO.inserir(promocao);
            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
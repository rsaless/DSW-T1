package Login;

import DAO.PapelDAO;
import DAO.PromocaoDAO;
import DAO.SiteDAO;
import DAO.TeatroDAO;
import DAO.UsuarioDAO;
import Models.Papel;
import Models.Promocao;
import Models.Site;
import Models.Teatro;
import Models.Usuario;
import java.text.SimpleDateFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {
    public static void main(String[] args) throws ClassNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            PapelDAO papelDAO = new PapelDAO();
            TeatroDAO teatroDAO = new TeatroDAO();
            SiteDAO siteDAO = new SiteDAO();
            PromocaoDAO promocaoDAO = new PromocaoDAO();

            //insere papeis
            Papel papel_admin = new Papel();
            papel_admin.setNome("ROLE_ADMIN");
            papelDAO.inserir(papel_admin);
            
            Papel papel_teatro = new Papel();
            papel_teatro.setNome("ROLE_TEATRO");
            papelDAO.inserir(papel_teatro);
            
            Papel papel_site = new Papel();
            papel_site.setNome("ROLE_SITE");
            papelDAO.inserir(papel_site);
            
            // insere admins
            for(int i = 1; i <= 5; i++){
                Usuario usuario_admin = new Usuario();
                usuario_admin.setEmail("admin" + i + "@gmail.com");
                usuario_admin.setSenha(encoder.encode("admin" + i + "_pass"));
                usuario_admin.setAtivo(true);
                usuarioDAO.inserir(usuario_admin);

                usuario_admin.getPapel().add(papel_admin);
                usuarioDAO.atualizar(usuario_admin);
            }

            // insere teatros
            for(int i = 1; i <= 5; i++){
                Teatro teatro = new Teatro();
                teatro.setEmail("teatro" + i + "@gmail.com");
                teatro.setSenha("teatro" + i + "_pass");
                teatro.setCidade("Cidade" + i);
                teatro.setNome("Teatro da Cidade" + i);
                teatro.setCnpj("111000000" + i);
                teatroDAO.inserir(teatro);
                
                Usuario usuario_teatro = new Usuario();
                usuario_teatro.setEmail(teatro.getEmail());
                usuario_teatro.setSenha(encoder.encode(teatro.getSenha()));
                usuario_teatro.setAtivo(true);
                usuarioDAO.inserir(usuario_teatro);
                
                usuario_teatro.getPapel().add(papel_teatro);
                usuarioDAO.atualizar(usuario_teatro);
            }
            
            // insere sites
            for(int i = 1; i <= 5; i++){
                Site site = new Site();
                site.setEmail("site" + i + "@gmail.com");
                site.setSenha("site" + i + "_pass");
                site.setUrl("https://www.site" + i + ".com.br");
                site.setNome("Site" + i);
                site.setTelefone(33330000L + i);
                siteDAO.inserir(site);
                
                Usuario usuario_site = new Usuario();
                usuario_site.setEmail(site.getEmail());
                usuario_site.setSenha(encoder.encode(site.getSenha()));
                usuario_site.setAtivo(true);
                usuarioDAO.inserir(usuario_site);
                
                usuario_site.getPapel().add(papel_site);
                usuarioDAO.atualizar(usuario_site);
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
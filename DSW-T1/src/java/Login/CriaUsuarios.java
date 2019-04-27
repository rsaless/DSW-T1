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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            TeatroDAO teatroDAO = new TeatroDAO();
            SiteDAO siteDAO = new SiteDAO();
            PromocaoDAO promocaoDAO = new PromocaoDAO();

            // insere admins
            for(int i = 1; i <= 5; i++){
                String email = "admin" + i + "@gmail.com";
                String senha = "admin" + i + "_pass";
                String role = "ROLE_ADMIN";
                
                usuarioDAO.inserir_usuario(new Usuario(email, senha));
                usuarioDAO.inserir_role(new Papel(email, role));
            }

            // insere teatros
            for(int i = 1; i <= 5; i++){
                String email = "teatro" + i + "@gmail.com";
                String senha = "teatro" + i + "_pass";
                String cidade = "Cidade" + i;
                String nome = "Teatro da Cidade" + i;
                Long cnpj = 111000000L + i;
                String role = "ROLE_TEATRO";
                
                teatroDAO.inserir(new Teatro(email, senha, cidade, nome, cnpj));
                usuarioDAO.inserir_usuario(new Usuario(email, senha));
                usuarioDAO.inserir_role(new Papel(email, "ROLE_TEATRO"));
            }
            
            // insere sites
            for(int i = 1; i <= 5; i++){
                String email = "site" + i + "@gmail.com";
                String senha = "site" + i + "_pass";
                String site = "https://www.site" + i + ".com.br";
                String nome = "Site" + i;
                Long telefone = 33330000L + i;
                String role = "ROLE_SITE";
                siteDAO.inserir(new Site(email, senha, site, nome, telefone));
                usuarioDAO.inserir_usuario(new Usuario (email, senha));
                usuarioDAO.inserir_role(new Papel(email, "ROLE_SITE"));
            }

            // insere promocoes
            for(int i = 1; i <= 5; i++){
                String url = "https://www.site" + i + ".com.br";
                String nome_peca = "promocao" + i;
                Float preco = 20+i*0.1f;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dia = LocalDate.parse("20/05/2000", formatter);
                LocalTime hora = LocalTime.parse("05:05");
                Long cnpj = 111000000L + i;
                promocaoDAO.inserir(new Promocao(url, nome_peca, preco, dia, hora, cnpj));
            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
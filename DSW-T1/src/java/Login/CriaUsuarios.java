package Login;

import DAO.UsuarioDAO;
import Models.Papel;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.inserir_usuario(new Usuario("usuario01@gmail.com", "senha01"));
            dao.inserir_usuario(new Usuario("usuario02@gmail.com", "senha02"));
            dao.inserir_usuario(new Usuario("usuario03@gmail.com", "senha03"));
            dao.inserir_usuario(new Usuario("usuario04@gmail.com", "senha04"));
            dao.inserir_usuario(new Usuario("usuario05@gmail.com", "senha05"));
            dao.inserir_role(new Papel("usuario01@gmail.com","USER_ADM"));
            dao.inserir_role(new Papel("usuario02@gmail.com","USER_SITE"));
            dao.inserir_role(new Papel("usuario03@gmail.com","USER_SITE"));
            dao.inserir_role(new Papel("usuario04@gmail.com","USER_TEATRO"));
            dao.inserir_role(new Papel("usuario05@gmail.com","USER_TEATRO")); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
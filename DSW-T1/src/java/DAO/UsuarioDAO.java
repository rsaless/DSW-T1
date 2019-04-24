package DAO;

import Models.Papel;
import Models.Usuario;
import Models.UsuarioRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAO{
    /* C */ private final String INSERIR_USUARIO = "INSERT INTO Usuario(email, senha, ativo) values (?,?,1)";   
    /* C */ private final String INSERIR_ROLE = "INSERT INTO Papel(email, nome) values (?,?)"; 
    /* R */ private final String GET_USUARIO = "SELECT * FROM Usuario where email=?";
    /* R */ private final String LISTAR_USUARIOS = "SELECT * FROM Usuario";
    /* R */ private final String LISTAR_ROLES = "SELECT * FROM Papel";
    /* R */ private final String LISTAR_USUARIOS_ROLES = "SELECT u.id \"ID\" u.email \"email\", u.senha \"senha\", u.ativo \"ativo\", r.nome \"papel\" FROM Usuario u INNER JOIN Papel r ON u.email = r.email";                                                        
    /* U */ private final String ATUALIZAR_USUARIO = "UPDATE Usuario SET email=?, senha=? WHERE id=?"; 
    /* U */ private final String ATUALIZAR_ROLE = "UPDATE Usuario SET nome=?, WHERE email=?"; 
    /* U */ private final String ATIVA_DESATIVA = "UPDATE Usuario SET ativo=?, WHERE email=?"; 
    /* D */ private final String DELETAR_ID = "DELETE FROM Usuario WHERE id=?";
    /* D */ private final String DELETAR_EMAIL = "DELETE FROM Usuario WHERE email=?";            

    /* C */ public void inserir_usuario(Usuario usuario) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERIR_USUARIO);
            
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* C */ public void inserir_role(Papel papel) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERIR_ROLE);
            
            statement.setString(1, papel.getEmail());
            statement.setString(2, papel.getNome());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }   
    /* R */ public List<UsuarioRole> get_usuario(String email_desejado){
        List<UsuarioRole> matches = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_USUARIO);
            statement.setString(1, email_desejado);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Integer id = resultSet.getInt("ID");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Boolean ativo = resultSet.getBoolean("ativo");
                String role = resultSet.getString("papel");
                
                UsuarioRole usuario = new UsuarioRole(email, senha, role, ativo, id);
                matches.add(usuario);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return matches; 
    }
    /* R */ public List<Usuario> listar_usuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR_USUARIOS);
            
            while (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Boolean ativo = resultSet.getBoolean("ativo");
                Integer id = resultSet.getInt("id");
                
                Usuario usuario = new Usuario(email, senha, ativo, id);
                usuarios.add(usuario);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios; 
    }
    /* R */ public List<Papel> listar_roles(){
        List<Papel> papeis = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR_ROLES);
            
            while (resultSet.next()) {                
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                Integer id = resultSet.getInt("id");
                
                Papel papel = new Papel(email, nome, id);
                papeis.add(papel);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return papeis; 
    }
    /* R */ public List<UsuarioRole> listar_usuarios_roles(){
        List<UsuarioRole> usuarios = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR_USUARIOS_ROLES);
            
            while (resultSet.next()) {          
                Integer id = resultSet.getInt("ID");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Boolean ativo = resultSet.getBoolean("ativo");
                String role = resultSet.getString("papel");
                
                UsuarioRole usuario = new UsuarioRole(email, senha, role, ativo, id);
                usuarios.add(usuario);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios; 
    }    
    /* U */ public void atualizar_usuario(Usuario usuario) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR_USUARIO);
            
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());          
            statement.setInt(3, usuario.getId());

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* U */ public void atualizar_role(Papel papel) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR_ROLE);
            
            statement.setString(1, papel.getNome());
            statement.setString(2, papel.getEmail());
            

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* U */ public void ativa_desativa(Usuario usuario) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATIVA_DESATIVA);
            
            statement.setBoolean(1, usuario.getAtivo());         
            statement.setInt(2, usuario.getId());

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    /* D */ public void deletar_id(int id) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETAR_ID);

            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* D */ public void deletar_email(String email) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETAR_EMAIL);

            statement.setString(1, email);
            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
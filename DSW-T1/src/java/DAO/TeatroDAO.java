package DAO;

import Models.Papel;
import Models.Teatro;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO{
    /* C */ private final String INSERIR = "INSERT INTO Teatro(email, senha, cidade, nome, cnpj) values (?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Teatro";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Teatro SET email=?, senha=?, cidade=?, nome=?, cnpj=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Teatro WHERE id=?";            
    /* - */ private final String LISTAR_CIDADE = "SELECT * FROM Teatro WHERE cidade LIKE?"; 
    /* - */ private final String GET = "SELECT * FROM Teatro where id=?"; 
    /* - */ private final String GET_EMAIL = "SELECT cnpj FROM Teatro where email = ?";
    
    /* C */ public void inserir(Teatro teatro) throws ClassNotFoundException {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERIR);
            
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCidade());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCnpj());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* R */ public List<Teatro> listar(){
        List<Teatro> teatros = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR);
            
            while (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                Integer id = resultSet.getInt("id");
                
                Teatro teatro = new Teatro(email, senha, cidade, nome, cnpj, id);
                teatros.add(teatro);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return teatros; 
    }
    /* U */ public void atualizar(Teatro teatro) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR);
            
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCidade());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCnpj());            
            statement.setInt(6, teatro.getId());

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* D */ public void deletar(Teatro teatro) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETAR);

            statement.setInt(1, teatro.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* - */ public List<Teatro> listar_cidade(String cidade_desejada){
        List<Teatro> teatros = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(LISTAR_CIDADE);
            statement.setString(1, "%" + cidade_desejada + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                Integer id = resultSet.getInt("id");
                
                Teatro teatro = new Teatro(email, senha, cidade, nome, cnpj, id);
                teatros.add(teatro);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return teatros; 
    }
    /* - */ public Teatro get(int id){     
        Teatro teatro = null;
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                
                teatro = new Teatro(email, senha, cidade, nome, cnpj, id);
            }           
            resultSet.close();
            statement.close();
            connection.close();           
        } catch(SQLException e) {throw new RuntimeException(e);}
        return teatro; 
    }
    /* - */ public String get_email(String email){
        String cnpj_encontrado = "";
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                cnpj_encontrado = resultSet.getString("cnpj");   
            }          
            resultSet.close();
            statement.close();
            connection.close();           
        } catch(SQLException e) {throw new RuntimeException(e);}
        return cnpj_encontrado; 
    }
}

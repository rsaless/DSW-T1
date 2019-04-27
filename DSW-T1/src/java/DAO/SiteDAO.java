package DAO;

import Models.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO extends GenericDAO{
    /* C */ private final String INSERIR = "INSERT INTO Site(email, senha, url, nome, telefone) values (?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Site";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Site SET email=?, senha=?, url=?, nome=?, telefone=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Site WHERE id=?";
    /* - */ private final String GET = "SELECT * FROM Site where id=?"; 
    
    /* C */ public void inserir(Site site) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERIR);
            
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setLong(5, site.getTelefone());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* R */ public List<Site> listar(){
        List<Site> sites = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR);
            
            while (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                Long telefone = resultSet.getLong("telefone");
                Integer id = resultSet.getInt("id");
                
                Site site = new Site(email, senha, url, nome, telefone, id);
                sites.add(site);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return sites; 
    }
    /* U */ public void atualizar(Site site) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR);
            
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setLong(5, site.getTelefone());            
            statement.setInt(6, site.getId());

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* D */ public void deletar(Site site) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETAR);

            statement.setInt(1, site.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* - */ public Site get(int id){     
        Site site = null;
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {                
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                Long telefone = resultSet.getLong("telefone");
                
                site = new Site(email, senha, url, nome, telefone, id);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return site; 
    }
}

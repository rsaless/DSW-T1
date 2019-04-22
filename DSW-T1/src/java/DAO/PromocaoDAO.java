package DAO;

import Models.Promocao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO extends GenericDAO{
    /* C */ private final String INSERIR = "INSERT INTO Promocao(url, nome_peca, preco, dia, hora, cnpj) values (?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Promocao";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Promocao SET url=?, nome_peca=?, preco=?, dia=?, hora=?, cnpj=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Promocao WHERE id=?";
    /* - */ private final String LISTAR_TEATRO = "SELECT * FROM Promocao WHERE cnpj=?"; 
    /* - */ private final String LISTAR_SITE = "SELECT * FROM Promocao WHERE site=?"; 
    /* - */ private final String GET = "SELECT * FROM Promocao where id=?"; 
    
    /* C */ public void inserir(Promocao promocao) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERIR);
            
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getNome_peca());
            statement.setFloat(3, promocao.getPreco());
            statement.setDate(4, Date.valueOf(promocao.getData()));            
            statement.setTime(5, Time.valueOf(promocao.getHora()));
            statement.setInt(6, promocao.getCnpj());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* R */ public List<Promocao> listar(){
        List<Promocao> promocoes = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(LISTAR);
            
            while (resultSet.next()) {                
                String url = resultSet.getString("url");
                String nome_peca = resultSet.getString("nome_peca");
                Float preco = resultSet.getFloat("preco");
                LocalDate dia = resultSet.getDate("dia").toLocalDate();
                LocalTime hora = resultSet.getTime("hora").toLocalTime();
                Integer cnpj = resultSet.getInt("cnpj");
                Integer id = resultSet.getInt("id");
                
                Promocao promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj, id);
                promocoes.add(promocao);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return promocoes; 
    }
    /* U */ public void atualizar(Promocao promocao) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR);
            
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getNome_peca());
            statement.setFloat(3, promocao.getPreco());
            statement.setDate(4, Date.valueOf(promocao.getData()));            
            statement.setTime(5, Time.valueOf(promocao.getHora()));
            statement.setInt(6, promocao.getCnpj());
            statement.setInt(7, promocao.getId());

            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* D */ public void deletar(Promocao promocao) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETAR);

            statement.setInt(1, promocao.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* - */ public List<Promocao> listar_teatro(int cnpj_desejado){
        List<Promocao> promocoes = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(LISTAR_TEATRO);
            statement.setInt(1, cnpj_desejado);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String url = resultSet.getString("url");
                String nome_peca = resultSet.getString("nome_peca");
                Float preco = resultSet.getFloat("preco");
                LocalDate dia = resultSet.getDate("dia").toLocalDate();
                LocalTime hora = resultSet.getTime("hora").toLocalTime();
                Integer cnpj = resultSet.getInt("cnpj");
                Integer id = resultSet.getInt("id");
                
                Promocao promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj, id);
                promocoes.add(promocao);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return promocoes; 
    }
    /* - */ public List<Promocao> listar_site(String url_desejada){
        List<Promocao> promocoes = new ArrayList<>();
        
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(LISTAR_SITE);
            statement.setString(1, url_desejada);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String url = resultSet.getString("url");
                String nome_peca = resultSet.getString("nome_peca");
                Float preco = resultSet.getFloat("preco");
                LocalDate dia = resultSet.getDate("dia").toLocalDate();
                LocalTime hora = resultSet.getTime("hora").toLocalTime();
                Integer cnpj = resultSet.getInt("cnpj");
                Integer id = resultSet.getInt("id");
                
                Promocao promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj, id);
                promocoes.add(promocao);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return promocoes; 
    }
    /* - */ public Promocao get(int id){     
        Promocao promocao = null;
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {                
                String url = resultSet.getString("url");
                String nome_peca = resultSet.getString("nome_peca");
                Float preco = resultSet.getFloat("preco");
                LocalDate dia = resultSet.getDate("dia").toLocalDate();
                LocalTime hora = resultSet.getTime("hora").toLocalTime();
                Integer cnpj = resultSet.getInt("cnpj");
                
                promocao = new Promocao(url, nome_peca, preco, dia, hora, cnpj, id);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao; 
    }
}

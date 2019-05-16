package DAO;

import Models.Promocao;
import Models.Site;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PromocaoDAO extends GenericDAO<Promocao>{
    /* C */ private final String INSERIR = "INSERT INTO Promocao(url, nome, preco, dia, hora, cnpj) values (?,?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Promocao";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Promocao SET url=?, nome=?, preco=?, dia=?, hora=?, cnpj=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Promocao WHERE id=?";
    /* - */ private final String LISTAR_TEATRO = "SELECT * FROM Promocao WHERE cnpj LIKE %:cnpj%"; 
    /* - */ private final String LISTAR_SITE = "SELECT * FROM Promocao WHERE url LIKE %:url%"; 
    /* - */ private final String GET = "SELECT * FROM Promocao where id=?"; 
    
    /* C */ @Override public void inserir(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }
    /* R */ @Override public List<Promocao> listar(){
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR, Promocao.class); // ORIGINAL: select l from Promocao l
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes; 
    }
    /* U */ @Override public void atualizar(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }
    /* D */ @Override public void deletar(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.getId());
        tx.begin();
        em.remove(promocao);
        tx.commit();
    }
    /* - */ @Override public Promocao get(int id){     
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.find(Promocao.class, id);
        em.close();
        return promocao;
    }
    
    /* - */ public List<Promocao> listar_teatro(String cnpj_desejado){
        EntityManager em = this.getEntityManager();
        TypedQuery<Promocao> q = em.createQuery(LISTAR_TEATRO, Promocao.class);
        q.setParameter("cnpj", cnpj_desejado);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes; 
    }
    /* - */ public List<Promocao> listar_site(String url_desejada){
        EntityManager em = this.getEntityManager();
        TypedQuery<Promocao> q = em.createQuery(LISTAR_SITE, Promocao.class);
        q.setParameter("url", url_desejada);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes; 
    }
    
}

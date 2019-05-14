package DAO;

import Models.Teatro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeatroDAO extends GenericDAO<Teatro>{
    /* C */ private final String INSERIR = "INSERT INTO Teatro(email, senha, cidade, nome, cnpj) values (?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Teatro";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Teatro SET email=?, senha=?, cidade=?, nome=?, cnpj=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Teatro WHERE id=?";            
    /* - */ private final String LISTAR_CIDADE = "SELECT * FROM Teatro WHERE cidade LIKE %:cidade%"; 
    /* - */ private final String GET = "SELECT * FROM Teatro where id=?"; 
    /* - */ private final String GET_EMAIL = "SELECT * FROM Teatro where email = :email";
    
    /* C */ @Override public void inserir(Teatro teatro){
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
    /* R */ @Override public List<Teatro> listar(){
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR, Teatro.class); // ORIGINAL: select l from Teatro l
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;  
    }
    /* U */ @Override public void atualizar(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }
    /* D */ @Override public void deletar(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getId());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
    /* - */ @Override public Teatro get(int id){     
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        return teatro;
    }
    
    /* - */ public List<Teatro> listar_cidade(String cidade_desejada){
        EntityManager em = this.getEntityManager();
        TypedQuery<Teatro> q = em.createQuery(LISTAR_CIDADE, Teatro.class); // ORIGINAL: select l from Teatro l
        q.setParameter("cidade", cidade_desejada);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }  
    /* - */ public Teatro get_email(String email){
        EntityManager em = this.getEntityManager();
        TypedQuery<Teatro> q = em.createQuery(GET_EMAIL, Teatro.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }
}
